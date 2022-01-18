package com.hospital.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IncidentReportTest {

    public static final long ID = 1;
    public static final int numberValue = 1;
    public static final Date date = new Date();
    public static final boolean booleanValue = true;
    public static final String stringValue = "StringValue";

    private IncidentReport incidentReport;

    @BeforeEach
    public void setUp() throws Exception {
        incidentReport = new IncidentReport();
        incidentReport.setId(ID);
        incidentReport.setAction(booleanValue);
        incidentReport.setHeadofDepart(numberValue);
        incidentReport.setPersonAffected(booleanValue);
        incidentReport.setUpload(booleanValue);
        incidentReport.setIncident_Date_Time(date);
        incidentReport.setContribFactorYesOrNo(booleanValue);
        incidentReport.setDeptsLookupMultiselect(stringValue);
        incidentReport.setContribFactor(numberValue);
        incidentReport.setWitness(booleanValue);
        incidentReport.setLocation(numberValue);
        incidentReport.setLocationDetailsEntry(stringValue);
        incidentReport.setPatientYesOrNo(booleanValue);
        incidentReport.setPatientname(stringValue);
        incidentReport.setTypeofInci(numberValue);
        incidentReport.setInciCateg(numberValue);
        incidentReport.setInciSubCat(numberValue);
        incidentReport.setPreventability(numberValue);
        incidentReport.setIncidentNotification(booleanValue);
        incidentReport.setIncidentReportedDept(numberValue);
        incidentReport.setSequence(stringValue);
        incidentReport.setTemplate(numberValue);
        incidentReport.setInciDescription(stringValue);
        incidentReport.setInciDescription(stringValue);
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("Test Completed");

    }

    @Test
    public void testUserDetails() throws Exception {
        assertEquals(ID, incidentReport.getId());
        assertEquals(stringValue, incidentReport.getLocationDetailsEntry());
        assertEquals(booleanValue, incidentReport.getPatientYesOrNo());
        assertEquals(stringValue, incidentReport.getPatientname());
        assertEquals(numberValue, incidentReport.getTypeofInci());
        assertEquals(numberValue, incidentReport.getInciCateg());
        assertEquals(numberValue, incidentReport.getInciSubCat());
        assertEquals(numberValue, incidentReport.getTemplate());
        assertEquals(booleanValue, incidentReport.getPersonAffected());
        assertEquals(stringValue, incidentReport.getInciDescription());
        assertEquals(stringValue, incidentReport.getDeptsLookupMultiselect());
        assertEquals(booleanValue, incidentReport.getContribFactorYesOrNo());
        assertEquals(numberValue, incidentReport.getContribFactor());
        assertEquals(numberValue, incidentReport.getPreventability());
        assertEquals(booleanValue, incidentReport.getAction());
        assertEquals(booleanValue, incidentReport.getWitness());
        assertEquals(booleanValue, incidentReport.getIncidentNotification());
        assertEquals(booleanValue, incidentReport.getUpload());
        assertEquals(numberValue, incidentReport.getIncidentReportedDept());
        assertEquals(numberValue, incidentReport.getHeadofDepart());
        assertEquals(stringValue, incidentReport.getSequence());
        assertEquals(numberValue, incidentReport.getLocation());
        assertEquals(date, incidentReport.getIncident_Date_Time());
    }
}
