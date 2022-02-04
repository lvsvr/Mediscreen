package com.mediscreen.diabetesRiskAssessment.service;

import com.mediscreen.diabetesRiskAssessment.model.RiskLevel;
import com.mediscreen.diabetesRiskAssessment.model.Sex;
import com.mediscreen.diabetesRiskAssessment.model.TriggeringFactors;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type DiabetesRiskAssessmentServiceImpl
 */
@Service
public class DiabetesRiskAssessmentServiceImpl implements DiabetesRiskAssessmentService {


    @Override
    public int getAgeFromLocalDate(LocalDate dob) {
        return dob.getYear() - LocalDate.now().getYear();
    }

    @Override
    public List<TriggeringFactors> getAllTriggeringFactors() {
        return Arrays.asList(TriggeringFactors.values());
    }

    @Override
    public Set<String> getTriggeringFactorsFromContents(List<String> contents) {
        Set<String> triggeringFactorsFromContent = new HashSet<String>();
        List<TriggeringFactors> triggeringFactors = getAllTriggeringFactors();
        for(String content : contents){
            for (TriggeringFactors triggeringFactor : triggeringFactors){
                if(content.toLowerCase().contains(String.valueOf(triggeringFactor).toLowerCase())){
                    triggeringFactorsFromContent.add(String.valueOf(triggeringFactor));
                }
            }
        }
        return  triggeringFactorsFromContent;
    }

    @Override
    public RiskLevel getRiskLevel(Sex sex, int age, Set<String> contents) {
        return null;
    }
}
