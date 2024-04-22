package org.example.backtpfinal.controller;

import org.example.backtpfinal.entities.Attendance;
import org.example.backtpfinal.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    @Autowired
    private  AttendanceService attendanceService;


}
