package com.hospital.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonAffectedDetailsTest {

    public static final String NAME = "categoryName";
    public static final Long ID = 1L;
    public static final Boolean SHOW = true;
    private PersonAffectedDetails personAffectedDetails;
    private PersonAffected personAffected;

    @BeforeEach
    public void setUp() throws Exception {
        personAffected = new PersonAffected();
        personAffectedDetails = new PersonAffectedDetails();
        personAffected.setPa_id(ID);
        personAffected.setName(NAME);
        personAffectedDetails.setId(ID);
        personAffectedDetails.setName(NAME);
        personAffectedDetails.setShow(true);
        personAffectedDetails.setPersonAffected(personAffected);
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("Test Completed");

    }

    @Test
    public void testSubCategoryDetails() throws Exception {
        assertEquals(NAME, personAffected.getName());
        assertEquals(ID, personAffected.getPa_id());
        assertEquals(ID, personAffectedDetails.getId());
        assertEquals(NAME, personAffectedDetails.getName());
        assertEquals(SHOW, personAffectedDetails.isShow());
        assert personAffectedDetails.getPersonAffected() != null;
    }
}
