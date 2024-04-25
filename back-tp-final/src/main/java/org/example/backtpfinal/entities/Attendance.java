package org.example.backtpfinal.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Builder
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime start;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime end;
    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    public void setId(Long id) {
        this.id = id;
    }
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    public LocalDateTime getEnd() {
        return end;
    }

    public Attendance() {
    }

    public Attendance(Long id, LocalDateTime start, LocalDateTime end, Employee employee) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.employee = employee;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", start=" + start +
                ", end=" + end +
                ", employee=" + employee +
                '}';
    }
}
