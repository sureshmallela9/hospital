package com.hospital.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DepartmentTest {

    public static final String NAME = "deptName";
    public static final Long ID = 1L;
    private Department dept;
    
    @BeforeEach
    public void setUp() throws Exception {
        dept = new Department();
        dept.setId(ID);
        dept.setName(NAME);
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("Test Completed");

    }

    @Test
    public void testCategoryDetails() throws Exception {
        assertEquals(NAME, dept.getName());
        assertEquals(ID, dept.getId());
    }
}
