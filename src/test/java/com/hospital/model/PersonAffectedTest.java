package com.hospital.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonAffectedTest {

    public static final String NAME = "categoryName";
    public static final Long ID = 1L;
    private PersonAffectedDetails personAffectedDetails;
    private PersonAffected personAffected;
    private List<PersonAffectedDetails> pfList;

    @BeforeEach
    public void setUp() throws Exception {
        personAffectedDetails = new PersonAffectedDetails();
        personAffected = new PersonAffected();
        pfList = new ArrayList<>();
        personAffected.setPa_id(ID);
        personAffected.setName(NAME);
        personAffectedDetails.setId(ID);
        personAffectedDetails.setName(NAME);
        pfList.add(personAffectedDetails);
        personAffected.setPersonAffectedDetails(pfList);
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
        assert personAffected.getPersonAffectedDetails() != null;
    }
}
