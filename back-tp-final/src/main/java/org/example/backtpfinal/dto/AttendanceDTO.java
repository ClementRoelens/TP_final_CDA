package org.example.backtpfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceDTO {
    private long id;
    private LocalDateTime start;
    private LocalDateTime end;
}
