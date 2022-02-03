package com.mediscreen.userInterface.model;

import java.time.LocalDate;

/**
 * The type MedicalReport
 */
public class MedicalReport {

    String id;
    private int patientId;
    private LocalDate reportDate;
    private String content;

    public MedicalReport(int patientId, String content) {
        this.patientId = patientId;
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

    public void setId(String s) {
    }
}
