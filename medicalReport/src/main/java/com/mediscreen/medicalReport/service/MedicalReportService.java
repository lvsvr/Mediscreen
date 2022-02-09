package com.mediscreen.medicalReport.service;

import com.mediscreen.medicalReport.model.MedicalReport;

import java.util.List;

/**
 * The interface MedicalReportService
 */
public interface MedicalReportService {

    /**
     * Creates medical medicalReport
     *
     * @param medicalReport
     * @return medicalReport
     */
    MedicalReport addReport(MedicalReport medicalReport);

    /**
     * Reads medical report
     *
     * @param id
     * @return report
     */
    MedicalReport getReportById(String id);

    /**
     * Updates medical medicalReport
     *
     * @param id
     * @param updatedReport
     * @return medicalReport
     */
    MedicalReport updateReport(String id, MedicalReport updatedReport);

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
    List<MedicalReport> getAllReportsByPatientId(int patientId);

    /**
     * Deletes all medical reports of a patient
     *
     * @param patientId
     * @return report
     */
    void deleteAllReportsByPatientId(int patientId);

}
