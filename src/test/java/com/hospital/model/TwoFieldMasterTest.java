package com.hospital.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TwoFieldMasterTest {

    public static final String NAME = "testName";
    public static final Long ID = 1L;
    private TwoFieldMaster twoFieldMaster;
    private TwoFieldMasterDetails twoFieldMasterDetails;
    private List<TwoFieldMasterDetails> twoFieldMasterDetailsList;
    
    @BeforeEach
    public void setUp() throws Exception {
        twoFieldMaster = new TwoFieldMaster();
        twoFieldMasterDetails = new TwoFieldMasterDetails();
        twoFieldMasterDetailsList = new ArrayList<>();
        twoFieldMaster.setId(ID);
        twoFieldMaster.setName(NAME);
        twoFieldMasterDetails.setId(ID);
        twoFieldMasterDetails.setName(NAME);
        twoFieldMasterDetails.setTwoFieldMaster(twoFieldMaster);
        twoFieldMasterDetailsList.add(twoFieldMasterDetails);
        twoFieldMaster.setTwoFieldMasterDetails(twoFieldMasterDetailsList);
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("Test Completed");

    }

    @Test
    public void testContributingFactor() throws Exception {
        assertEquals(NAME, twoFieldMaster.getName());
        assertEquals(ID, twoFieldMaster.getId());
        assertEquals(ID, twoFieldMasterDetails.getId());
        assertEquals(NAME, twoFieldMasterDetails.getName());
        assert twoFieldMaster.getTwoFieldMasterDetails() != null;
    }

    @Test
    public void testContributingFactorDetails() throws Exception {
        assert twoFieldMasterDetails.getTwoFieldMaster() != null;
    }
}
