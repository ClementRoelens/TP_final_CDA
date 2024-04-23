package org.example.backtpfinal.controller;

import org.example.backtpfinal.entities.Attendance;
import org.example.backtpfinal.service.AttendanceService;
import org.example.backtpfinal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/attendances")
public class AttendanceController {
    @Autowired
    private  AttendanceService attendanceService;
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/clockIn")
<<<<<<< HEAD
    public ResponseEntity<String> clockIn(@RequestBody long employeeId) {
=======
    public ResponseEntity<String> clockIn(@RequestBody Long employeeId) {
>>>>>>> app-mobile-viewSchedule
        String message = attendanceService.clockIn(employeeId);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/clockOut")
<<<<<<< HEAD
    public ResponseEntity<String> clockOut(@RequestBody long employeeId) {
=======
    public ResponseEntity<String> clockOut(@RequestBody Long employeeId) {
>>>>>>> app-mobile-viewSchedule
        String message = attendanceService.clockOut(employeeId);
        return ResponseEntity.ok(message);
    }

}
