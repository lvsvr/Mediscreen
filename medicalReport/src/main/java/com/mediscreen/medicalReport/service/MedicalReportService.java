package com.mediscreen.medicalReport.service;

import com.mediscreen.medicalReport.model.Report;

import java.util.List;

/**
 * The interface MedicalReportService
 */
public interface MedicalReportService {

    /**
     * Creates medical report
     *
     * @param report
     * @return report
     */
    Report addReport(Report report);

    /**
     * Reads medical report
     *
     * @param id
     * @return report
     */
    Report getReportById(String id);

    /**
     * Updates medical report
     *
     * @param report
     * @return report
     */
    Report updateReport(Report report);

    /**
     * Deletes medical report
     *
     * @param id
     * @return report
     */
    void deleteReport(String id);

    /**
     * Reads all medical reports of a patient
     *
     * @param patientId
     * @return report
     */
    List<Report> getAllReportsByPatientId(int patientId);

    /**
     * Deletes all medical reports of a patient
     *
     * @param patientId
     * @return report
     */
    void deleteAllReportsByPatientId(int patientId);

}
