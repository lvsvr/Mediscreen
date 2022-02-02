package com.mediscreen.medicalReport.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Document(collection = "report")
public class MedicalReport {
    @Id
    private String id;
    @Field("patientId")
    @NotNull
    private int patientId;
    @Field("date")
    private LocalDate reportDate;
    @Field("content")
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
}
