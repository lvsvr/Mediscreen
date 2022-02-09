package com.mediscreen.userInterface.model;

import java.time.LocalDate;
import java.util.List;

/**
 * The type DiabetesRiskInfo
 */
public class DiabetesRiskInfo {

    private LocalDate dob;
    private Sex sex;
    private List<MedicalReport> medicalReports;

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
