package org.example.backtpfinal.service;


import lombok.extern.slf4j.Slf4j;
import org.example.backtpfinal.entities.Attendance;
import org.example.backtpfinal.entities.Employee;
import org.example.backtpfinal.exception.EmployeeNotFound;
import org.example.backtpfinal.repository.AttendanceRepository;
import org.example.backtpfinal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


@Service
@Slf4j
public class AttendanceService implements IBaseService<Attendance> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;


    public List<Attendance> getAllAttendanceByEmployeeId(Long idEmployee) {
        Optional<Employee> employee = employeeRepository.findEmployeeById(idEmployee);
        if (employee != null) {

            return employee.get().getAttendancesList();
        }
        return Collections.emptyList();
    }

    public Attendance findLastClockingPoint(Long employeeId) {
        Optional<Attendance> attendanceOptional = attendanceRepository.findLatestAttendanceByEmployeeId(employeeId);
        return attendanceOptional.orElse(null);
    }

    @Override
    public Attendance save(Attendance element) {
        return attendanceRepository.save(element);
    }

    @Override
    public List<Attendance> getAll() {
        return attendanceRepository.findAll();
    }

    @Override
    public Optional<Attendance> getById(Long id) {
        return Optional.of(attendanceRepository.getById(id));
    }

    @Override
    public Attendance update(Attendance element) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }



    public LocalDateTime clockIn(Long employeeId, LocalDateTime clockInTime) throws EmployeeNotFound {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFound(employeeId));

        Attendance attendance = Attendance.builder()
                .employee(employee)
                .start(LocalDateTime.now())
                .build();

        attendanceRepository.save(attendance);
        return attendance.getStart();
    }


    public LocalDateTime clockOut(Long employeeId, LocalDateTime clockOutTime) throws EmployeeNotFound {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFound(employeeId));

        Optional<Attendance> latestAttendanceOptional = attendanceRepository.findLatestAttendanceByEmployeeId(employeeId);
        if (latestAttendanceOptional.isPresent()) {
            Attendance latestAttendance = latestAttendanceOptional.get();
            latestAttendance.setEnd(LocalDateTime.now());
            attendanceRepository.save(latestAttendance);
            return latestAttendance.getEnd();
        } else {
            System.out.println("Employee with ID " + employeeId + " cannot clock out without clocking in first.");
            throw new IllegalArgumentException("No attendance found for employee ID: " + employeeId);
        }
    }

    /*public double calculateHoursWorkedByEmployeeForDay(LocalDate date, Employee e) {
        LocalDateTime startDate = date.atStartOfDay();
        LocalDateTime endDate = startDate.withHour(23).withMinute(59).withSecond(59);
        List<Attendance> attendances = this.attendanceRepository.getAttendanceByDay(startDate, endDate, e);

        Duration totalWorkingDuration = Duration.ZERO;
        for (Attendance attendance : attendances) {
            LocalDateTime clockIn = attendance.getStart();
            LocalDateTime clockOut = attendance.getEnd();

            if (clockIn != null && clockOut != null) {
                Duration attendanceDuration = Duration.between(clockIn, clockOut);
                totalWorkingDuration = totalWorkingDuration.plus(attendanceDuration);
            }
        }

        //convert in hour
        double totalWorkingHours = totalWorkingDuration.toMinutes() / 60.0;
        return totalWorkingHours;
    }*/
    public double calculateHoursWorkedByEmployeeForDay(LocalDate date, Long employeeId) {
        // Recherche de l'employé par son ID
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFound(employeeId));

        // Détermination de la période de la journée
        LocalDateTime startDate = date.atStartOfDay();
        LocalDateTime endDate = startDate.withHour(23).withMinute(59).withSecond(59);

        // Récupération des pointages de l'employé pour la journée donnée
        List<Attendance> attendances = this.attendanceRepository.getAttendanceByDay(startDate, endDate, employee);

        // Calcul de la durée totale de travail
        Duration totalWorkingDuration = Duration.ZERO;
        for (Attendance attendance : attendances) {
            LocalDateTime clockIn = attendance.getStart();
            LocalDateTime clockOut = attendance.getEnd();

            if (clockIn != null && clockOut != null) {
                Duration attendanceDuration = Duration.between(clockIn, clockOut);
                totalWorkingDuration = totalWorkingDuration.plus(attendanceDuration);
            }
        }

        // Conversion de la durée totale de travail en heures
        double totalWorkingHours = totalWorkingDuration.toMinutes() / 60.0;
        return totalWorkingHours;
    }




    public Duration overtimeByWeek(Long employeeId, LocalDateTime startDate, LocalDateTime endDate) {
        Duration totalHours = Duration.ZERO;
        LocalDate currentDate = startDate.toLocalDate();


        while (!currentDate.isAfter(endDate.toLocalDate())) {
            totalHours = totalHours.plus(Duration.ofHours((long) calculateHoursWorkedByEmployeeForDay(currentDate, employeeId)));
            currentDate = currentDate.plusDays(1);
        }


        Duration standardWeeklyWork = Duration.ofHours(35);


        Duration overtime = totalHours.minus(standardWeeklyWork);
        return overtime.isNegative() ? Duration.ZERO : overtime;
    }





    /*public Duration calculateHoursWorkedByEmployeeForWeek(LocalDateTime startDate, LocalDateTime endDate, Long employeeId) {
        // between 2 dates definite
        List<Attendance> attendances = attendanceRepository.getAttendanceByEmployeeByWeek(employeeId, startDate, endDate);
        log.info("id" + employeeId);
        Duration totalWorkingDuration = Duration.ZERO;
        for (Attendance attendance : attendances) {
            LocalDateTime clockIn = attendance.getStart();
            LocalDateTime clockOut = attendance.getEnd();
            if (attendance.getStart() != null && attendance.getEnd() != null) {
                Duration attendanceDuration = Duration.between(clockIn, clockOut);
                totalWorkingDuration = totalWorkingDuration.plus(attendanceDuration);
            }
        }

        return totalWorkingDuration;
    }*/
    public Duration calculateHoursWorkedByEmployeeForWeek(LocalDateTime startDate, LocalDateTime endDate, Long employeeId) {
        Duration totalWorkingDuration = Duration.ZERO;
        LocalDate currentDate = startDate.toLocalDate();


        while (!currentDate.isAfter(endDate.toLocalDate())) {
            totalWorkingDuration = totalWorkingDuration.plus(Duration.ofHours((long) calculateHoursWorkedByEmployeeForDay(currentDate, employeeId)));
            currentDate = currentDate.plusDays(1);
        }

        return totalWorkingDuration;
    }




}

