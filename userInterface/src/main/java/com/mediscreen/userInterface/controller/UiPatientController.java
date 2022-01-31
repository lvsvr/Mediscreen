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
        return "patient/home";
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
        return "patient/patient";
    }

    /**
     * Gets a form to update patient by id
     *
     * @param id
     * @param patient
     * @return a form to update a patient
     */
    @GetMapping("/update/{id}")
    public String getPatientToUpdateById(Model model, @PathVariable("id") int id, @ModelAttribute Patient patient) {
        patient = patientProxy.getPatientById(id);
        model.addAttribute("patient", patient);
        logger.info("REQUEST: GET /update/{id} : " + patient.toString());
        return "patient/updatePatient";
    }

    /**
     * Updates patient by id
     *
     * @param id
     * @param patient
     * @return the patient home page
     */
    @PostMapping("/update/{id}")
    public String postUpdatedPatientById(@PathVariable("id") int id, @ModelAttribute @RequestBody @Valid Patient patient) {
        patient = patientProxy.updatePatient(patient.getId(), patient);
        logger.info("REQUEST: POST /update/{id} : " + patient.toString());
        return "redirect:/patient/home";
    }

    /**
     * Gets a warning page before get a patient deleted by id
     *
     * @param id
     * @return patient's information
     */
    @GetMapping("/toBeDeleted/{id}")
    public String getPatientToDeleteById(@PathVariable("id") int id, Model model) {
        Patient patient = patientProxy.getPatientById(id);
        model.addAttribute("patient", patient);
        return "patient/deletePatient";
    }

    /**
     * Gets a patient deleted by id
     *
     * @param id
     * @return the patient home page
     */
    @GetMapping("/deletePatient/{id}")
    public String getPatientDeletedById(@PathVariable("id") int id, Model model) {
        Patient patient = patientProxy.getPatientById(id);
        model.addAttribute("patient", patient);
        patientProxy.getPatientDeletedById(id);
        logger.info("REQUEST: GET /deletePatient/{id} : " + patient.toString());
        return "redirect:/patient/home";
    }

    /**
     * Gets a form to create a new patient
     *
     * @return a form
     */
    @GetMapping("/add")
    public String addPatient(Model model, @ModelAttribute Patient patient) {
        model.addAttribute("patient", patient);
        return "patient/newPatient";
    }

    /**
     * Gets a new patient created
     *
     * @param patient
     * @return the patient home page
     */
    @PostMapping("/add")
    public String postNewPatient(@ModelAttribute @RequestBody @Valid Patient patient) {
        patient = patientProxy.addPatient(patient);
        logger.info("REQUEST: POST  /newPatient : " + patient.toString());
        return "redirect:/patient/home";
    }
}
