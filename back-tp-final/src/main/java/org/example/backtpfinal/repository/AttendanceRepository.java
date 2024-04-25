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


    Optional<List<Attendance>> findAllAttendanceById(Long employeeId);




    @Query("SELECT a FROM Attendance a WHERE a.employee.id = :employeeId ORDER BY a.start DESC LIMIT 1")
    Optional<Attendance> findLatestAttendanceByEmployeeId(@Param("employeeId") Long employeeId);



    @Query("SELECT a FROM Attendance a WHERE a.start >= :startDate AND a.start < :endDate AND a.employee = :employee")
    List<Attendance> getAttendanceByDay(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("employee") Employee employee);

    /*@Query("SELECT a FROM Attendance a WHERE a.employee = ?1 AND a.start BETWEEN ?2 AND ?3")
    List<Attendance> getAttendanceByEmployeeByWeek(Employee employee, LocalDateTime startDate, LocalDateTime endDate);
*/
    @Query("SELECT a FROM Attendance a WHERE a.employee.id = ?1 AND a.start >= ?2 AND a.end <= ?3")
    List<Attendance> getAttendanceByEmployeeByWeek(Long employeeId, LocalDateTime startDate, LocalDateTime endDate);


}
