package com.mediscreen.diabetesRiskAssessment.model;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * The type DiabetesRiskAssessment
 */
public class DiabetesRiskAssessment {

    @NotNull
    private RiskLevel riskLevels;
    @NotNull
    private int patientAge;
    @NotNull
    private Sex sex;
    private List<TriggeringFactors> triggeringFactors;

    public DiabetesRiskAssessment(RiskLevel riskLevels, int patientAge, Sex sex, List<TriggeringFactors> triggeringFactors) {
        this.riskLevels = riskLevels;
        this.patientAge = patientAge;
        this.sex = sex;
        this.triggeringFactors = triggeringFactors;
    }

    public RiskLevel getRiskLevels() {
        return riskLevels;
    }

    public void setRiskLevels(RiskLevel riskLevels) {
        this.riskLevels = riskLevels;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public List<TriggeringFactors> getTriggeringFactors() {
        return triggeringFactors;
    }

    public void setTriggeringFactors(List<TriggeringFactors> triggeringFactors) {
        this.triggeringFactors = triggeringFactors;
    }

    @Override
    public String toString() {
        return "DiabetesRiskAssessment{" +
                "riskLevels=" + riskLevels +
                ", patientAge=" + patientAge +
                ", sex=" + sex +
                ", triggeringFactors=" + triggeringFactors +
                '}';
    }
}
