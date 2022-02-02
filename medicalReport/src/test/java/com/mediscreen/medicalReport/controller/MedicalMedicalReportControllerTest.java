package com.mediscreen.medicalReport.controller;

import com.mediscreen.medicalReport.model.MedicalReport;
import com.mediscreen.medicalReport.service.MedicalReportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MedicalMedicalReportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MedicalReportService medicalReportService;

        int patientId = 0;
        String content = "test";


    @Test
    public void shouldAddNewReport() throws Exception {
        MedicalReport medicalReport= new MedicalReport(patientId, content);
        RequestBuilder request = MockMvcRequestBuilders
                .post("/medicalReport/add")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"patientId\": \"1\", \"content\": \"test\"}")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldReturnAllReports() throws Exception {
        MedicalReport medicalReport= new MedicalReport(patientId, content);
        MedicalReport addedMedicalReport = medicalReportService.addReport(medicalReport);
        mockMvc.perform(get("/medicalReport/list" )
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnReportById() throws Exception {
        MedicalReport medicalReport= new MedicalReport(patientId, content);
        MedicalReport addedMedicalReport = medicalReportService.addReport(medicalReport);
        mockMvc.perform(get("/medicalReport/" + medicalReport.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void ShouldUpdateReport() throws Exception {
        MedicalReport medicalReport= new MedicalReport(patientId, content);
        MedicalReport addedMedicalReport = medicalReportService.addReport(medicalReport);
        RequestBuilder request = MockMvcRequestBuilders
                .post("/medicalReport/update/" + addedMedicalReport.getId())
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"id\":\""+ addedMedicalReport.getId() +"\", \"patientId\": 0, \"reportDate\": \""+ addedMedicalReport.getReportDate()+"\", \"content\": \"re test\"}")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldReturnAllReportsByPatientId() throws Exception {
        MedicalReport medicalReport= new MedicalReport(patientId, content);
        MedicalReport addedMedicalReport = medicalReportService.addReport(medicalReport);
        mockMvc.perform(get("/medicalReport/list/"+medicalReport.getPatientId() )
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteAllReportByPatientId() throws Exception {
        MedicalReport medicalReport= new MedicalReport(patientId, content);
        MedicalReport addedMedicalReport = medicalReportService.addReport(medicalReport);
        mockMvc.perform(get("/medicalReport/delete/list/"+medicalReport.getPatientId() )
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}