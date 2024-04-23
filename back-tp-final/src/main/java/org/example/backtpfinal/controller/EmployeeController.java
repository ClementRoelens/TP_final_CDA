package org.example.backtpfinal.controller;

import jakarta.validation.Valid;
import org.example.backtpfinal.dto.AddressDTO;
import org.example.backtpfinal.dto.CredentialsDTO;
import org.example.backtpfinal.dto.EmployeeDTO;
import org.example.backtpfinal.entities.Address;
import org.example.backtpfinal.entities.Attendance;
import org.example.backtpfinal.entities.Employee;
import org.example.backtpfinal.exception.EmployeeNotFound;
import org.example.backtpfinal.service.AddressService;
import org.example.backtpfinal.service.AttendanceService;
import org.example.backtpfinal.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


    private final EmployeeService employeeService;
    private final AttendanceService attendanceService;
    private final AddressService addressService;


    @Autowired
    public EmployeeController(EmployeeService employeeService, AttendanceService attendanceService, AddressService addressService) {
        this.employeeService = employeeService;
        this.attendanceService = attendanceService;
        this.addressService = addressService;
    }

    @PostMapping()
    public ResponseEntity<Object> createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) throws EmployeeNotFound {
        Employee employee = employeeDTO.toEntity();
        Address address = addressService.save(employee.getAddress());
        employee.setAddress(address);
        employeeService.save(employee);
        return ResponseEntity.ok(employee.toDTO());
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signin(@RequestBody CredentialsDTO credentials) {
        if (employeeService.verifyEmployee(credentials.getEmail(), credentials.getPassword())) {
            Employee employee = (Employee) employeeService.loadUserByUsername(credentials.getEmail());
            return new ResponseEntity<>(employeeService.generateToken(credentials.getEmail(), credentials.getPassword(), employee.getAuthorities()), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Aucun employé ne correspond à cet email", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Long id) {
        try {
            Optional<Employee> employee = employeeService.getById(id);
            return ResponseEntity.ok(employee);
        } catch (EmployeeNotFound e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{employeeId}/attendance")
    public ResponseEntity<List<Attendance>> getAllAttendanceByEmployeeId(@PathVariable Long employeeId) {
        List<Attendance> attendanceList = employeeService.getById(employeeId).orElseThrow().getAttendancesList();
        return new ResponseEntity<>(List.copyOf(attendanceList), HttpStatus.OK);
    }



}
