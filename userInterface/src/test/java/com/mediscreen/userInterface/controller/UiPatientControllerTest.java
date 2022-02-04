package com.mediscreen.userInterface.controller;

import com.mediscreen.userInterface.model.Patient;
import com.mediscreen.userInterface.proxy.PatientProxy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static com.mediscreen.userInterface.model.Sex.F;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UiPatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientProxy patientProxy;

    private Patient patient1;
    private Patient patient2;

    @BeforeEach
            public void setup(){
        patient1 = new Patient("Test", "Test", LocalDate.of(2020, 1, 8), F, "there", "06");
        patient1.setId(1);
        patient2 = new Patient("reTest", "reTest", LocalDate.of(2020, 1, 8), F, "somewhere", "06");
    }

    @Test
    public void shouldReturnHomePage() throws Exception {
        mockMvc.perform(get("/patient/home"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldReturnNewPatientForm() throws Exception {
        mockMvc.perform(get("/patient/add"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldAddNewPatient() throws Exception {
        when(patientProxy.addPatient(patient2)).thenReturn(patient2);

        mockMvc.perform(post("/patient/add")
                        .flashAttr("patient", patient2))
                .andExpect(status().is(302))
                .andReturn();
    }


    @Test
    public void shouldReturnPatientInformationById() throws Exception {
        when(patientProxy.getPatientById(1)).thenReturn(patient1);

        mockMvc.perform(get("/patient/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnPatientFormToUpdateById() throws Exception {
        when(patientProxy.getPatientById(1)).thenReturn(patient1);

        mockMvc.perform(get("/patient/update/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdatePatientById() throws Exception {
        when(patientProxy.updatePatient(1,patient1)).thenReturn(patient1);
        mockMvc.perform(post("/patient/update/1")
                        .flashAttr("patient", patient1))
        .andExpect(status().is(302))
                .andReturn();

    }

    @Test
    public void shouldReturnPatientInformationToDeleteById() throws Exception {
        when(patientProxy.getPatientById(1)).thenReturn(patient1);

        mockMvc.perform(get("/patient/toBeDeleted/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnPatientDeletedById() throws Exception {
        when(patientProxy.getPatientById(1)).thenReturn(patient1);

        mockMvc.perform(get("/patient/deletePatient/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(302));
    }




}
