package com.hospital.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RcaTest {

    public static final String NAME = "categoryName";
    public static final Long ID = 1L;
    public static final boolean show = true;
    private Rca rca;
    private RcaCauses rcaCauses;
    private List<RcaCauses> rcaCausesList;
    
    @BeforeEach
    public void setUp() throws Exception {
        rca = new Rca();
        rcaCauses = new RcaCauses();
        rcaCausesList = new ArrayList<>();
        rca.setId(ID);
        rca.setName(NAME);
        rca.setShow(show);
        rcaCauses.setId(ID);
        rcaCauses.setName(NAME);
        rcaCausesList.add(rcaCauses);
        rca.setRcaCauses(rcaCausesList);
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("Test Completed");

    }

    @Test
    public void testCategoryDetails() throws Exception {
        assertEquals(NAME, rca.getName());
        assertEquals(ID, rca.getId());
        assertEquals(ID, rcaCauses.getId());
        assertEquals(NAME, rcaCauses.getName());
        assertEquals(show, rca.isShow());
        assert rca.getRcaCauses() != null;
    }
}
