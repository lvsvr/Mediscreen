package com.mediscreen.userInterface.controller;

import com.mediscreen.userInterface.model.MedicalReport;
import com.mediscreen.userInterface.model.Patient;
import com.mediscreen.userInterface.proxy.MedicalReportProxy;
import com.mediscreen.userInterface.proxy.PatientProxy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UiMedicalReportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientProxy patientProxy;

    @MockBean
    private MedicalReportProxy medicalReportProxy;

    @Mock
    private MedicalReport reportMock;

    private Patient patient;
    private MedicalReport medicalReport;

    @BeforeEach
    public void setup(){
        patient = new Patient("Test", "Test", LocalDate.of(2020, 1, 8), "X", "there", "06");
        patient.setId(0);
        medicalReport = new MedicalReport(0, "test et reTest");
    }

    @Test
    public void shouldReturnNewReportForm() throws Exception {
        when(patientProxy.getPatientById(0)).thenReturn(patient);
        mockMvc.perform(get("/patient/medicalReport/add/"+patient.getId()))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldAddNewPatient() throws Exception {
        when(medicalReportProxy.addMedicalReport(medicalReport)).thenReturn(medicalReport);

        mockMvc.perform(post("/patient/medicalReport/add/"+medicalReport.getPatientId())
                        .flashAttr("medicalReport", medicalReport))
                .andExpect(status().is(302))
                .andReturn();
    }

    @Test
    public void shouldReturnMedicalReportToUpdate() throws Exception {
        medicalReport.setId("1");
        when(medicalReportProxy.getMedicalReportById("1")).thenReturn(medicalReport);
        when(patientProxy.getPatientById(0)).thenReturn(patient);
        mockMvc.perform(get("/patient/medicalReport/update/1"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldUpdateMedicalReportById() throws Exception {
        medicalReport.setId("1");
        when(medicalReportProxy.getMedicalReportById("1")).thenReturn(medicalReport);
        when(medicalReportProxy.updateMedicalReport("1", medicalReport)).thenReturn(medicalReport);


        mockMvc.perform(post("/patient/medicalReport/update/1")
                        .flashAttr("medicalReport", medicalReport))
                .andExpect(status().is(302))
                .andReturn();
    }

    }