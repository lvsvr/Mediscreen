package com.mediscreen.medicalReport.service;

import com.mediscreen.medicalReport.model.Report;
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
    public Report addReport(Report report) {
        report.setReportDate(LocalDate.now());
        return medicalReportRepository.save(report);
    }

    @Override
    public Report getReportById(String id) {
        return medicalReportRepository.findById(id).get();
    }

    @Override
    public Report updateReport(Report updatedReport) {
        Report report = getReportById(updatedReport.getId());
        report.setContent(updatedReport.getContent());
        return report;
    }

    @Override
    public void deleteReport(String id) {
        medicalReportRepository.deleteById(id);
    }

    @Override
    public List<Report> getAllReportsByPatientId(int patientId) {
        List<Report> reports =  medicalReportRepository.findAll();
        List<Report> reportsByPatientId = new ArrayList();
        for ( Report report:reports){
            if(report.getPatientId() == patientId){
                reportsByPatientId.add(report);
            }
        }
        Collections.reverse(reportsByPatientId);
        return reportsByPatientId;
    }

    @Override
    public void deleteAllReportsByPatientId(int patientId) {
        List<Report> reports = getAllReportsByPatientId(patientId);
        for ( Report report:reports){
            medicalReportRepository.delete(report);
        }
    }
}
