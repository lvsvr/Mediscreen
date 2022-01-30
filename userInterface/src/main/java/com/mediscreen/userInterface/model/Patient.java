package com.mediscreen.userInterface.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


/**
 * The type Patient.
 */
public class Patient {

    private int id;
    @NotEmpty(message = "First name is mandatory")
    private String firstName;
    @NotEmpty(message = "Last name is mandatory")
    private String lastName;
    @NotNull(message = "date of birth is mandatory")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @NotEmpty(message = "sex is mandatory")
    private String sex;
    @NotEmpty(message = "address is mandatory")
    private String address;
    @NotEmpty(message = "phone is mandatory")
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

    public void setSex(String sex) {
        this.sex = sex;
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
