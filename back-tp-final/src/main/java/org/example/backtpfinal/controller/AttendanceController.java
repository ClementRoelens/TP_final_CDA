package org.example.backtpfinal.controller;

import org.example.backtpfinal.dto.AttendanceDTO;
import org.example.backtpfinal.entities.Attendance;
import org.example.backtpfinal.service.AttendanceService;
import org.example.backtpfinal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    @Autowired
    private  AttendanceService attendanceService;
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/clockIn")
    public ResponseEntity<LocalDateTime> clockIn(@RequestBody AttendanceDTO dto) {
        LocalDateTime  clockInTime  = LocalDateTime.now();
        LocalDateTime startTime = attendanceService.clockIn(dto.getId(),clockInTime);

        System.out.println("Hoop in!!! " + startTime);
        return ResponseEntity.ok(startTime);
    }

    @PostMapping("/clockOut")
    public ResponseEntity<LocalDateTime> clockOut(@RequestBody AttendanceDTO dto) {
        LocalDateTime  clockOutTime  = LocalDateTime.now();
        LocalDateTime endTime = attendanceService.clockOut(dto.getId(), clockOutTime);
        System.out.println("Hoop out!!! " + endTime);
        return ResponseEntity.ok(endTime);
    }
    @GetMapping("/getHours/{id}")
    public ResponseEntity<Double> getHoursWorked(@PathVariable Long id) throws IllegalArgumentException{
        Attendance attendance = (Attendance) attendanceService.getAttendanceFromSelectedDate();
        double hours = attendanceService.hoursWorkedDaily(attendance);
        return ResponseEntity.ok(hours);
    }

}
