package com.mediscreen.userInterface.proxy;

import com.mediscreen.userInterface.model.DiabetesRiskAssessment;
import com.mediscreen.userInterface.model.DiabetesRiskInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * The proxy feign interface DiabetesRiskAssessmentProxy
 */
@FeignClient(value = "medicalReport", url = "${proxy.assessment}")
public interface DiabetesRiskAssessmentProxy {

    /**
     * Gets a new diabetes risk assessment
     *
     * @param riskInfo
     * @return Level risk, sex, age & triggering factors
     */
    @PostMapping("/assess")
    DiabetesRiskAssessment getLevelRisk(DiabetesRiskInfo riskInfo);
}
