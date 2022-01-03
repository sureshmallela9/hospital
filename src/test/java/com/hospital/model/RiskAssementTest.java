package com.hospital.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RiskAssementTest {

    public static final int LIKELIHOOD = 1;
    public static final int SERVERITY = 1;
    public static final int RISKSCORE = 1;
    public static final int RISKSTATUS = 1;
    public static final String TEMPLATE = "temp";
    public static final boolean show = true;
    public static final String COLOR = "color";
    public static final Boolean STATUS = true;
    public static final Long ID = 1L;
    private RiskAssement riskAssement;

    @BeforeEach
    public void setUp() throws Exception {
        riskAssement = new RiskAssement();
        riskAssement.setId(ID);
        riskAssement.setColor(COLOR);
        riskAssement.setShow(show);
        riskAssement.setLikelihood(LIKELIHOOD);
        riskAssement.setServerity(SERVERITY);
        riskAssement.setTemplate(TEMPLATE);
        riskAssement.setRiskstatus(RISKSTATUS);
        riskAssement.setRiskscore(RISKSCORE);
        riskAssement.setStatus(STATUS);
        
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("Test Completed");

    }

    @Test
    public void testUserDetails() throws Exception {
        assertEquals(ID, riskAssement.getId());
        assertEquals(COLOR, riskAssement.getColor());
        assertEquals(show, riskAssement.isShow());
        assertEquals(LIKELIHOOD, riskAssement.getLikelihood());
        assertEquals(SERVERITY, riskAssement.getServerity());
        assertEquals(TEMPLATE, riskAssement.getTemplate());
        assertEquals(RISKSCORE, riskAssement.getRiskscore());
        assertEquals(RISKSTATUS, riskAssement.getRiskstatus());
        assertEquals(STATUS, riskAssement.isStatus());
    }
}
