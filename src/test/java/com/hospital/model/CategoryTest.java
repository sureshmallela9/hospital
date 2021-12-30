package com.hospital.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CategoryTest {

    public static final String NAME = "categoryName";
    public static final Long ID = 1L;
    public static final int TEMPLATE = 1;
    private Category category;
    private SubCategory subCategory;
    private Set<SubCategory> subCategoryList;
    
    @BeforeEach
    public void setUp() throws Exception {
        category = new Category();
        subCategory = new SubCategory();
        subCategoryList = new HashSet<>();
        category.setId(ID);
        category.setName(NAME);
        subCategory.setId(ID);
        subCategory.setName(NAME);
        subCategory.setTemplate(TEMPLATE);
        subCategoryList.add(subCategory);
        category.setSubCategorys(subCategoryList);
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("Test Completed");

    }

    @Test
    public void testCategoryDetails() throws Exception {
        assertEquals(NAME, category.getName());
        assertEquals(ID, category.getId());
        assertEquals(ID, subCategory.getId());
        assertEquals(NAME, subCategory.getName());
        assert category.getSubCategorys() != null;
    }
}
