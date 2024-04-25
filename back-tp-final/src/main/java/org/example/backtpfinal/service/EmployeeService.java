package org.example.backtpfinal.service;


import org.example.backtpfinal.config.jwt.JwtTokenProvider;
import org.example.backtpfinal.dto.EmployeeDTO;
import org.example.backtpfinal.entities.Employee;
import org.example.backtpfinal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.example.backtpfinal.exception.EmployeeNotFound;
import org.example.backtpfinal.repository.AttendanceRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements UserDetailsService, IBaseService<Employee> {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider tokenProvider;
    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Employee save(Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll()
//                .stream().map(this::reduceEmployee).toList()
                ;
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

    public boolean verifyEmployee(String email, String password) {
        return employeeRepository.findByEmail(email)
                .map(employee -> passwordEncoder.matches(password, employee.getPassword()))
                .orElseThrow(() -> new UsernameNotFoundException("Employee not found with email:" + email));
    }

    public boolean checkEmployeeNameExist(String email) {
        return employeeRepository.findByEmail(email).isPresent();
    }

    public String generateToken(String email, String password, Collection<? extends GrantedAuthority> authorities) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password, authorities));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return tokenProvider.generateToken(authentication);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return employeeRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Employee not found with email: " + email));
    }

    public boolean compareUserWithToken(Employee employee, String token) {
        return tokenProvider.getUsernameFromToken(token).equals(employee.getEmail());
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
                .address(dto.getAddress().toEntity())
                .build();
        System.out.println(employee);
        return employeeRepository.save(employee);

    }
}
