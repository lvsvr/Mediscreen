package com.mediscreen.medicalReport.repository;

import com.mediscreen.medicalReport.model.MedicalReport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalReportRepository extends MongoRepository<MedicalReport, String> {
}
