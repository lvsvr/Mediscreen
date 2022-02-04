package com.mediscreen.patient.controller;

import com.mediscreen.patient.model.Patient;
import com.mediscreen.patient.model.Sex;
import com.mediscreen.patient.service.PatientServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.List;

import static com.mediscreen.patient.model.Sex.F;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PatientServiceImpl patientService;

    private String family = "cTestFamily";
    private String given = "cTestLGiven";
    private LocalDate dob = LocalDate.of(1214, 7, 14);
    private Sex sex = F;
    private String address = "address";
    private String phone = "06";
    private Patient testPatient = new Patient(family, given, dob, sex, address, phone);


    @Test
    public void shouldReturnAllPatients() throws Exception {
        mockMvc.perform(get("/patient/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void ShouldReturnPatientById() throws Exception {
        List<Patient> patients = patientService.getAllPatients();
        Patient patient = patients.get(0);
        mockMvc.perform(get("/patient/" + patient.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void ShouldReturnPatientByName() throws Exception {
        List<Patient> patients = patientService.getAllPatients();
        Patient patient = patients.get(0);
        mockMvc.perform(get("/patient/search/" + patient.getFamily())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void ShouldDeletePatient() throws Exception {
        Patient addedPatient = patientService.addPatient(testPatient);
        mockMvc.perform(get("/patient/delete?id=" + addedPatient.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void ShouldAddPatient() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .post("/patient/add")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"family\": \"familyTest\", \"given\": \"givenTest\", \"dob\": \"1970-01-01\",\"sex\": \"F\", \"address\": \"address: 0\", \"phone\": \"060\"}")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
        List<Patient> patients = patientService.getAllPatients();
        patientService.deletePatient(patients.get(patients.size()-1).getId());
    }

    @Test
    public void ShouldUpdatePatient() throws Exception {
        Patient addedPatient = patientService.addPatient(testPatient);
        RequestBuilder request = MockMvcRequestBuilders
                .post("/patient/update/" +addedPatient.getId())
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"id\":\""+ addedPatient.getId() +"\", \"family\": \"familyTest\", \"given\": \"givenTest\", \"dob\": \"1970-01-01\",\"sex\": \"F\", \"address\": \"address: 0\", \"phone\": \"060\"}")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
        List<Patient> patients = patientService.getAllPatients();
        patientService.deletePatient(patients.get(patients.size()-1).getId());
    }


}
