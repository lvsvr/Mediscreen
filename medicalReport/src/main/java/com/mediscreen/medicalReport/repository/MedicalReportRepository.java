package com.mediscreen.medicalReport.repository;

import com.mediscreen.medicalReport.model.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalReportRepository extends MongoRepository<Report, String> {
}
