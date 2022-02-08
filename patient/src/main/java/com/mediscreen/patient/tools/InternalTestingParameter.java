////=========================================
////  uncomment  :
////
////     internalPatient
////  + internalTestingController
////  + internalTestingParameter
////  =
//// GET a list of internal patients:
//// http://localhost:9001/testing/initializeInternalPatients
////
//// GET all the patients from the db:
//// http://localhost:9001/testing/resetDb
////=========================================
//
//package com.mediscreen.patient.tools;
//
///**
// * The type InternalTestingParameter - parameter for InternalPatient (testing tool)
// */
//public class InternalTestingParameter {
//
//    private static int internalPatientNumber = 10;
//
//    public static void setInternalPatientNumber(int internalPatientNumber) {
//        InternalTestingParameter.internalPatientNumber = internalPatientNumber;
//    }
//
//    public static int getInternalPatientNumber() {
//        return internalPatientNumber;
//    }
//}