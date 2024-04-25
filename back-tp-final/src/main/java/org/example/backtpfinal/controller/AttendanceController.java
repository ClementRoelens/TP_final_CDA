package org.example.backtpfinal.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.backtpfinal.dto.AttendanceDTO;

import org.example.backtpfinal.entities.Employee;
import org.example.backtpfinal.exception.EmployeeNotFound;
import org.example.backtpfinal.repository.AttendanceRepository;
import org.example.backtpfinal.service.AttendanceService;
import org.example.backtpfinal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;



@RestController
@RequestMapping("/api/attendance")
@CrossOrigin(origins = "*")
@Slf4j
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

    @GetMapping("/hours-day/{employeeId}") //http://localhost:8080/api/attendance/hours-day/{employeeId}?date={date}
    public ResponseEntity<Double> calculateHoursWorkedForDay(
                @PathVariable Long employeeId, @RequestParam LocalDate date) {
            Employee employee = employeeService.getById(employeeId)
                    .orElseThrow(() -> new EmployeeNotFound(employeeId));

            double hoursWorked = attendanceService.calculateHoursWorkedByEmployeeForDay(date, employeeId);

            return ResponseEntity.ok(hoursWorked);

    }

    @GetMapping("/overtime/{employeeId}")// http://localhost:8090/api/attendance/overtime/{employeeId}
    public ResponseEntity<Duration> getOvertimeForWeek(@PathVariable Long employeeId,
                                                       @RequestParam LocalDate startDate,
                                                       @RequestParam LocalDate endDate) {
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atStartOfDay().plusDays(1).minusNanos(1);
        Employee employee = employeeService.getById(employeeId)
                .orElseThrow(() -> new EmployeeNotFound(employeeId));
        Duration overtime = attendanceService.overtimeByWeek(employeeId, startDateTime, endDateTime);
        return ResponseEntity.ok(overtime);
    }


    @GetMapping("/week/{employeeId}") //http://localhost:8090/api/attendance/week/{id}?startDate=2024-04-25&endDate=2024-04-30
    public ResponseEntity<Double> getEmployeeHoursForWeek(@PathVariable Long employeeId, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate) throws EmployeeNotFound {
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atStartOfDay().plusDays(1).minusNanos(1); //sure that day ended by 23:59:59
        Employee employee = employeeService.getById(employeeId)
                .orElseThrow(() -> new EmployeeNotFound(employeeId));

        Duration hoursByEmployeeForWeek = attendanceService.calculateHoursWorkedByEmployeeForWeek( startDateTime, endDateTime, employeeId);
        double totalHours = hoursByEmployeeForWeek.toMinutes() / 60.0;

        return ResponseEntity.ok(totalHours);
    }



}
