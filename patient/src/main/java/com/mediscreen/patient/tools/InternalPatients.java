//=========================================
//  uncomment  :
//
//     internalPatient
//  + internalTestingController
//  + internalTestingParameter
//  =
// GET a list of internal patients:
// http://localhost:9001/testing/initializeInternalPatients
//
// GET all the patients from the db:
// http://localhost:9001/testing/resetDb
//=========================================

//package com.mediscreen.patient.tools;
//
//import com.mediscreen.patient.exception.PatientAlreadyExistsException;
//import com.mediscreen.patient.exception.PatientNotFoundException;
//import com.mediscreen.patient.model.Patient;
//import com.mediscreen.patient.repository.PatientRepository;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.stereotype.Service;
//
//import java.time.Instant;
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.util.concurrent.ThreadLocalRandom;
//import java.util.stream.IntStream;
//
///**
// * The type InternalPatients - tool for testing
// */
//@Service
//public class InternalPatients {
//    private static final Logger logger = LogManager.getLogger("patient");
//
//
//    private PatientRepository patientRepository;
//
//    public InternalPatients(PatientRepository patientRepository) {
//        this.patientRepository = patientRepository;
//    }
//
//    /**
//     * Creates a list of internal patients
//     *
//     * @throws PatientAlreadyExistsException
//     */
//    public void initializeInternalPatients() throws PatientAlreadyExistsException {
//
//        if (!patientRepository.findAll().isEmpty()) {
//            throw new PatientAlreadyExistsException("Patient already exists");
//        }
//        IntStream.range(0, InternalTestingParameter.getInternalPatientNumber()).forEach(i -> {
//            Patient patient = new Patient();
//            patient.setGiven("internalGiven" + i);
//            patient.setFamily("internalFamily" + i);
//            patient.setDob(generateRandomLocalDate());
//            patient.setSex("X");
//            patient.setAddress("address: " + i);
//            patient.setPhone("06" + i);
//
//            patientRepository.save(patient);
//
//        });
//        logger.info("Created " + InternalTestingParameter.getInternalPatientNumber() + " internal test patients.");
//    }
//
//    /**
//     * Creates a random LocalDate
//     *
//     * @return LocalDate
//     */
//    public LocalDate generateRandomLocalDate() {
//        LocalDate startDate = LocalDate.of(1922, 1, 1); //start date
//        long start = startDate.toEpochDay();
//        LocalDate endDate = LocalDate.now(); //end date
//        long end = endDate.toEpochDay();
//
//        long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
//
//        return Instant.ofEpochSecond(randomEpochDay).atZone(ZoneId.systemDefault()).toLocalDate();
//
//    }
//
//    /**
//     * Deletes all the patients from the db
//     *
//     * @throws PatientNotFoundException
//     */
//    public void resetDb() throws PatientNotFoundException {
//        if (patientRepository.findAll().isEmpty()) {
//            throw new PatientNotFoundException("No  patient has been found");
//        }
//        for (Patient patient : patientRepository.findAll()) {
//            patientRepository.delete(patient);
//        }
//        logger.info("All the patients have been deleted");
//    }
//
//}
