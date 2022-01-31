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
    @NotEmpty(message = "Family name is mandatory")
    private String family;
    @NotEmpty(message = "Given name is mandatory")
    private String given;
    @NotNull(message = "date of birth is mandatory")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    @NotEmpty(message = "sex is mandatory")
    private String sex;
    private String address;
    private String phone;

    public Patient() {
    }

    public Patient(String family, String given, LocalDate dob, String sex, String address, String phone) {

        this.given = family;
        this.family = given;
        this.dob = dob;
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

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family= family;
    }

    public String getGiven() {
        return given;
    }

    public void setGiven(String given) {
        this.given = given;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
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
                ", family='" + family+ '\'' +
                ", given='" + given + '\'' +
                ", birthDate=" + dob +
                ", gender='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
