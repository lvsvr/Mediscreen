package com.mediscreen.patient.tools;

import com.mediscreen.patient.model.Patient;
import com.mediscreen.patient.model.Sex;
import com.mediscreen.patient.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DbInitService implements CommandLineRunner {

    private PatientRepository patientRepository;

    public DbInitService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (patientRepository.findAll().isEmpty()) {
            Patient p0 = new Patient();
            p0.setFamily("TestNone");
            p0.setGiven("Test");
            p0.setDob(LocalDate.of(1966, 12, 31));
            p0.setSex(Sex.F);
            p0.setAddress("1 Brookside St");
            p0.setPhone("100-222-3333");

            Patient p1 = new Patient();
            p1.setFamily("TestBorderline");
            p1.setGiven("Test1");
            p1.setDob(LocalDate.of(1945, 06, 24));
            p1.setSex(Sex.M);
            p1.setAddress("2 High St");
            p1.setPhone("200-333-4444");

            Patient p2 = new Patient();
            p2.setFamily("TestInDanger");
            p2.setGiven(("Test2"));
            p2.setDob(LocalDate.of(2004, 06, 18));
            p2.setSex(Sex.M);
            p2.setAddress("3 Club Road");
            p2.setPhone("300-444-5555");

            Patient p3 = new Patient();
            p3.setFamily("TestEarlyOnset");
            p3.setGiven(("Test3"));
            p3.setDob(LocalDate.of(2002, 06, 28));
            p3.setSex(Sex.F);
            p3.setAddress("4 Valley Dr");
            p3.setPhone("400-555-6666");

            this.patientRepository.save(p0);
            this.patientRepository.save(p1);
            this.patientRepository.save(p2);
            this.patientRepository.save(p3);
        }
    }
}
