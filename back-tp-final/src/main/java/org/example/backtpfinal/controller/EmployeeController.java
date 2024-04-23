package org.example.backtpfinal.controller;

import jakarta.validation.Valid;
import org.example.backtpfinal.dto.EmployeeDTO;
import org.example.backtpfinal.entities.Attendance;
import org.example.backtpfinal.entities.Employee;
import org.example.backtpfinal.exception.EmployeeNotFound;
import org.example.backtpfinal.service.AttendanceService;
import org.example.backtpfinal.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


    private EmployeeService employeeService;
    private AttendanceService attendanceService;

    private ModelMapper modelMapper;

    @Autowired
    public EmployeeController(EmployeeService employeeService, AttendanceService attendanceService) {
        this.employeeService = employeeService;
        this.attendanceService = attendanceService;
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) throws EmployeeNotFound{
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
       /* Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        // Continuer avec les autres attributs...*/
        Employee newEmployee = employeeService.save(employee);
        return ResponseEntity.ok(newEmployee);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Long id){
        try {
            Optional<Employee> employee = employeeService.getById(id);
            return  ResponseEntity.ok(employee);
        }catch (EmployeeNotFound e){
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/{employeeId}/attendance")
    public ResponseEntity<List<Attendance>> getAllAttendanceByEmployeeId(@PathVariable Long employeeId){
        List<Attendance> attendanceList = employeeService.getById(employeeId).orElseThrow().getAttendancesList();
        return  new ResponseEntity<>(List.copyOf(attendanceList), HttpStatus.OK);
    }



}
