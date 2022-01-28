//package com.mediscreen.patient.controller;
//
//import com.mediscreen.patient.exception.PatientAlreadyExistsException;
//import com.mediscreen.patient.exception.PatientNotFoundException;
//import com.mediscreen.patient.tools.InternalPatients;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * The type PatientController.
// */
//@RestController
//@RequestMapping("/testing")
//public class InternalTestingController {
//    private static final Logger logger = LogManager.getLogger("patient");
//
//    @Autowired
//    private InternalPatients internalPatients;
//    /**
//     * Gets internal patients for tests created
//     *
//     * @throws PatientAlreadyExistsException
//     */
//    @GetMapping("/initializeInternalPatients")
//    public void createInternalPatients() throws PatientAlreadyExistsException {
//        internalPatients.initializeInternalPatients();
//        logger.info("REQUEST: /initializeInternalPatients" );
//    }
//
//    /**
//     * Gets all patients deleted from db
//     *
//     * @throws PatientNotFoundException
//     */
//    @GetMapping("/resetDb")
//    public void resetDb() throws PatientNotFoundException {
//        internalPatients.resetDb();
//        logger.info("REQUEST: /resetDb" );
//    }
//
//}
