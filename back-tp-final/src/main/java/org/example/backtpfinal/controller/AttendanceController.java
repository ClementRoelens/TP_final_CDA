package org.example.backtpfinal.controller;

import org.example.backtpfinal.entities.Attendance;
import org.example.backtpfinal.service.AttendanceService;
import org.example.backtpfinal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    @Autowired
    private  AttendanceService attendanceService;
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/clockIn")
    public ResponseEntity<String> clockIn(@RequestBody Long employeeId) {
        String message = attendanceService.clockIn(employeeId);
        System.out.println("Hoop in!!!");
        return ResponseEntity.ok(message);
    }

    @PostMapping("/clockOut")
    public ResponseEntity<String> clockOut(@RequestBody Long employeeId) {
        String message = attendanceService.clockOut(employeeId);
        return ResponseEntity.ok(message);
    }


}
