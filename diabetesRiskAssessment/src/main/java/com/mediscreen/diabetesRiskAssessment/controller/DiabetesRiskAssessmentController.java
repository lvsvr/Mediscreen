package com.mediscreen.diabetesRiskAssessment.controller;

import com.mediscreen.diabetesRiskAssessment.model.DiabetesRiskAssessment;
import com.mediscreen.diabetesRiskAssessment.model.DiabetesRiskInfo;
import com.mediscreen.diabetesRiskAssessment.model.RiskLevel;
import com.mediscreen.diabetesRiskAssessment.service.DiabetesRiskAssessmentServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type DiabetesRiskAssessmentController.
 */
@RestController
@RequestMapping("/diabetesRiskAssessment")
public class DiabetesRiskAssessmentController {
    private static final Logger logger = LogManager.getLogger("diabetesRiskAssessment");

    @Autowired
    private DiabetesRiskAssessmentServiceImpl riskAssessmentService;

    /**
     * Gets a new diabetes risk assessment
     *
     * @param riskInfo
     * @return Level risk, sex, age & triggering factors
     */
    @PostMapping("/assess")
    public DiabetesRiskAssessment  getLevelRisk(DiabetesRiskInfo riskInfo){
        return riskAssessmentService.getRiskAssessment(riskInfo);
    }
}
