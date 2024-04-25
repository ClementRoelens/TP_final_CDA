package org.example.backtpfinal.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.example.backtpfinal.dto.CredentialsDTO;
import org.example.backtpfinal.dto.EmployeeDTO;
import org.example.backtpfinal.entities.Address;
import org.example.backtpfinal.entities.Attendance;
import org.example.backtpfinal.entities.Employee;
import org.example.backtpfinal.exception.EmployeeNotFound;
import org.example.backtpfinal.service.AddressService;
import org.example.backtpfinal.service.AttendanceService;
import org.example.backtpfinal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(employeeService.getById(id).orElse(null).toDTO());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/byMail/{email}")
    public ResponseEntity<Object> getEmployeeByEmail(@PathVariable String email, HttpServletRequest request){
        Employee employee = (Employee) employeeService.loadUserByUsername(email);
        if (employee != null){
            if (employeeService.compareUserWithToken(employee, request.getHeader("Authorization").substring(7))){
                return ResponseEntity.ok(employee.toDTO());
            }
            return new ResponseEntity<>("Vous tentez d'accéder à des informations ne vous appartenant pas", HttpStatus.UNAUTHORIZED);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping()
    public List<EmployeeDTO> getAll() {
        return employeeService.getAll().stream().map(Employee::toDTO).toList();
    }

    @GetMapping("/{employeeId}/attendance")
    public ResponseEntity<List<Attendance>> getAllAttendanceByEmployeeId(@PathVariable Long employeeId) {
        List<Attendance> attendanceList = employeeService.getById(employeeId).orElseThrow().getAttendancesList();
        return new ResponseEntity<>(List.copyOf(attendanceList), HttpStatus.OK);
    }



}
