package org.example.backtpfinal.service;


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
public class AttendanceService implements IBaseService<Attendance> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;



    public List<Attendance> getAllAttendanceByEmployeeId(Long idEmployee) {
        Employee employee = employeeRepository.findEmployeeById(idEmployee);
        if (employee != null) {

            return employee.getAttendancesList();
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
    /*public List<Attendance> getAttendanceFromSelectedDate(Date date, Date currDate, Employee e) {
        LocalDateTime localDate = date.toLocalDate().atStartOfDay();// 00:00:00.
        LocalDateTime localCurrDate = currDate.toLocalDate().atStartOfDay().plusDays(1);
        return attendanceRepository.getAttendanceByDay(localDate, localCurrDate, e);
    }*/


    public LocalDateTime clockIn(Long employeeId, LocalDateTime clockInTime) throws EmployeeNotFound {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFound(employeeId));

        Attendance attendance =  Attendance.builder()
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

    public double calculateHoursWorkedByEmployeeForDay(LocalDate date, Employee e) {
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
    }

    public Duration overtimeByWeek(Long employeeId) {
        Optional<List<Attendance>> optionalAttendances = attendanceRepository.findAllAttendanceById(employeeId);

        if (optionalAttendances.isPresent()) {
            List<Attendance> attendances = (List<Attendance>) optionalAttendances.get();

            // Calculate daily working hours for all valid attendances
            //Converts the List<Attendance> into stream
            Duration dailyWorkingHours = attendances.stream()
                    //keeps only  Attendance objects where the end time is not null.
                    .filter(a -> a.getEnd() != null)
                    //transforms each Attendance object into a Duration object
                    .map(a -> Duration.between(a.getStart(), a.getEnd()))
                    //combines all the Duration objects obtained from the map operation into a single Duration value
                    .reduce(Duration.ZERO, Duration::plus);

            // standard 35 heures
            Duration standardWeeklyWork = Duration.ofHours(35);
            Duration overtime = dailyWorkingHours.minus(standardWeeklyWork);

            return overtime.isNegative() ? Duration.ZERO : overtime;
        }else {
            return Duration.ZERO;
        }
    }
    public Duration calculateHoursWorkedByEmployeeForWeek(LocalDateTime startDate, LocalDateTime endDate, Employee employee) {
         // between 2 dates definite
        List<Attendance> attendances = attendanceRepository.getAttendanceByEmployeeByWeek(employee, startDate, endDate);

        Duration totalWorkingDuration = Duration.ZERO;
        for (Attendance attendance : attendances) {
            LocalDateTime clockIn = attendance.getStart();
            LocalDateTime clockOut = attendance.getEnd();
            if (attendance.getStart() != null && attendance.getEnd() != null) {
                Duration attendanceDuration = Duration.between(clockIn,clockOut);
                totalWorkingDuration = totalWorkingDuration.plus(attendanceDuration);
            }
        }

        return totalWorkingDuration;
    }
}
