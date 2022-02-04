package com.mediscreen.diabetesRiskAssessment.service;

import com.mediscreen.diabetesRiskAssessment.model.RiskLevel;
import com.mediscreen.diabetesRiskAssessment.model.Sex;
import com.mediscreen.diabetesRiskAssessment.model.TriggeringFactors;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * The interface DiabetesRiskAssessmentService
 */
public interface DiabetesRiskAssessmentService {

    /**
     * Gets age from date of Birth
     *
     * @param dob
     * @return page
     */
    int getAgeFromLocalDate(LocalDate dob);

    /**
     * Gets the list of all the triggering factors
     *
     * @return a list of enum
     */
    List<TriggeringFactors> getAllTriggeringFactors();

    /**
     * Gets the list of  triggering factors from a List of contents
     *
     * @param contents
     * @return a set of String
     */
    Set<String>getTriggeringFactorsFromContents(List<String>contents);

    /**
     * Gets the risk level from patient info
     *
     * @param sex
     * @param age
     * @param contents
     * @return a set of String
     */
    RiskLevel getRiskLevel(Sex sex, int age,Set<String>contents);
}
