package org.example.backtpfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.backtpfinal.entities.Address;
import org.example.backtpfinal.entities.Employee;

import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String gender;
    private String email;
    private double pay;
    private String password;
    private String role;
    private String photoPath;
    private AddressDTO address;
    private long addressId;

    public Employee toEntity(){
        return Employee.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(birthDate)
                .gender(gender)
                .email(email)
                .pay(pay)
                .password(password)
                .role(role)
                .photoPath(photoPath)
                .address(address.toEntity())
                .build();
    }
}
