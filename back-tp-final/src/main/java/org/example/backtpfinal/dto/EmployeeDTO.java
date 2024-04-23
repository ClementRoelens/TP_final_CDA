package org.example.backtpfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.backtpfinal.entities.Address;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String gender;
    private String email;
    private double pay;
    private String password;
    private String role;
    private String photoPath;
    private Address address;
}
