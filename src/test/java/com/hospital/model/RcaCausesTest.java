package com.hospital.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RcaCausesTest {

    public static final String NAME = "categoryName";
    public static final Long ID = 1L;
    private RcaCauses rcaCauses;
    private Rca rca;

    @BeforeEach
    public void setUp() throws Exception {
        rcaCauses = new RcaCauses();
        rca = new Rca();
        rca.setId(ID);
        rca.setName(NAME);
        rcaCauses.setId(ID);
        rcaCauses.setName(NAME);
        rcaCauses.setRca(rca);
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("Test Completed");

    }

    @Test
    public void testSubCategoryDetails() throws Exception {
        assertEquals(NAME, rca.getName());
        assertEquals(ID, rca.getId());
        assertEquals(ID, rcaCauses.getId());
        assertEquals(NAME, rcaCauses.getName());
        assert rcaCauses.getRca() != null;
    }
}
