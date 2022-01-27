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
 * The type PatientServiceImpl.
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
            if (patient.getBirthDate().equals(listedPatient.getBirthDate())) {
                if (patient.getLastName().equals(listedPatient.getLastName())) {
                    if (patient.getFirstName().equals(patient.getFirstName())) {
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
                throw new PatientAlreadyExistsException("Patient " + patient.getFirstName() + " " + patient.getLastName() + " already exists");
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
        patient.setFirstName(updatedPatient.getFirstName());
        patient.setLastName(updatedPatient.getLastName());
        patient.setBirthDate(updatedPatient.getBirthDate());
        patient.setGender(updatedPatient.getGender());
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
    public List<Patient> getPatientsByName(String lastName) throws PatientNotFoundException, PatientAlreadyExistsException {
        List<Patient> patients = new ArrayList<Patient>();
        for (Patient listedPatient : getAllPatients()) {
            if (listedPatient.getLastName().equals(lastName)) {
                patients.add(listedPatient);
            }
        }
        if (patients.isEmpty()) {
            throw new PatientNotFoundException("Patient not found");
        }
        return patients;
    }

}
