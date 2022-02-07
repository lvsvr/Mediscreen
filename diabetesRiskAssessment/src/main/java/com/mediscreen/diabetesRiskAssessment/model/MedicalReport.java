package com.mediscreen.diabetesRiskAssessment.model;

import java.time.LocalDate;

/**
 * The type MedicalReport
 */
public class MedicalReport {

    String id;
    private int patientId;
    private LocalDate reportDate;
    private String content;

    public MedicalReport(String id, int patientId, LocalDate reportDate, String content) {
        this.id = id;
        this.patientId = patientId;
        this.reportDate = reportDate;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MedicalReport{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", reportDate=" + reportDate +
                ", content='" + content + '\'' +
                '}';
    }

}
