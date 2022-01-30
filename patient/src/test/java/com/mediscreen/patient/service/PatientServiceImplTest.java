package com.mediscreen.patient.service;

import com.mediscreen.patient.exception.PatientAlreadyExistsException;
import com.mediscreen.patient.exception.PatientNotFoundException;
import com.mediscreen.patient.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientServiceImplTest {

    @Autowired
    private PatientServiceImpl patientService;

    private String firstName = "testFirstName";
    private String lastName = "testLastName";
    private LocalDate bDate = LocalDate.of(1789, 7, 14);
    private String gender = "X";
    private String address = "address: ";
    private String phone = "06";
    private Patient testPatient = new Patient(firstName, lastName, bDate, gender, address, phone);

    @Test
    public void shouldReturnAllPatients() throws PatientNotFoundException {
        patientService.getAllPatients().forEach(patient -> assertNotNull(patient.getId()));
    }

    @Test
    public void shouldReturnPatientById() throws PatientNotFoundException {
        Patient patient = patientService.getAllPatients().get(0);
        assertEquals(patient.toString(), patientService.getPatientById(patient.getId()).toString());

    }

    @Test
    public void shouldAddAndDeletePatient() throws PatientNotFoundException, PatientAlreadyExistsException {
        Patient addedPatient = patientService.addPatient(testPatient);
        assertNotNull(addedPatient.getId());
        assertTrue(patientService.patientAlreadyExists(addedPatient));
        assertThrows(PatientAlreadyExistsException.class, () -> patientService.addPatient(testPatient));
        patientService.deletePatient(addedPatient.getId());
        assertThrows(PatientNotFoundException.class, () -> patientService.deletePatient(addedPatient.getId()));
        assertThrows(PatientNotFoundException.class, () -> patientService.getPatientById(addedPatient.getId()));
    }

    @Test
    public void shouldGetPatientByName() throws PatientNotFoundException, PatientAlreadyExistsException {
        Patient addedPatient = patientService.addPatient(testPatient);
        assertEquals(patientService.getPatientsByName("testLastName").get(0).getLastName(), addedPatient.getLastName());
        assertThrows(PatientNotFoundException.class, () -> patientService.getPatientsByName("tttttt"));
        patientService.deletePatient(addedPatient.getId());
    }

    @Test
    public void shouldUpdatePatient() throws PatientNotFoundException, PatientAlreadyExistsException {
        Patient addedPatient = patientService.addPatient(testPatient);
        testPatient.setFirstName("testFirstName2");
        testPatient.setLastName("testFirstName2");
        testPatient.setDateOfBirth(LocalDate.of(1790, 7, 14));
        testPatient.setSex("Y");
        testPatient.setAddress("address2");
        testPatient.setPhone("phone2");

        Patient updatedPatient = patientService.updatePatient(testPatient);
        assertEquals(updatedPatient.toString(), testPatient.toString());
        patientService.deletePatient(addedPatient.getId());
        assertThrows(PatientNotFoundException.class, () -> patientService.updatePatient(addedPatient));
    }


}