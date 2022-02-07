package com.mediscreen.diabetesRiskAssessment.model;

import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * The type DiabetesRiskAssessment
 */
public class DiabetesRiskAssessment {

    @NotNull
    private RiskLevel riskLevel;
    @NotNull
    private int patientAge;
    @NotNull
    private Sex sex;
    private Set<String> triggeringFactors;

    public DiabetesRiskAssessment(RiskLevel riskLevel, int patientAge, Sex sex, Set<String> triggeringFactors) {
        this.riskLevel = riskLevel;
        this.patientAge = patientAge;
        this.sex = sex;
        this.triggeringFactors = triggeringFactors;
    }

    public DiabetesRiskAssessment() {
    }

    public RiskLevel getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(RiskLevel riskLevel) {
        this.riskLevel = riskLevel;
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

    public Set<String> getTriggeringFactors() {
        return triggeringFactors;
    }

    public void setTriggeringFactors(Set<String> triggeringFactors) {
        this.triggeringFactors = triggeringFactors;
    }

}
