package org.example.backtpfinal.repository;

import org.example.backtpfinal.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    Employee findEmployeeById(UUID id);
    Optional<Employee> findByEmail(String email);
}
