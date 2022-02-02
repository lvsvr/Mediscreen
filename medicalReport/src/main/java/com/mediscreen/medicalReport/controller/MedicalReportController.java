package com.mediscreen.medicalReport.controller;

import com.mediscreen.medicalReport.model.MedicalReport;
import com.mediscreen.medicalReport.repository.MedicalReportRepository;
import com.mediscreen.medicalReport.service.MedicalReportService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The type MedicalReportController.
 */
@RestController
@RequestMapping("/medicalReport")
public class MedicalReportController {
    private static final Logger logger = LogManager.getLogger("medicalReport");

    @Autowired
    private MedicalReportService medicalReportService;
    @Autowired
    private MedicalReportRepository repo;

    /**
     * Gets a new medical medicalReport added to the db
     *
     * @param medicalReport
     * @return the patient
     */
    @PostMapping("/add")
    public MedicalReport addMedicalReport(@RequestBody @Valid MedicalReport medicalReport) {
        MedicalReport newMedicalReport = medicalReportService.addReport(medicalReport);
        logger.info("REQUEST: POST /add : " + newMedicalReport.toString());
        return newMedicalReport;
    }

    /**
     * Gets a list of all reports
     *
     * @return a list of all reports
     */
    @GetMapping("/list")
    public List<MedicalReport> getAllReports() {
        logger.info("REQUEST: GET  /list");
        return repo.findAll();
    }

    /**
     * Gets a medical report by id
     *
     * @param id
     * @return a report
     */
    @GetMapping("/{id}")
    public MedicalReport getMedicalReportById(@PathVariable("id") String id) {
        logger.info("REQUEST: GET /{id} : " + id);
        return medicalReportService.getReportById(id);


    }

    /**
     * Gets a medical medicalReport updated
     *
     * @param id
     * @param medicalReport
     * @return the medicalReport
     */
    @PostMapping("/update/{id}")
    public MedicalReport updateMedicalReport(@PathVariable("id") String id, @RequestBody @Valid MedicalReport medicalReport) {
        logger.info("REQUEST: POST /updateP/{id}:  from " + medicalReportService.getReportById(medicalReport.getId()) + ", to " + medicalReport.toString());
        return medicalReportService.updateReport(medicalReport);
    }

    /**
     * Gets a list of all medical reports by patient id
     *
     * @return for a given patient, returns a list of all medical reports
     * @parm id
     */
    @GetMapping("/list/{id}")
    public List<MedicalReport> getAllReportsByPatientId(@PathVariable("id") int id) {
        logger.info("REQUEST: GET  /list/{id} : " + id);
        return medicalReportService.getAllReportsByPatientId(id);
    }

    /**
     * Deletes a list of all medical reports by patient id
     *
     * @return for a given patient, deletes all medical reports
     * @parm id
     */
    @GetMapping("/delete/list/{id}")
    public void deleteAllReportsByPatientId(@PathVariable("id") int id) {
        logger.info("REQUEST: GET  /delete/list/{id} : " + id);
        medicalReportService.deleteAllReportsByPatientId(id);
    }

}
