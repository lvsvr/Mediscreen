package com.mediscreen.userInterface.controller;

import com.mediscreen.userInterface.model.Patient;
import com.mediscreen.userInterface.proxy.PatientProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * The type UiPatientController.
 */
@Controller
//@RequestMapping("/patient")
public class UiPatientController {
    private static final Logger logger = LogManager.getLogger("userInterface");

    @Autowired
    private PatientProxy patientProxy;

    @GetMapping("/")
    public String getList(Model model) {

        List<Patient> patients = patientProxy.getAllPatients();
        model.addAttribute("patients", patientProxy.getAllPatients());

        return "home";
    }

    @GetMapping("/{id}")
    public String getPatientById(@PathVariable("id") int id, Model model){
        Patient patient =  patientProxy.getPatientById(id);
        model.addAttribute("patient", patient);
                return "patient";
    }


}
