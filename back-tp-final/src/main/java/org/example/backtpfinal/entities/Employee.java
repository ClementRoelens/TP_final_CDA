package org.example.backtpfinal.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.example.backtpfinal.dto.EmployeeDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.hibernate.annotations.GenericGenerator;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Entity
public class Employee implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Please enter employee firstname")
    private String firstName;

    @NotBlank(message = "Please enter employee lastname")
    private String lastName;

    @Past(message = "Birthdate cannot be present or future date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    private String gender;

    @Email(message = "Please enter a valid email address")
    private String email;

    private double pay;
    private String password;
    private String role;
    private String photoPath;
    @OneToOne
    @JoinColumn(name="adress_id",nullable = false)
    private Address address;

    @OneToMany(mappedBy = "employee")
    private List<Attendance> attendancesList;

    @OneToMany(mappedBy = "employee")
    private List<Report> reportList;

    public Employee() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public EmployeeDTO toDTO(){
        return EmployeeDTO.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(birthDate)
                .gender(gender)
                .email(email)
                .pay(pay)
                .role(role)
                .photoPath(photoPath)
                .address(address.toDTO())
                .build();
    }
}
