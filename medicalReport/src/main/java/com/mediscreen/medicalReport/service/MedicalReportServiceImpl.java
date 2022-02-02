package com.mediscreen.medicalReport.service;

import com.mediscreen.medicalReport.model.MedicalReport;
import com.mediscreen.medicalReport.repository.MedicalReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The type MedicalReportServiceImpl
 */
@Service
public class MedicalReportServiceImpl implements MedicalReportService{

    @Autowired
    private MedicalReportRepository medicalReportRepository;

    @Override
    public MedicalReport addReport(MedicalReport medicalReport) {
        medicalReport.setReportDate(LocalDate.now());
        return medicalReportRepository.save(medicalReport);
    }

    @Override
    public MedicalReport getReportById(String id) {
        return medicalReportRepository.findById(id).get();
    }

    @Override
    public MedicalReport updateReport(MedicalReport updatedMedicalReport) {
        MedicalReport medicalReport = getReportById(updatedMedicalReport.getId());
        medicalReport.setContent(updatedMedicalReport.getContent());
        medicalReportRepository.save(medicalReport);
        return medicalReport;
    }

    @Override
    public void deleteReport(String id) {
        medicalReportRepository.deleteById(id);
    }

    @Override
    public List<MedicalReport> getAllReportsByPatientId(int patientId) {
        List<MedicalReport> medicalReports =  medicalReportRepository.findAll();
        List<MedicalReport> reportsByPatientId = new ArrayList();
        for ( MedicalReport medicalReport : medicalReports){
            if(medicalReport.getPatientId() == patientId){
                reportsByPatientId.add(medicalReport);
            }
        }
        Collections.reverse(reportsByPatientId);
        return reportsByPatientId;
    }

    @Override
    public void deleteAllReportsByPatientId(int patientId) {
        List<MedicalReport> medicalReports = getAllReportsByPatientId(patientId);
        for ( MedicalReport medicalReport : medicalReports){
            medicalReportRepository.delete(medicalReport);
        }
    }
}
