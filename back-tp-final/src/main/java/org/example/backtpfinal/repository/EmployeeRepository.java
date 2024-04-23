package org.example.backtpfinal.repository;

import org.example.backtpfinal.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

//    @Override
//    Optional<Employee> findById(Long aLong);


    Optional<Employee> findByEmail(String email);
}
