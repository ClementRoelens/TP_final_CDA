package org.example.backtpfinal.repository;

import org.example.backtpfinal.entities.Attendance;
import org.example.backtpfinal.entities.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    @Modifying
    @Query("SELECT a FROM Attendance a WHERE a.employee.id = :employeeId")
    Optional<Attendance> findAllAttendanceById(@Param("employeeId") Long employeeId);



    @Query("SELECT a FROM Attendance a WHERE a.employee.id = :employeeId ORDER BY a.start DESC LIMIT 1")
    Optional<Attendance> findLatestAttendanceByEmployeeId(@Param("employeeId") Long employeeId);

    @Query("SELECT a FROM Attendance a WHERE a.start >= :date AND a.start < :currDate ORDER BY a.start ASC")
    Optional<Attendance> getByDate(@Param("date") LocalDateTime date, @Param("currDate") LocalDateTime currDate);





}