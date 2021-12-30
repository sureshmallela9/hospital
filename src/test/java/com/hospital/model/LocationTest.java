package com.hospital.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LocationTest {

    public static final int code = 1;
    public static final int locationType = 1;
    public static final String name = "name";
    public static final Boolean STATUS = true;
    public static final Long ID = 1L;
    private Location location;

    @BeforeEach
    public void setUp() throws Exception {
        location = new Location();
        location.setId(ID);
        location.setStatus(STATUS);
        location.setCode(code);
        location.setName(name);
        location.setLocationType(locationType);
        
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("Test Completed");

    }

    @Test
    public void testUserDetails() throws Exception {
        assertEquals(ID, location.getId());
        assertEquals(code, location.getCode());
        assertEquals(STATUS, location.isStatus());
        assertEquals(locationType, location.getLocationType());
        assertEquals(name, location.getName());
    }
}
