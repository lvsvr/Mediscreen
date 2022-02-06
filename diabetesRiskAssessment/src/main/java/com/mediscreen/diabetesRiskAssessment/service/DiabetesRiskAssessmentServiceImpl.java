package com.mediscreen.diabetesRiskAssessment.service;

import com.mediscreen.diabetesRiskAssessment.model.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

/**
 * The type DiabetesRiskAssessmentServiceImpl
 */
@Service
public class DiabetesRiskAssessmentServiceImpl implements DiabetesRiskAssessmentService {


    @Override
    public int getAgeFromLocalDate(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    @Override
    public List<String>getContentsFromRiskInfo(DiabetesRiskInfo riskInfo){
        List<MedicalReport> medicalReports = riskInfo.getMedicalReports();
        List<String> contents = new ArrayList<String>();
        for(MedicalReport medicalReport:medicalReports) {
            contents.add(medicalReport.getContent());
        }
        return contents;
    }

    @Override
    public List<TriggeringFactors> getAllTriggeringFactors() {
        return Arrays.asList(TriggeringFactors.values());
    }

    @Override
    public Set<String> getTriggeringFactorsFromContents(List<String> contents) {
        Set<String> triggeringFactorsFromContent = new HashSet<String>();
        List<TriggeringFactors> triggeringFactors = getAllTriggeringFactors();
        for (String content : contents) {
            for (TriggeringFactors triggeringFactor : triggeringFactors) {
                if (content.toLowerCase().contains(String.valueOf(triggeringFactor).toLowerCase())) {
                    triggeringFactorsFromContent.add(String.valueOf(triggeringFactor));
                }
            }
        }
        return triggeringFactorsFromContent;
    }

    //===== REMINDER ==================
//      M < 30 = 5             |
//      F <30 = 7                > : EARLY_ONSET
//      M/F > 30 = 8          |
//
//      M < 30 = 3              |
//      F <30 = 4                 > : IN_DANGER
//      H/F > 30 = 6           |
//
//      M∕F > 30 = 2             : BORDERLINE
//
//      H∕F = 0                      : NONE
//
//    => age 30 -> sex -> triggering factors' number
//===================================
    @Override
    public RiskLevel getRiskLevel(DiabetesRiskInfo riskInfo) {
        Sex sex = riskInfo.getSex();
        int age = getAgeFromLocalDate(riskInfo.getDob());
        Set<String> triggeringFactors = getTriggeringFactorsFromContents(getContentsFromRiskInfo(riskInfo));

        RiskLevel riskLevel = RiskLevel.NONE;

        if (age >= 30) {
            if (2 <= triggeringFactors.size() && triggeringFactors.size() < 6) {
                return riskLevel = RiskLevel.BORDERLINE;
            } else if (6 <= triggeringFactors.size() && triggeringFactors.size() < 8) {
                return riskLevel = RiskLevel.IN_DANGER;
            } else if (triggeringFactors.size() >= 8) {
                return riskLevel = RiskLevel.EARLY_ONSET;
            }
        } else{
            if (sex.equals(Sex.F)){
                if (4 <= triggeringFactors.size() && triggeringFactors.size() < 7) {
                    return riskLevel = RiskLevel.IN_DANGER;
                } else if (triggeringFactors.size() >= 7) {
                    return riskLevel = RiskLevel.EARLY_ONSET;
                }
            }else{
                if (3 <= triggeringFactors.size() && triggeringFactors.size() < 5) {
                    return riskLevel = RiskLevel.IN_DANGER;
                } else if (triggeringFactors.size() >= 5) {
                    return riskLevel = RiskLevel.EARLY_ONSET;
                }
            }
        }
        return riskLevel;
    }

    @Override
    public DiabetesRiskAssessment getRiskAssessment(DiabetesRiskInfo riskInfo){
        DiabetesRiskAssessment riskAssessment = new DiabetesRiskAssessment();
        riskAssessment.setRiskLevel(getRiskLevel(riskInfo));
        riskAssessment.setPatientAge(getAgeFromLocalDate(riskInfo.getDob()));
        riskAssessment.setSex(riskInfo.getSex());
        riskAssessment.setTriggeringFactors(getTriggeringFactorsFromContents(getContentsFromRiskInfo(riskInfo)));
        return riskAssessment;
    }
}




