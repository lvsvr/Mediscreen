package com.mediscreen.userInterface.controller;

import com.mediscreen.userInterface.model.MedicalReport;
import com.mediscreen.userInterface.model.Patient;
import com.mediscreen.userInterface.proxy.MedicalReportProxy;
import com.mediscreen.userInterface.proxy.PatientProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

/**
 * The type UiMedicalReportController
 */
@Controller
@RequestMapping("/patient")
public class UiMedicalReportController {
    private static final Logger logger = LogManager.getLogger("userInterface");

    @Autowired
    private MedicalReportProxy medicalReportProxy;

    @Autowired
    private PatientProxy patientProxy;

    @GetMapping("/medicalReport/add/{patientId}")
    public String addMedicalReport(Model model, @PathVariable("patientId")int patientId,@ModelAttribute Patient patient, @ModelAttribute MedicalReport medicalReport ) {
        patient = patientProxy.getPatientById(patientId);
        medicalReport = new MedicalReport(patientId, " ");
        medicalReport.setReportDate((LocalDate.now()));
        model.addAttribute("medicalReport", medicalReport);
        model.addAttribute("patient", patient);
        return "patient/newMedicalReport";
    }

    @PostMapping("/medicalReport/add/{patientId}")
    public String postMedicalReport(@PathVariable("patientId")int patientId, @RequestBody @ModelAttribute MedicalReport medicalReport, @ModelAttribute Patient patient) {
        patient = patientProxy.getPatientById(patientId);
        medicalReport = medicalReportProxy.addMedicalReport(medicalReport);
        logger.info("REQUEST: POST  medicalRecord/newMedicalReport : " + medicalReport.toString());
        return "redirect:/patient/" + medicalReport.getPatientId();
    }

    @GetMapping("/medicalReport/update/{id}")
    public String getMedicalReportToUpdate(Model model,@PathVariable("id") String id ){
        MedicalReport medicalReport = medicalReportProxy.getMedicalReportById(id);
        Patient patient = patientProxy.getPatientById(medicalReport.getPatientId());
        model.addAttribute("patient", patient);
        model.addAttribute("medicalReport", medicalReport);
        logger.info("REQUEST: POST medicalRecord/update/{id} ");
        return  "patient/updateMedicalReport";
    }

    @PostMapping("/medicalReport/update/{id}")
    public String postUpdatedMedicalReport(@PathVariable("id") String id,  @ModelAttribute @Valid  MedicalReport medicalReport){
        medicalReport = medicalReportProxy.updateMedicalReport(id, medicalReport);
        logger.info("REQUEST: POST medicalRecord/update/{id} : " + medicalReport.toString());
        return "redirect:/patient/" + medicalReport.getPatientId();
    }
}
