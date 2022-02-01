package com.hospital.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    Set<ActionTaken> actionTaken = new HashSet<>();
    Set<Witness> witness = new HashSet<>();
    Set<Notification> notification = new HashSet<>();
    Set<Upload> upload = new HashSet<>();
    ActionTaken at;
    Notification nt;
    Witness wit;
    Upload up;
    
    @BeforeEach
    public void setUp() throws Exception {
        incidentReport = new IncidentReport();
        at = new ActionTaken();
        at.setId(0L);
        at.setAccessDateTime(new Date());
        at.setImmedActionTaken(stringValue);
        at.setAccessTakenBy(numberValue);
        actionTaken.add(at);
        incidentReport.setActionTaken(actionTaken);

        wit = new Witness();
        wit.setId(0L);
        wit.setWitnessDateTime(new Date());
        wit.setWitnessDept(numberValue);
        wit.setWitnessName(numberValue);
        witness.add(wit);
        incidentReport.setWitness(witness);
        nt = new Notification();
        nt.setDept(numberValue);
        nt.setId(0L);
        nt.setName(numberValue);
        nt.setNotificationDateTime(new Date());
        notification.add(nt);
        incidentReport.setNotification(notification);
        up = new Upload();
        up.setId(0L);
        up.setUpload(booleanValue);
        up.setUploadFilePath(stringValue);
        upload.add(up);
        incidentReport.setUpload(upload);
        incidentReport.setId(ID);
        incidentReport.setHeadofDepart(numberValue);
        incidentReport.setPersonAffected(booleanValue);
        incidentReport.setIncident_Date_Time(date);
        incidentReport.setContribFactorYesOrNo(booleanValue);
        incidentReport.setDeptsLookupMultiselect(stringValue);
        incidentReport.setContribFactor(numberValue);
        incidentReport.setLocation(numberValue);
        incidentReport.setLocationDetailsEntry(stringValue);
        incidentReport.setPatientYesOrNo(booleanValue);
        incidentReport.setPatientname(stringValue);
        incidentReport.setTypeofInci(numberValue);
        incidentReport.setInciCateg(numberValue);
        incidentReport.setInciSubCat(numberValue);
        incidentReport.setPreventability(numberValue);
        incidentReport.setIncidentReportedDept(numberValue);
        incidentReport.setSequence(stringValue);
        incidentReport.setTemplate(numberValue);
        incidentReport.setInciDescription(stringValue);
        incidentReport.setInciDescription(stringValue);
        incidentReport.setComplaIntegerDatetime(new Date());
        incidentReport.setComplaIntegerIdEntry(stringValue);
        incidentReport.setIrInvestigator(numberValue);
        incidentReport.setStatus(stringValue);
        incidentReport.setDepartment(stringValue);
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("Test Completed");

    }

    @Test
    public void testIncidentReportDetails() throws Exception {
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
        assertEquals(numberValue, incidentReport.getIncidentReportedDept());
        assertEquals(numberValue, incidentReport.getHeadofDepart());
        assertEquals(stringValue, incidentReport.getSequence());
        assertEquals(numberValue, incidentReport.getLocation());
        assertEquals(date, incidentReport.getIncident_Date_Time());
        assert up.getUploadFilePath() != null;
        assert up.getId() == 0;
        assert nt.getId() == 0;
        assert nt.getDept() == 1;
        assert nt.getNotificationDateTime() != null;
        assert nt.getName() == 1;
        assert wit.getId() == 0;
        assert wit.getWitnessDateTime() != null;
        assert wit.getWitnessName() == 1;
        assert wit.getWitnessDept() == 1;
        assert at.getAccessDateTime() != null;
        assert at.getAccessTakenBy() == 1;
        assert at.getId() == 0;
        assert at.getImmedActionTaken() != null;
        assert incidentReport.getActionTaken() != null;
        assert incidentReport.getWitness() != null;
        assert incidentReport.getNotification() != null;
        assert incidentReport.getUpload() != null;
        assert incidentReport.getContribFactorYesOrNo() != null;
        assert incidentReport.getComplaIntegerDatetime() != null;
        assert incidentReport.getComplaIntegerIdEntry() != null;
        assert incidentReport.getActionTakens() != null;
        assert incidentReport.getWitness() != null;
        assert incidentReport.getDepartment() != null;
        assert incidentReport.getIrInvestigator() == 1;
        assert incidentReport.getStatus() != null;
    }
}
