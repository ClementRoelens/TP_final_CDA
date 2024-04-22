package org.example.backtpfinal.service;

import org.example.backtpfinal.repository.AttendanceRepository;
import org.example.backtpfinal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class EmployeeService implements  IBaseService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;


    @Override
    public Object save(Object element) {
        return null;
    }

    @Override
    public List getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Object update(Object element) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
