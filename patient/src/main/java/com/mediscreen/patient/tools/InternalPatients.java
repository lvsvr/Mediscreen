package com.mediscreen.patient.tools;

import com.mediscreen.patient.exception.PatientAlreadyExistsException;
import com.mediscreen.patient.exception.PatientNotFoundException;
import com.mediscreen.patient.model.Patient;
import com.mediscreen.patient.repository.PatientRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * The type InternalPatients - tool for testing
 */
@Service
public class InternalPatients {
    private static final Logger logger = LogManager.getLogger("patient");


    private PatientRepository patientRepository;

    public InternalPatients(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void initializeInternalPatients() throws PatientAlreadyExistsException {

        if(! patientRepository.findAll().isEmpty()){
            throw new PatientAlreadyExistsException("Patient already exists");
        }
            IntStream.range(0, InternalTestHelper.getInternalPatientNumber()).forEach(i -> {
                Patient patient = new Patient();
                patient.setFirstName("internalFirstName" + i);
                patient.setLastName("internalLastName" + i);
                patient.setBirthDate(generateRandomLocalDate());
                patient.setGender("X");
                patient.setAddress("address: " + i);
                patient.setPhone("06" + i);

                patientRepository.save(patient);

            });
                logger.info("Created " + InternalTestHelper.getInternalPatientNumber() + " internal test patients.");
        }


    private LocalDate generateRandomLocalDate() {
        LocalDate startDate = LocalDate.of(1922, 1, 1); //start date
        long start = startDate.toEpochDay();
        LocalDate endDate = LocalDate.now(); //end date
        long end = endDate.toEpochDay();

        long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();

        return Instant.ofEpochSecond(randomEpochDay).atZone(ZoneId.systemDefault()).toLocalDate();

    }

    public void resetDb() throws PatientNotFoundException {
        if (patientRepository.findAll() == null){
            throw new PatientNotFoundException("No  patient has been found");
        }
        for( Patient patient : patientRepository.findAll()){
            patientRepository.delete(patient);
        }
    }

}
