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
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date birthDate;

    private String gender;

    @Email(message = "Please enter a valid email address")
    private String email;

    private double pay;
    private String password;
    private String role;
    private String photoPath;
    @OneToOne
    @JoinColumn(name="address_id",nullable = false)
    private Address address;

    @OneToMany
            (mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Attendance> attendancesList;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Report> reportList;

    public Employee() {
    }

    public Employee(Long id, String firstName, String lastName, Date birthDate, String gender, String email, double pay, String password, String role, String photoPath, Address address, List<Attendance> attendancesList, List<Report> reportList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.pay = pay;
        this.password = password;
        this.role = role;
        this.photoPath = photoPath;
        this.address = address;
        this.attendancesList = attendancesList;
        this.reportList = reportList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Attendance> getAttendancesList() {
        return attendancesList;
    }

    public void setAttendancesList(List<Attendance> attendancesList) {
        this.attendancesList = attendancesList;
    }

    public List<Report> getReportList() {
        return reportList;
    }

    public void setReportList(List<Report> reportList) {
        this.reportList = reportList;
    }
}
