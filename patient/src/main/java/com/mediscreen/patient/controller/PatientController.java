package com.mediscreen.patient.controller;

import com.mediscreen.patient.exception.PatientAlreadyExistsException;
import com.mediscreen.patient.exception.PatientNotFoundException;
import com.mediscreen.patient.model.Patient;
import com.mediscreen.patient.service.PatientService;
import com.mediscreen.patient.tools.InternalPatients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The type PatientController.
 */
@RestController
@RequestMapping("/patient")
public class PatientController {
    private static final Logger logger = LogManager.getLogger("patient");
//    logger.info("Created " + InternalTestHelper.getInternalPatientNumber() + " internal test patients.");

    @Autowired
    private PatientService patientService;
    @Autowired
    private InternalPatients internalPatients;

    public PatientController(InternalPatients internalPatients) {
        this.internalPatients = internalPatients;
    }

    @GetMapping("/initializeInternalPatients")
    public void createInternalPatients() throws PatientAlreadyExistsException {
        internalPatients.initializeInternalPatients();
    }

    @GetMapping("/resetDb")
    public void resetDb() throws PatientNotFoundException {
        internalPatients.resetDb();
    }

    @GetMapping("/list")
    public List<Patient> getAllPatients() throws PatientNotFoundException {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable("id") Integer id) throws PatientNotFoundException {
        return patientService.getPatientById(id);
    }

    @GetMapping("/search/{lastName}")
    public List<Patient> getPatientsByName(@PathVariable("lastName") String lastName) throws PatientNotFoundException, PatientAlreadyExistsException {
        return patientService.getPatientsByName(lastName);
    }

    @GetMapping("/delete")
    public void getPatientDeletedById(@RequestParam("id") Integer id) throws PatientNotFoundException {
        patientService.deletePatient(id);
    }

    @PostMapping("/newPatient")
    public Patient addPatient(@RequestBody @Valid Patient patient) throws PatientNotFoundException, PatientAlreadyExistsException {
        return patientService.addPatient(patient);
    }

    @PostMapping("/updatePatient")
    public Patient updatePatient(@RequestBody @Valid Patient patient) throws PatientNotFoundException {
        return patientService.updatePatient(patient);
    }

}
