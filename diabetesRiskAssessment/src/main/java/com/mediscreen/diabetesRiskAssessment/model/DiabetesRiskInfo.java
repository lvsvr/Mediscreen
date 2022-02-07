package com.mediscreen.diabetesRiskAssessment.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * The type DiabetesRiskInfo
 */
public class DiabetesRiskInfo {

    private LocalDate dob;
    private Sex sex;
    private List<MedicalReport> medicalReports;

    public DiabetesRiskInfo(LocalDate dob, Sex sex, List<MedicalReport> medicalReports) {
        this.dob = dob;
        this.sex = sex;
        this.medicalReports = medicalReports;
    }

    public DiabetesRiskInfo() {
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public List<MedicalReport> getMedicalReports() {
        return medicalReports;
    }

    public void setContents(List<MedicalReport> medicalReports) {
        this.medicalReports = medicalReports;
    }

    @Override
    public String toString() {
        return "DiabetesRiskAssessment{" +
                "dob=" + dob +
                ", sex=" + sex +
                ", contents=" + medicalReports +
                '}';
    }
}
