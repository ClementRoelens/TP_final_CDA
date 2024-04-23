package org.example.backtpfinal.service;

import org.example.backtpfinal.entities.Attendance;
import org.example.backtpfinal.entities.Employee;
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

    public List<Attendance> getAllAttendanceByEmployeeId(UUID idEmployee) {
        Employee employee = employeeRepository.findEmployeeById(idEmployee);
        if (employee != null) {

            return employee.getAttendancesList();
        }
        return Collections.emptyList();
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
    public Attendance getById(UUID id) {
        return attendanceRepository.getById(id);
    }

    @Override
    public Attendance update(Attendance element) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }

    public String clockIn(UUID employeeId) {
        Attendance attendance = new Attendance();
        attendance.setStart(LocalDateTime.now());
        attendance.setId(employeeId); // Utilisation de setId avec l'UUID de l'employé
        attendanceRepository.save(attendance);
        return "Clock in successful";
    }


    public String clockOut(UUID employeeId) {
        Optional<Attendance> lastAttendance = attendanceRepository.findAllAttendanceById(employeeId);
        if (lastAttendance.isPresent() && lastAttendance.get().getEnd() == null) {
            lastAttendance.get().setEnd(LocalDateTime.now());
            attendanceRepository.save(lastAttendance.get());
            return "Clock out successful";
        } else {
            return "No clock in record found for this employee";
        }
    }
    public Duration calculateOvertime(UUID employeeId) {
        Optional<Attendance> optionalAttendances = attendanceRepository.findAllAttendanceById(employeeId);

        if (optionalAttendances.isPresent()) {
            List<Attendance> attendances = (List<Attendance>) optionalAttendances.get();
            Duration totalWorkingHours = Duration.ZERO;

            for (Attendance a : attendances) {
                LocalDateTime start = a.getStart();
                LocalDateTime end = a.getEnd();
                if (end != null) {
                    totalWorkingHours = totalWorkingHours.plus(Duration.between(start, end));
                }
            }

            // Suppose que les heures supplémentaires sont toutes les heures travaillées au-delà de la semaine de travail standard (par exemple, 35 heures)
            Duration standardWorkWeek = Duration.ofHours(35);
            Duration overtime = totalWorkingHours.minus(standardWorkWeek);

            return overtime.isNegative() ? Duration.ZERO : overtime;
        }else {
            // Gérer le cas où aucune présence n'est trouvée pour l'employé
            return Duration.ZERO;
        }
    }
}
