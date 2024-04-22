package org.example.backtpfinal.controller;

import lombok.NoArgsConstructor;
import org.example.backtpfinal.entities.Attendance;
import org.example.backtpfinal.entities.Employee;
import org.example.backtpfinal.service.AttendanceService;
import org.example.backtpfinal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/{id")
    public  ResponseEntity<Optional> getEmployeeById(@PathVariable UUID id){
        Optional employee = employeeService.getById(id);
        if (employee != null){
            return  ResponseEntity.ok(employee);
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/{employeeId")
    public List<Attendance> getAllAttendanceByEmployeeId(@PathVariable UUID employeeId){
        return  attendanceService.getAllAttendanceByEmployeeId(employeeId);
    }



}
