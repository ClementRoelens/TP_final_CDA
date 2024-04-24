package org.example.backtpfinal.service;

import org.example.backtpfinal.entities.Attendance;
import org.example.backtpfinal.entities.Employee;
import org.example.backtpfinal.exception.EmployeeNotFound;
import org.example.backtpfinal.repository.AttendanceRepository;
import org.example.backtpfinal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
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

    public String clockIn(Long employeeId) throws EmployeeNotFound {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFound(employeeId));

        Attendance attendance =  Attendance.builder()
                .employee(employee)
                .start(LocalDateTime.now())
                .build();

        attendanceRepository.save(attendance);
        return "Clock in successful";
    }


    public String clockOut(Long employeeId)throws  EmployeeNotFound, IllegalStateException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFound(employeeId));

        Optional<Attendance> lastestAttendance = attendanceRepository.findAllAttendanceById(employeeId);
        if (lastestAttendance.isPresent() && lastestAttendance.get().getEnd() == null) {
            lastestAttendance.get().setEnd(LocalDateTime.now());
            attendanceRepository.save(lastestAttendance.get());
            return "Clock out successful";
        } else {
            throw new IllegalStateException("Employee with ID " + employeeId + " cannot clock out without clocking in first.");
        }
    }
    public double hoursWorkedDaily(Attendance attendance) {
        if (attendance.getStart() == null || attendance.getEnd() == null) {
            throw new IllegalArgumentException("Attendance record must have both start and end times set.");
        }

        LocalDateTime start = attendance.getStart();
        LocalDateTime end = attendance.getEnd();

        Duration duration = Duration.between(start, end);
        double hours = (double) duration.toHours();

        return hours;
    }
    public Duration overtimeByWeek(Long employeeId) {
        Optional<Attendance> optionalAttendances = attendanceRepository.findAllAttendanceById(employeeId);

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
}
