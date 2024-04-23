package org.example.backtpfinal.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Employee {

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
    @ManyToOne
    @JoinColumn(name="adress_id",nullable = false)
    private Address address;

    @OneToMany
            (mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Attendance> attendancesList;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Report> reportList;



}
