package com.mediscreen.patient.service;

import com.mediscreen.patient.exception.PatientAlreadyExistsException;
import com.mediscreen.patient.exception.PatientNotFoundException;
import com.mediscreen.patient.model.Patient;
import com.mediscreen.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The type PatientServiceImpl
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() throws PatientNotFoundException {
        if (patientRepository.findAll().isEmpty()) {
            throw new PatientNotFoundException("No patient has been found");
        }
        return patientRepository.findAll();
    }

    @Override
    public boolean patientAlreadyExists(Patient patient) throws PatientNotFoundException {
        for (Patient listedPatient : getAllPatients()) {
            if (patient.getDob().equals(listedPatient.getDob())) {
                if (patient.getFamily().equals(listedPatient.getFamily())) {
                    if (patient.getGiven().equals(patient.getGiven())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public Patient addPatient(Patient patient) throws PatientAlreadyExistsException, PatientNotFoundException {
        if(getAllPatients().isEmpty()){
            return patientRepository.save(patient);
        }else if(patientAlreadyExists(patient)) {
                throw new PatientAlreadyExistsException("Patient " + patient.getGiven() + " " + patient.getFamily() + " already exists");
            } else {
                return patientRepository.save(patient);
            }
        }

    @Override
    public Patient getPatientById(Integer id) throws PatientNotFoundException {
        if (!patientRepository.findById(id).isPresent()) {
            throw new PatientNotFoundException("Patient not found");
        }
        return patientRepository.findById(id).get();
    }

    @Override
    public Patient updatePatient(Patient updatedPatient) throws PatientNotFoundException {
        if (!patientRepository.existsById(updatedPatient.getId())) {
            throw new PatientNotFoundException("Patient not found");
        }
        Patient patient = patientRepository.findById(updatedPatient.getId()).get();
        patient.setGiven(updatedPatient.getGiven());
        patient.setFamily(updatedPatient.getFamily());
        patient.setDob(updatedPatient.getDob());
        patient.setSex(updatedPatient.getSex());
        patient.setAddress(updatedPatient.getAddress());
        patient.setPhone(updatedPatient.getPhone());

        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Integer id) throws PatientNotFoundException {
        if (!patientRepository.findById(id).isPresent()) {
            throw new PatientNotFoundException("Patient not found");
        }
        patientRepository.deleteById(id);
    }

    @Override
    public List<Patient> getPatientsByFamily(String family) throws PatientNotFoundException, PatientAlreadyExistsException {
        List<Patient> patients = new ArrayList<Patient>();
        for (Patient listedPatient : getAllPatients()) {
            if (listedPatient.getFamily().equals(family)) {
                patients.add(listedPatient);
            }
        }
        if (patients.isEmpty()) {
            throw new PatientNotFoundException("Patient not found");
        }
        return patients;
    }

}
