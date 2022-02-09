package com.mediscreen.diabetesRiskAssessment.service;

import com.mediscreen.diabetesRiskAssessment.model.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DiabetesRiskAssessmentServiceImplTest {

    @Autowired
    DiabetesRiskAssessmentServiceImpl underTest;

    @Mock
    MedicalReport medicalReport;

    private int patientId = 0;
    private String content = "test";

    @Test
    public void shouldReturnAgeFromDob() {
        LocalDate currentDate = LocalDate.now();
        LocalDate dob = LocalDate.of((currentDate.getYear() - 20), currentDate.getMonth(), currentDate.getDayOfMonth());
        assertEquals(20, underTest.getAgeFromLocalDate(dob));
    }

    @Test
    public void shouldReturnContentsFromRiskInfo() {
        List<MedicalReport> reports = new ArrayList<>();
        MedicalReport report = new MedicalReport("61fd564cb3db7d0b6c61d3ed", 2, LocalDate.of(2012, 12, 06), "test");
        reports.add(report);
        DiabetesRiskInfo riskInfo = new DiabetesRiskInfo();
        riskInfo.setDob(LocalDate.of(2012, 12, 06));
        riskInfo.setSex(Sex.F);
        riskInfo.setContents(reports);
        assertEquals(report.getContent(), underTest.getContentsFromRiskInfo(riskInfo).get(0));
    }

    @Test
    public void shouldReturnAllTriggeringFactors() {
        assertNotNull(underTest.getAllTriggeringFactors());
    }

    @Test
    public void shouldExtractTriggeringFactorsFromContents() {
        List<String> contents = new ArrayList<String>();
        List<TriggeringFactors> triggeringFactors = underTest.getAllTriggeringFactors();
        String content = "test ";
        for (TriggeringFactors triggeringFactor : triggeringFactors) {
            contents.add(content);
            contents.add(String.valueOf(triggeringFactor).toLowerCase());
        }
        assertNotNull(underTest.getTriggeringFactorsFromContents(contents));
        assertFalse(underTest.getTriggeringFactorsFromContents(contents).contains("test"));
    }

    @Test
    public void shouldReturnRiskLevel() {
        LocalDate currentDate = LocalDate.now();
        LocalDate dob = LocalDate.of((currentDate.getYear() - 20), currentDate.getMonth(), currentDate.getDayOfMonth());
        List<String> contents = new ArrayList<String>();
        List<TriggeringFactors> triggeringFactors = underTest.getAllTriggeringFactors();
        String content = "test ";
        for (TriggeringFactors triggeringFactor : triggeringFactors) {
            contents.add(String.valueOf(triggeringFactor).toLowerCase());
        }

        List<MedicalReport> reports = new ArrayList<>();
        MedicalReport report = new MedicalReport("61fd564cb3db7d0b6c61d3ed", 1, LocalDate.of(2012, 12, 06), contents.get(0) + " " + contents.get(1));
        reports.add(report);
        DiabetesRiskInfo riskInfo = new DiabetesRiskInfo();
        riskInfo.setDob(LocalDate.of(1970, 12, 06));
        riskInfo.setSex(Sex.F);
        riskInfo.setContents(reports);
        assertEquals(RiskLevel.BORDERLINE, underTest.getRiskLevel(riskInfo));

        List<MedicalReport> reports2 = new ArrayList<>();
        String content2 = "test2 ";
        for (int i = 0; i < 7; i++) {
            content2 = content2 + contents.get(i) + " ";
        }
        MedicalReport report2 = new MedicalReport("61fd564cb3db7d0b6c61d4fg", 2, LocalDate.of(2012, 12, 06), content2);
        reports2.add(report2);
        DiabetesRiskInfo riskInfo2 = new DiabetesRiskInfo();
        riskInfo2.setDob(LocalDate.of(1968, 12, 06));
        riskInfo2.setSex(Sex.F);
        riskInfo2.setContents(reports2);
        assertEquals(RiskLevel.IN_DANGER, underTest.getRiskLevel(riskInfo2));


        List<MedicalReport> reports3 = new ArrayList<>();
        String content3 = "test3 ";
        for (int i = 0; i < 9; i++) {
            content3 = content3 + contents.get(i) + " ";
        }
        MedicalReport report3 = new MedicalReport("61fd564cb3db7d0b6c61d4zw", 2, LocalDate.of(2012, 12, 06), content3);
        reports3.add(report3);
        DiabetesRiskInfo riskInfo3 = new DiabetesRiskInfo();
        riskInfo3.setDob(LocalDate.of(1970, 12, 06));
        riskInfo3.setSex(Sex.F);
        riskInfo3.setContents(reports3);
        assertEquals(RiskLevel.EARLY_ONSET, underTest.getRiskLevel(riskInfo3));

        List<MedicalReport> reports4 = new ArrayList<>();
        String content4 = "test4 ";
        for (int i = 0; i < 6; i++) {
            content4 = content4 + contents.get(i) + " ";
        }
        MedicalReport report4 = new MedicalReport("61fd564cb3db7d0b6c61d4hi", 2, LocalDate.of(2012, 12, 06), content4);
        reports4.add(report4);
        DiabetesRiskInfo riskInfo4 = new DiabetesRiskInfo();
        riskInfo4.setDob(dob);
        riskInfo4.setSex(Sex.F);
        riskInfo4.setContents(reports4);
        assertEquals(RiskLevel.IN_DANGER, underTest.getRiskLevel(riskInfo4));

        List<MedicalReport> reports5 = new ArrayList<>();
        String content5 = "test5 ";
        for (int i = 0; i < 7; i++) {
            content5 = content5 + contents.get(i) + " ";
        }
        MedicalReport report5 = new MedicalReport("61fd564cb3db7d0b6c61d4jk", 2, LocalDate.of(2012, 12, 06), content5);
        reports5.add(report5);
        DiabetesRiskInfo riskInfo5 = new DiabetesRiskInfo();
        riskInfo5.setDob(dob);
        riskInfo5.setSex(Sex.F);
        riskInfo5.setContents(reports5);
        assertEquals(RiskLevel.EARLY_ONSET, underTest.getRiskLevel(riskInfo5));

        List<MedicalReport> reports6 = new ArrayList<>();
        String content6 = "test6 ";
        for (int i = 0; i < 4; i++) {
            content6 = content6 + contents.get(i) + " ";
        }
        MedicalReport report6 = new MedicalReport("61fd564cb3db7d0b6c61d4lm", 2, LocalDate.of(2012, 12, 06), content6);
        reports6.add(report6);
        DiabetesRiskInfo riskInfo6 = new DiabetesRiskInfo();
        riskInfo6.setDob(dob);
        riskInfo6.setSex(Sex.M);
        riskInfo6.setContents(reports6);
        assertEquals(RiskLevel.IN_DANGER, underTest.getRiskLevel(riskInfo6));

        List<MedicalReport> reports7 = new ArrayList<>();
        String content7 = "test7 ";
        for (int i = 0; i < 5; i++) {
            content7 = content7 + contents.get(i) + " ";
        }
        MedicalReport report7 = new MedicalReport("61fd564cb3db7d0b6c61d4ml", 2, LocalDate.of(2012, 12, 06), content7);
        reports7.add(report7);
        DiabetesRiskInfo riskInfo7 = new DiabetesRiskInfo();
        riskInfo7.setDob(dob);
        riskInfo7.setSex(Sex.M);
        riskInfo7.setContents(reports7);
        assertEquals(RiskLevel.EARLY_ONSET, underTest.getRiskLevel(riskInfo7));

        List<MedicalReport> reports8 = new ArrayList<>();
        String content8 = "test8 ";
        MedicalReport report8 = new MedicalReport("61fd564cb3db7d0b6c61d4po", 2, LocalDate.of(2012, 12, 06), content8);
        reports8.add(report8);
        DiabetesRiskInfo riskInfo8 = new DiabetesRiskInfo();
        riskInfo8.setDob(dob);
        riskInfo8.setSex(Sex.M);
        riskInfo8.setContents(reports8);
        assertEquals(RiskLevel.NONE, underTest.getRiskLevel(riskInfo8));

        List<MedicalReport> reports9 = new ArrayList<>();
        String content9 = "test9 ";
        MedicalReport report9 = new MedicalReport("61fd564cb3db7d0b6c61d4ty", 2, LocalDate.of(2012, 12, 06), content9);
        reports9.add(report9);
        DiabetesRiskInfo riskInfo9 = new DiabetesRiskInfo();
        riskInfo9.setDob(dob);
        riskInfo9.setSex(Sex.F);
        riskInfo9.setContents(reports8);
        assertEquals(RiskLevel.NONE, underTest.getRiskLevel(riskInfo9));

        List<MedicalReport> reports10 = new ArrayList<>();
        String content10 = "test10 ";
        MedicalReport report10 = new MedicalReport("61fd564cb3db7d0b6c61d4rd", 2, LocalDate.of(2012, 12, 06), content10);
        reports10.add(report10);
        DiabetesRiskInfo riskInfo10 = new DiabetesRiskInfo();
        riskInfo10.setDob(LocalDate.of(1970, 12, 06));
        riskInfo10.setSex(Sex.F);
        riskInfo10.setContents(reports10);
        assertEquals(RiskLevel.NONE, underTest.getRiskLevel(riskInfo10));
    }

    @Test
    public void shouldReturnRiskAssessment(){
        LocalDate currentDate = LocalDate.now();
        LocalDate dob = LocalDate.of((currentDate.getYear() - 20), currentDate.getMonth(), currentDate.getDayOfMonth());
        List<String> contents = new ArrayList<String>();
        List<TriggeringFactors> triggeringFactors = underTest.getAllTriggeringFactors();
        String content = "test ";
        for (TriggeringFactors triggeringFactor : triggeringFactors) {
            contents.add(String.valueOf(triggeringFactor).toLowerCase());
        }

        List<MedicalReport> reports10 = new ArrayList<>();
        String content10 = "test10 ";
        MedicalReport report10 = new MedicalReport("61fd564cb3db7d0b6c61d4rd", 2, LocalDate.of(2012, 12, 06), contents.get(0));
        reports10.add(report10);
        DiabetesRiskInfo riskInfo10 = new DiabetesRiskInfo();
        riskInfo10.setDob(dob);
        riskInfo10.setSex(Sex.F);
        riskInfo10.setContents(reports10);
        DiabetesRiskAssessment riskAssessment = underTest.getRiskAssessment(riskInfo10);
        assertNotNull(riskAssessment);
        assertEquals(RiskLevel.NONE, riskAssessment.getRiskLevel());
        assertEquals(20, riskAssessment.getPatientAge());
        assertEquals(Sex.F,riskAssessment.getSex());
        assertTrue(riskAssessment.getTriggeringFactors().contains(contents.get(0).toUpperCase()));
    }

}




