package com.mediscreen.patient.controller;

import com.mediscreen.patient.exception.PatientAlreadyExistsException;
import com.mediscreen.patient.exception.PatientNotFoundException;
import com.mediscreen.patient.model.Patient;
import com.mediscreen.patient.repository.PatientRepository;
import com.mediscreen.patient.service.PatientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The type PatientController
 */
@RestController
@RequestMapping("/patient")
public class PatientController {
    private static final Logger logger = LogManager.getLogger("patient");

    @Autowired
    private PatientService patientService;


    /**
     * Gets a list of all patients
     *
     * @throws PatientNotFoundException
     * @return a list of all patients
     */
    @GetMapping("/list")
    public List<Patient> getAllPatients() throws PatientNotFoundException {
        logger.info("REQUEST: GET  /list" );
        return patientService.getAllPatients();
    }

    /**
     * Gets a patient by id
     *
     * @param id
     * @throws PatientNotFoundException
     * @return a patient
     */
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable("id") Integer id) throws PatientNotFoundException {
        logger.info("REQUEST: GET /{id} : " + id );
        return patientService.getPatientById(id);
    }

    /**
     * Gets patients by family
     *
     * @param family
     * @throws PatientAlreadyExistsException
     * @throws PatientNotFoundException
     * @return list of patients with the same family name
     */
    @GetMapping("/search/{family}")
    public List<Patient> getPatientsByName(@PathVariable(name = "family") String family) throws PatientNotFoundException, PatientAlreadyExistsException {
        logger.info("REQUEST: GET /search/{family} : "+ family );
        return patientService.getPatientsByFamily(family);
    }

    /**
     * Gets patient deleted by id
     *
     * @param id
     * @throws PatientNotFoundException
     */
    @GetMapping("/delete")
    public void getPatientDeletedById(@RequestParam("id") Integer id) throws PatientNotFoundException {
        Patient patient = patientService.getPatientById(id);
        patientService.deletePatient(id);
        logger.info("REQUEST: GET /delete?id={id} : "+  patient.toString());
    }

    /**
     * Gets a new patient added to the db
     *
     * @throws PatientNotFoundException
     * @throws PatientAlreadyExistsException
     * @return the patient
     */
    @PostMapping("/add")
    public Patient addPatient(@RequestBody @Valid Patient patient) throws PatientNotFoundException, PatientAlreadyExistsException {
        Patient newPatient = patientService.addPatient(patient);
        logger.info("REQUEST: POST /add : " + newPatient.toString() );
        return newPatient;
    }

    /**
     * Gets a patient updated
     *
     * @throws PatientNotFoundException
     * @throws PatientAlreadyExistsException
     * @return the patient
     */
    @PostMapping("/update/{id}")
    public Patient updatePatient(@PathVariable("id") Integer id, @RequestBody @Valid Patient patient) throws PatientNotFoundException {
        logger.info("REQUEST: POST /update/{id}:  from " + patientService.getPatientById(patient.getId())+ ", to " + patient.toString() );
        return patientService.updatePatient(patient);
    }

}
