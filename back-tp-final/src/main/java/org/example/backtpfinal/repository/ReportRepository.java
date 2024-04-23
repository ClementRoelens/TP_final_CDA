package org.example.backtpfinal.repository;

import org.example.backtpfinal.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
