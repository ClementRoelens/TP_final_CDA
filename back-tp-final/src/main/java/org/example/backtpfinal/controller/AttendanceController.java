package org.example.backtpfinal.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.backtpfinal.dto.AttendanceDTO;

import org.example.backtpfinal.entities.Attendance;
import org.example.backtpfinal.entities.Employee;
import org.example.backtpfinal.exception.EmployeeNotFound;
import org.example.backtpfinal.repository.AttendanceRepository;
import org.example.backtpfinal.service.AttendanceService;
import org.example.backtpfinal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


@RestController
@RequestMapping("/api/attendance")
@CrossOrigin(origins = "*")
@Slf4j
public class AttendanceController {
    @Autowired
    private  AttendanceService attendanceService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AttendanceRepository attendanceRepository;


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

    @GetMapping("/hours-day/{employeeId}") //http://localhost:8080/api/attendance/hours-day/{employeeId}?date={date}
    public ResponseEntity<Double> calculateHoursWorkedForDay(
                @PathVariable Long employeeId, @RequestParam LocalDate date) {
            Employee employee = employeeService.getById(employeeId)
                    .orElseThrow(() -> new EmployeeNotFound(employeeId));

            double hoursWorked = attendanceService.calculateHoursWorkedByEmployeeForDay(date, employee);

            return ResponseEntity.ok(hoursWorked);

    }
    @GetMapping("/{employeeId}/overtime") //http://localhost:8090/api/attendance/{id}/overtime
    public ResponseEntity<Duration> getOvertimeForWeek(@PathVariable Long employeeId) {
        Duration overtime = attendanceService.overtimeByWeek(employeeId);
        return ResponseEntity.ok(overtime);
    }

    @GetMapping("week/{employeeId}")//http://localhost:8090/api/attendance/week/{id}?startDate=2024-04-25&endDate=2024-04-30
    public ResponseEntity<Double> getEmployeeHoursForWeek(@PathVariable Long employeeId, @RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) throws EmployeeNotFound {
       
        Employee employee = employeeService.getById(employeeId)
                .orElseThrow(() -> new EmployeeNotFound(employeeId));

        Duration hoursByEmployeeForWeek = attendanceService.calculateHoursWorkedByEmployeeForWeek(startDate, endDate, employee);
        double totalHours = hoursByEmployeeForWeek.toMinutes() / 60.0;

        return ResponseEntity.ok(totalHours);
    }


}
