package com.mediscreen.userInterface.proxy;

import com.mediscreen.userInterface.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The proxy feign interface PatientProxy.
 */
@FeignClient(value = "patient",url="${proxy.patient}")
public interface PatientProxy {

    /**
     * Gets a list of all patients
     *
     * @return a list of all patients
     */
    @GetMapping("/list")
    List<Patient> getAllPatients();

    /**
     * Gets a patient by id
     *
     * @param id
     * @return a patient
     */
    @GetMapping("/{id}")
    Patient getPatientById(@PathVariable("id") Integer id);

    /**
     * Gets patients by family
     *
     * @param family
     * @return list of patients with the same family name
     */
    @GetMapping("/search/{family}")
    List<Patient> getPatientsByName(@PathVariable("family") String family);

    /**
     * Gets patient deleted by id
     *
     * @param id
     */
    @GetMapping("/delete")
    void getPatientDeletedById(@RequestParam("id") Integer id);

    /**
     * Gets a new patient added to the db
     *
     * @return the patient
     */
    @PostMapping("/add")
    Patient addPatient(@RequestBody @Valid Patient patient);

    /**
     * Gets a patient updated
     *
     * @return the patient
     */
    @PostMapping("/update/{id}")
    Patient updatePatient(@PathVariable("id") Integer id, @RequestBody @Valid Patient patient);

}
