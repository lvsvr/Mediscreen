package com.mediscreen.userInterface.controller;

import com.mediscreen.userInterface.proxy.PatientProxy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UiPatientControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientProxy patientProxy;

    @Test
    public void shouldReturnHomePage() throws Exception {
        mockMvc.perform(get("/patient/home"))
                .andExpect(status().isOk())
                .andReturn();
    }


}