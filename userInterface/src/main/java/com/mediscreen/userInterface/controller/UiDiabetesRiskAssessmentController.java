package com.mediscreen.userInterface.controller;

import com.mediscreen.userInterface.model.DiabetesRiskAssessment;
import com.mediscreen.userInterface.model.DiabetesRiskInfo;
import com.mediscreen.userInterface.model.Patient;
import com.mediscreen.userInterface.proxy.DiabetesRiskAssessmentProxy;
import com.mediscreen.userInterface.proxy.MedicalReportProxy;
import com.mediscreen.userInterface.proxy.PatientProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * The type UiMedicalReportController
 */
@Controller
@RequestMapping("/patient")
public class UiDiabetesRiskAssessmentController {
    private static final Logger logger = LogManager.getLogger("userInterface");

    @Autowired
    private DiabetesRiskAssessmentProxy diabetesRiskAssessmentProxy;

    @Autowired
    private PatientProxy patientProxy;

    @Autowired
    private MedicalReportProxy medicalReportProxy;

    /**
     * Gets a new diabetes risk assessment
     *
     * @param id
     * @param riskInfo
     * @param riskAssessment
     * @return Level risk, sex, age & triggering factors
     */
    @GetMapping("/diabetesRisk/assess/{id}")
    public String getLevelRisk(@PathVariable("id") int id, Model model, @ModelAttribute DiabetesRiskInfo riskInfo, @ModelAttribute DiabetesRiskAssessment riskAssessment) {
        Patient patient = patientProxy.getPatientById(id);
        riskInfo.setDob(patient.getDob());
        riskInfo.setSex(patient.getSex());
        riskInfo.setContents(medicalReportProxy.getAllReportsByPatientId(id));
        riskAssessment = diabetesRiskAssessmentProxy.getLevelRisk(riskInfo);
        model.addAttribute("diabetesRiskAssessment", riskAssessment);
//        logger.info("REQUEST: GET  /patient/diabetesRisk/assess: patientId: " + patient.getId() + ": "+ riskAssessment.getRiskLevel());
        return "patient/diabetesRiskAssessment";
    }

    /**
     * Posts a new diabetes risk info
     *
     * @param id
     * @param riskInfo
     * @param riskAssessment
     * @return Level risk, sex, age & triggering factors
     */
    @PostMapping("/diabetesRisk/assess/{id}")
    public String postDiabetesRiskInfo(@PathVariable("id") int id, @RequestBody @ModelAttribute DiabetesRiskInfo riskInfo, @ModelAttribute DiabetesRiskAssessment riskAssessment ) {
        Patient patient = patientProxy.getPatientById(id);
        return "redirect:/patient/" + patient.getId();
    }
}
