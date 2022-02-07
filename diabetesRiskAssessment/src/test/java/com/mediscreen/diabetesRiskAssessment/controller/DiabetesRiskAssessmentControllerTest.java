package com.mediscreen.diabetesRiskAssessment.controller;

import com.mediscreen.diabetesRiskAssessment.model.*;
import com.mediscreen.diabetesRiskAssessment.service.DiabetesRiskAssessmentServiceImpl;
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
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DiabetesRiskAssessmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DiabetesRiskAssessmentServiceImpl riskAssessmentService;

    @Test
    public void shouldReturnAssessment() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .post("/diabetesRisk/assess")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"dob\":\"1970-01-01\", \"sex\":\"M\", \"contents\":[{\"id\":\"61fd564cb3db7d0b6c61d3ed\", \"patientId\":\"2\", \"reportDate\":\"2022-02-04\", \"content\" : \"test\"}]}")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
    }

}

