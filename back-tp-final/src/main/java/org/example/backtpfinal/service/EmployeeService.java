package org.example.backtpfinal.service;


import org.example.backtpfinal.dto.AddressDTO;
import org.example.backtpfinal.dto.EmployeeDTO;
import org.example.backtpfinal.entities.Address;
import org.example.backtpfinal.entities.Employee;
import org.example.backtpfinal.exception.EmployeeNotFound;
import org.example.backtpfinal.repository.AttendanceRepository;
import org.example.backtpfinal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Employee> getById(Long id) throws EmployeeNotFound {

        Employee employee = employeeRepository.findEmployeeById(id);

        if (employee == null) {
            throw new EmployeeNotFound(id);
        }

        return Optional.of(employee);
    }

    @Override
    public Employee update(Employee element) {
        return null;
    }



    @Override
    public void deleteById(Long id) {

    }

    public Employee save(EmployeeDTO dto) {
        Employee employee = Employee
                .builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .birthDate(dto.getBirthDate())
                .gender(dto.getGender())
                .email(dto.getEmail())
                .pay(dto.getPay())
                .password(dto.getPassword())
                .role(dto.getRole())
                .photoPath(dto.getPhotoPath())
                .address(dto.getAddress())
                .build();
        System.out.println(employee);
        return employeeRepository.save(employee);

    }
}
