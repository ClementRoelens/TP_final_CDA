package org.example.backtpfinal.repository;

import org.example.backtpfinal.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Optional<Employee> findEmployeeById(Long id);


}
