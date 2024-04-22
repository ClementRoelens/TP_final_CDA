package org.example.backtpfinal.entities;

import jakarta.persistence.*;
import lombok.*;

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
    private UUID id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String gender;
    private String email;
    private double pay;
    private String password;
    private String role;
    private String photoPath;
    @ManyToOne
    @JoinColumn(name="adress_id")
    private Address address;
    @OneToMany
            (mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Attendance> attendancesList;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Report> reportList;


    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
