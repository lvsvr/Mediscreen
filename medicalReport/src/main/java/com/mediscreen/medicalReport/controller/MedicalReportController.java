package com.mediscreen.medicalReport.controller;

import com.mediscreen.medicalReport.model.Report;
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
     * Gets a new medical report added to the db
     *
     * @param report
     * @return the patient
     */
    @PostMapping("/add")
    public Report addMedicalReport(@RequestBody @Valid Report report) {
        Report newReport = medicalReportService.addReport(report);
        logger.info("REQUEST: POST /add : " + newReport.toString());
        return newReport;
    }

    /**
     * Gets a list of all reports
     *
     * @return a list of all reports
     */
    @GetMapping("/list")
    public List<Report> getAllReports() {
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
    public Report getMedicalReportById(@PathVariable("id") String id) {
        logger.info("REQUEST: GET /{id} : " + id);
        return medicalReportService.getReportById(id);


    }

    /**
     * Gets a medical report updated
     *
     * @param id
     * @param report
     * @return the report
     */
    @PostMapping("/update/{id}")
    public Report updateMedicalReport(@PathVariable("id") String id, @RequestBody @Valid Report report) {
        logger.info("REQUEST: POST /updateP/{id}:  from " + medicalReportService.getReportById(report.getId()) + ", to " + report.toString());
        return medicalReportService.updateReport(report);
    }

    /**
     * Gets a list of all medical reports by patient id
     *
     * @return for a given patient, returns a list of all medical reports
     * @parm id
     */
    @GetMapping("/list/{id}")
    public List<Report> getAllReportsByPatientId(@PathVariable("id") int id) {
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
