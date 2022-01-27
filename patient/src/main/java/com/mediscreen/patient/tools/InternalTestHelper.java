package com.mediscreen.patient.tools;

/**
 * The type InternalTestHelper - parameter for InternalPatient (testing tool)
 */
public class InternalTestHelper {

    private static int internalPatientNumber = 10;

    public static void setInternalPatientNumber(int internalPatientNumber) {
        InternalTestHelper.internalPatientNumber = internalPatientNumber;
    }

    public static int getInternalPatientNumber() {
        return internalPatientNumber;
    }
}
