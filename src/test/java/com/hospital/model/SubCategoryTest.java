package com.hospital.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SubCategoryTest {

    public static final String NAME = "categoryName";
    public static final Long ID = 1L;
    public static final int TEMPLATE = 1;
    public static final Boolean STATUS = true;
    private SubCategory subCategory;
    private Category category;

    @BeforeEach
    public void setUp() throws Exception {
        category = new Category();
        subCategory = new SubCategory();
        category.setId(ID);
        category.setName(NAME);
        subCategory.setId(ID);
        subCategory.setName(NAME);
        subCategory.setSentinel(STATUS);
        subCategory.setStatus(STATUS);
//        subCategory.setReportable(STATUS);
        subCategory.setTemplate(TEMPLATE);
        subCategory.setCategory(category);
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("Test Completed");

    }

    @Test
    public void testSubCategoryDetails() throws Exception {
        assertEquals(NAME, category.getName());
        assertEquals(ID, category.getId());
        assertEquals(ID, subCategory.getId());
//        assertEquals(STATUS, subCategory.isReportable());
        assertEquals(STATUS, subCategory.isSentinel());
        assertEquals(STATUS, subCategory.isStatus());
        assertEquals(NAME, subCategory.getName());
        assertEquals(TEMPLATE, subCategory.getTemplate());
        assert subCategory.getCategory() != null;
    }
}
