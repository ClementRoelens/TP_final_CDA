package org.example.backtpfinal.exception;

public class MultipleAttendanceRecordsFoundException extends  RuntimeException{
    public MultipleAttendanceRecordsFoundException(Long employeeId) {
        super("Multiple attendance records found for employee ID: " + employeeId);
    }
}
