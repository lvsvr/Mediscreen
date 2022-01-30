package com.mediscreen.patient.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


/**
 * The type Patient.
 */
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private int id;
    @Column(name = "firstName")
    @NotBlank
    private String firstName;
    @Column(name = "lastName")
    @NotBlank
    private String lastName;
    @Column(name = "dateOfBirth")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @Column(name = "sex")
    @NotBlank
    private String sex;
    @Column(name = "address")
    @NotBlank
    private String address;
    @Column(name = "phone")
    @NotBlank
    private String phone;

    public Patient() {
    }

    public Patient(String firstName, String lastName, LocalDate dateOfBirth, String sex, String address, String phone) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String gender) {
        this.sex = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + dateOfBirth +
                ", gender='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
