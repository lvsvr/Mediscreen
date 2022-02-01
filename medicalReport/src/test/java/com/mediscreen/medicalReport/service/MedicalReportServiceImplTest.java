package com.mediscreen.medicalReport.service;

import com.mediscreen.medicalReport.model.Report;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
class MedicalReportServiceImplTest {

    @Autowired
    private MedicalReportServiceImpl underTest;

    private int patientId = 0;
    private String content = "test";


    @Test
    public void shouldCreateReport(){
        Report medicalReport = new Report(patientId, content);
        assertNotNull(underTest.addReport(medicalReport).getId());
    }

    @Test
    public void shouldReturnAReportById(){
        Report medicalReport2 = new Report(patientId, content);
        Report report2 = underTest.addReport(medicalReport2);
        assertNotNull(underTest.getReportById(report2.getId()));
    }

    @Test
    public void shouldUpdateAReport(){
        Report medicalReport3= new Report(patientId, content);
        Report medicalReport4 = new Report(patientId, content);
        Report report = underTest.addReport(medicalReport3);
        Report report2 = underTest.addReport(medicalReport4);
        report.setContent("disease");
        underTest.updateReport(report);
        assertFalse(report.getContent().equals(report2.getContent()));
    }

    @Test
    public void shouldReturnAllReportsByPatientId() {
        Report medicalReport5 = new Report(patientId, content);
        Report medicalReport6 = new Report(patientId, content);
        Report report = underTest.addReport(medicalReport5);
        Report report2 = underTest.addReport(medicalReport6);
        assertNotNull(underTest.getAllReportsByPatientId(report.getPatientId()));
    }

    @Test
    public void shouldDeleteAllReportsByPatientId(){
        Report medicalReport6= new Report(patientId, content);
        Report report =underTest.addReport(medicalReport6);
        String id = report.getId();
        underTest.deleteAllReportsByPatientId(patientId);
        assertEquals(0, underTest.getAllReportsByPatientId(patientId).size());
        Report medicalReport7 = new Report(patientId, content);
        Report report7 = underTest.addReport(medicalReport7);
        underTest.deleteReport(report7.getId());
        assertEquals(0, underTest.getAllReportsByPatientId(patientId).size());
    }



}