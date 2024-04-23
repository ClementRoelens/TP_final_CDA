package org.example.backtpfinal.exception;

import java.util.UUID;

public class EmployeeNotFound extends  RuntimeException{

    public  EmployeeNotFound(Long employeeId){
        super("Employee not found with id: " + employeeId);
    }
}
