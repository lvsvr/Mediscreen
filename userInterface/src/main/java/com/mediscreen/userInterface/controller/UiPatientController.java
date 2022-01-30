package com.mediscreen.userInterface.controller;

import com.mediscreen.userInterface.model.Patient;
import com.mediscreen.userInterface.proxy.PatientProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The type UiPatientController.
 */
@Controller
@RequestMapping("/patient")
public class UiPatientController {
    private static final Logger logger = LogManager.getLogger("userInterface");

    @Autowired
    private PatientProxy patientProxy;

    /**
     * Gets home page
     *
     * @return a list of all patients
     */
    @GetMapping("/home")
    public String getList(Model model) {

        List<Patient> patients = patientProxy.getAllPatients();
        model.addAttribute("patients", patientProxy.getAllPatients());
        logger.info("REQUEST: GET /patient/home - patient's list");
        return "home";
    }

    /**
     * Gets a patient by id
     *
     * @param id
     * @return a patient's information
     */
    @GetMapping("/{id}")
    public String getPatientById(@PathVariable("id") int id, Model model) {
        Patient patient = patientProxy.getPatientById(id);
        model.addAttribute("patient", patient);
        logger.info("REQUEST: GET /patient/{id} - patient's information");
        return "patient";
    }

    @GetMapping("/update/{id}")
    public String patientToUpdate (Model model, @PathVariable("id") int id, @ModelAttribute Patient patient){
        patient = patientProxy.getPatientById(id);
        model.addAttribute("patient", patient);
        logger.info("REQUEST: GET /patientToUpdate");
        return "updatePatient";
    }

    @PostMapping("/update/{id}")
    public String updatePatient (@PathVariable("id") int id, @ModelAttribute @RequestBody @Valid Patient patient){
        patient = patientProxy.updatePatient(patient.getId(), patient);
        return "redirect:/patient/home";
    }


}
