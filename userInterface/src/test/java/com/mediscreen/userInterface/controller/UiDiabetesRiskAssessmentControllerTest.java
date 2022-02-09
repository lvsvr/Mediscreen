package com.mediscreen.userInterface.controller;

import com.mediscreen.userInterface.model.DiabetesRiskInfo;
import com.mediscreen.userInterface.model.Patient;
import com.mediscreen.userInterface.proxy.DiabetesRiskAssessmentProxy;
import com.mediscreen.userInterface.proxy.MedicalReportProxy;
import com.mediscreen.userInterface.proxy.PatientProxy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UiDiabetesRiskAssessmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DiabetesRiskAssessmentProxy diabetesRiskAssessmentProxy;

    @Autowired
    private PatientProxy patientProxy;

    @Autowired
    private MedicalReportProxy medicalReportProxy;

    private DiabetesRiskInfo riskInfo=new DiabetesRiskInfo();
    private int patientId = 1;

    @Test
    public void shouldReturnRiskAssessment() throws Exception {
        mockMvc.perform(get("/patient/diabetesRisk/assess/"+ patientId))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldPostRiskInfo() throws Exception {
        Patient patient = patientProxy.getPatientById(1);
        riskInfo.setDob(patient.getDob());
        riskInfo.setSex(patient.getSex());
        riskInfo.setContents(medicalReportProxy.getAllReportsByPatientId(1));
        mockMvc.perform(post("/patient/diabetesRisk/assess/" +patientId)
                        .flashAttr("riskInfo", riskInfo))
                .andExpect(status().is(302))
                .andReturn();
    }
}