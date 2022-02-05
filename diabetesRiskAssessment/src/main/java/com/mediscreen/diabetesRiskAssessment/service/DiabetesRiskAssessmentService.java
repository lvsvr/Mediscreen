package com.mediscreen.diabetesRiskAssessment.service;

import com.mediscreen.diabetesRiskAssessment.model.*;

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
     * @param riskInfo
     * @return a set of String
     */
    RiskLevel getRiskLevel(DiabetesRiskInfo riskInfo);

    /**
     * Gets the risk assessment from patient info
     *
     * @param riskInfo
     * @return a risk level, age, sex, triggering factors
     */
    DiabetesRiskAssessment getRiskAssessment(DiabetesRiskInfo riskInfo);

}
