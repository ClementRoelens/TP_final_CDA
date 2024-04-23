package org.example.backtpfinal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity

public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int workedHoursRate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    public Report() {
    }

    public Report(Long id, int workedHoursRate, LocalDateTime startDate, LocalDateTime endDate, Employee employee) {
        this.id = id;
        this.workedHoursRate = workedHoursRate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWorkedHoursRate() {
        return workedHoursRate;
    }

    public void setWorkedHoursRate(int workedHoursRate) {
        this.workedHoursRate = workedHoursRate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
