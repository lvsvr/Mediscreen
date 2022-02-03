package com.mediscreen.medicalReport.service;

import com.mediscreen.medicalReport.model.MedicalReport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
class MedicalMedicalReportServiceImplTest {

    @Autowired
    private MedicalReportServiceImpl underTest;

    private int patientId = 0;
    private String content = "test";


    @Test
    public void shouldCreateReport(){
        MedicalReport medicalReport = new MedicalReport(patientId, content);
        assertNotNull(underTest.addReport(medicalReport).getId());
    }

    @Test
    public void shouldReturnAReportById(){
        MedicalReport medicalMedicalReport2 = new MedicalReport(patientId, content);
        MedicalReport report2 = underTest.addReport(medicalMedicalReport2);
        assertNotNull(underTest.getReportById(report2.getId()));
    }

    @Test
    public void shouldUpdateAReport(){
        MedicalReport medicalReport3 = new MedicalReport(patientId, content);
        MedicalReport updatedMedicalReport = underTest.addReport(medicalReport3);
        updatedMedicalReport.setContent("disease");
        String id = updatedMedicalReport .getId();
        underTest.updateReport(id, updatedMedicalReport);
        assertEquals("disease", underTest.getReportById(id).getContent());
    }

    @Test
    public void shouldReturnAllReportsByPatientId() {
        MedicalReport medicalMedicalReport5 = new MedicalReport(patientId, content);
        MedicalReport medicalMedicalReport6 = new MedicalReport(patientId, content);
        MedicalReport medicalReport = underTest.addReport(medicalMedicalReport5);
        MedicalReport medicalReport2 = underTest.addReport(medicalMedicalReport6);
        assertNotNull(underTest.getAllReportsByPatientId(medicalReport.getPatientId()));
    }

    @Test
    public void shouldDeleteAllReportsByPatientId(){
        MedicalReport medicalMedicalReport6 = new MedicalReport(patientId, content);
        MedicalReport medicalReport =underTest.addReport(medicalMedicalReport6);
        String id = medicalReport.getId();
        underTest.deleteAllReportsByPatientId(patientId);
        assertEquals(0, underTest.getAllReportsByPatientId(patientId).size());
        MedicalReport medicalMedicalReport7 = new MedicalReport(patientId, content);
        MedicalReport report7 = underTest.addReport(medicalMedicalReport7);
        underTest.deleteReport(report7.getId());
        assertEquals(0, underTest.getAllReportsByPatientId(patientId).size());
    }



}