package com.mediscreen.diabetesRiskAssessment.model;

import java.time.LocalDate;
import java.util.List;

/**
 * The type DiabetesRiskInfo
 */
public class DiabetesRiskInfo {

    private LocalDate dob;
    private Sex sex;
    private List<String> contents;

    public DiabetesRiskInfo(LocalDate dob, Sex sex, List<String> contents) {
        this.dob = dob;
        this.sex = sex;
        this.contents = contents;
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

    public List<String> getContents() {
        return contents;
    }

    public void setContents(List<String> contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "DiabetesRiskAssessment{" +
                "dob=" + dob +
                ", sex=" + sex +
                ", contents=" + contents +
                '}';
    }
}
