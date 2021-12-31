package com.hospital.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContributingFactorTest {

    public static final String NAME = "testName";
    public static final Long ID = 1L;
    private ContributingFactors contribuingFactors;
    private ContributingFactorDetails cfDetails;
    private List<ContributingFactorDetails> cfDetailsList;
    
    @BeforeEach
    public void setUp() throws Exception {
        contribuingFactors = new ContributingFactors();
        cfDetails = new ContributingFactorDetails();
        cfDetailsList = new ArrayList<>();
        contribuingFactors.setCf_id(ID);
        contribuingFactors.setName(NAME);
        cfDetails.setId(ID);
        cfDetails.setName(NAME);
        cfDetails.setContributingFactors(contribuingFactors);
        cfDetailsList.add(cfDetails);
        contribuingFactors.setContributingFactorDetails(cfDetailsList);
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("Test Completed");

    }

    @Test
    public void testContributingFactor() throws Exception {
        assertEquals(NAME, contribuingFactors.getName());
        assertEquals(ID, contribuingFactors.getCf_id());
        assertEquals(ID, cfDetails.getId());
        assertEquals(NAME, cfDetails.getName());
        assert contribuingFactors.getContributingFactorDetails() != null;
    }

    @Test
    public void testContributingFactorDetails() throws Exception {
        assert cfDetails.getContributingFactors() != null;
    }
}
