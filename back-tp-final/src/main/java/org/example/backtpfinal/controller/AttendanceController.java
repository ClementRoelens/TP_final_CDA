package org.example.backtpfinal.controller;

import org.example.backtpfinal.entities.Attendance;
import org.example.backtpfinal.service.AttendanceService;
import org.example.backtpfinal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/attendances")
public class AttendanceController {
    @Autowired
    private  AttendanceService attendanceService;
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/clockIn")
    public ResponseEntity<String> clockIn(@RequestBody long employeeId) {
        String message = attendanceService.clockIn(employeeId);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/clockOut")
    public ResponseEntity<String> clockOut(@RequestBody long employeeId) {
        String message = attendanceService.clockOut(employeeId);
        return ResponseEntity.ok(message);
    }

}
