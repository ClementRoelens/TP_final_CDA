package org.example.backtpfinal.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.backtpfinal.entities.Employee;
import org.example.backtpfinal.exception.EmployeeNotFound;
import org.example.backtpfinal.repository.AttendanceRepository;
import org.example.backtpfinal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class EmployeeService implements  IBaseService<Employee>{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;



    @Override
    public Employee save(Employee element) {
        return employeeRepository.save(element);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(UUID id) throws EmployeeNotFound {

        Employee employee = employeeRepository.findEmployeeById(id);

        if (employee == null) {
            throw new EmployeeNotFound(id);
        }

        return employee;
    }

    @Override
    public Employee update(Employee element) {
        return null;
    }



    @Override
    public void deleteById(UUID id) {

    }
}
