package com.mediscreen.userInterface.proxy;

import com.mediscreen.userInterface.model.MedicalReport;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

/**
 * The proxy feign interface MedicalReportProxy.
 */
@FeignClient(value = "medicalReport", url = "${proxy.medicalReport}")
public interface MedicalReportProxy {

    /**
     * Gets a new medical medicalReport added to the db
     *
     * @param medicalReport
     * @return the report
     */
    @PostMapping("/add")
    MedicalReport addMedicalReport(@RequestBody @Valid MedicalReport medicalReport);

    /**
     * Gets a medical report by id
     *
     * @param id
     * @return a report
     */
    @GetMapping("/{id}")
    MedicalReport getMedicalReportById(@PathVariable("id") String id);

    /**
     * Gets a medical medicalReport updated
     *
     * @param id
     * @param updatedMedicalReport
     * @return the medicalReport
     */
    @PostMapping("/update/{id}")
    MedicalReport updateMedicalReport(@PathVariable("id") String id, @RequestBody MedicalReport updatedMedicalReport);

    /**
     * Gets a list of all medical reports by patient id
     *
     * @return for a given patient, returns a list of all medical reports
     * @parm id
     */
    @GetMapping("/list/{id}")
    List<MedicalReport> getAllReportsByPatientId(@PathVariable("id") int id);

    /**
     * Deletes a list of all medical reports by patient id
     *
     * @return for a given patient, deletes all medical reports
     * @parm id
     */
    @GetMapping("/delete/list/{id}")
    void deleteAllReportsByPatientId(@PathVariable("id") int id);

}
