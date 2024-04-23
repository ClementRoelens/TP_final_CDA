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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<Employee> createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) throws EmployeeNotFound {
        Employee employee = employeeDTO.toEntity();
        if (employeeDTO.getAddress() == null) {
            employee.setAddress(addressService.getById(employeeDTO.getAddressId()));
        } else {
            addressService.save(employee.getAddress());
        }
        Employee newEmployee = employeeService.save(employee);
        return ResponseEntity.ok(newEmployee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        try {
            Employee employee = employeeService.getById(id);
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
    public ResponseEntity<List<Attendance>> getAllAttendanceByEmployeeId(@PathVariable long employeeId, Attendance attendance) {
        List<Attendance> attendanceList = employeeService.getById(employeeId).getAttendancesList();
        return new ResponseEntity<>(List.copyOf(attendanceList), HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signin(@RequestBody CredentialsDTO credentials) {
        if (employeeService.verifyEmployee(credentials.getEmail(), credentials.getPassword())) {
            return new ResponseEntity<>(employeeService.generateToken(credentials.getEmail(), credentials.getPassword()), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Aucun employé ne correspond à cet email", HttpStatus.NOT_FOUND);
    }

}
