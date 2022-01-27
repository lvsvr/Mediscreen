package com.mediscreen.patient.service;

import com.mediscreen.patient.exception.PatientAlreadyExistsException;
import com.mediscreen.patient.exception.PatientNotFoundException;
import com.mediscreen.patient.model.Patient;

import java.util.List;

/**
 * The interface PatientService.
 */
public interface PatientService {

    /**
     * Creates patient
     *
     * @param patient
     * @throws PatientAlreadyExistsException
     * @return patient
     */
    Patient addPatient(Patient patient) throws PatientAlreadyExistsException, PatientNotFoundException;

    /**
     * Reads patient
     *
     * @param id
     * @throws PatientNotFoundException
     * @return patient
     */
    Patient getPatientById(Integer id) throws PatientNotFoundException;

    /**
     * Updates patient
     *
     * @param patient
     * @throws PatientNotFoundException
     * @return patient
     */
    Patient updatePatient(Patient patient) throws PatientNotFoundException;

    /**
     * Deletes patient
     *
     * @param id
     * @throws PatientNotFoundException
     * @return patient
     */
    void deletePatient(Integer id) throws PatientNotFoundException;

    /**
     * Finds All patient
     *
     *throws PatientNotFoundException;
     * @return List of patient
     */
    List<Patient> getAllPatients() throws PatientNotFoundException;
    /**
     * Checks if the patient already exists
     *throws PatientAlreadyExistsException;
     * @return boolean
     */
    boolean patientAlreadyExists(Patient patient) throws PatientAlreadyExistsException, PatientNotFoundException;
    /**
     * Finds patients by name
     * @param lastName
     * throws PatientNotFoundException
     * @return boolean
     */
    List<Patient> getPatientsByName(String lastName) throws PatientNotFoundException, PatientAlreadyExistsException;
}
