package org.example.backtpfinal.repository;

import org.example.backtpfinal.entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    Optional<Attendance> findAllAttendanceById(Long id);

}
