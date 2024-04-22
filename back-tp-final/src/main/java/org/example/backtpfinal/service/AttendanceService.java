package org.example.backtpfinal.service;

import org.example.backtpfinal.entities.Attendance;
import org.example.backtpfinal.entities.Employee;
import org.example.backtpfinal.repository.AttendanceRepository;
import org.example.backtpfinal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class AttendanceService {

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

}
