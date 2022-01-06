package com.hospital.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserPermissionTest {

    public static final String NAME = "Permission";
    public static final Long ID = 1L;
    public static final int number = 1;
    private UserPermission userPermission;
    private User user;

    @BeforeEach
    public void setUp() throws Exception {
        userPermission = new UserPermission();
        user = new User();
        userPermission.setId(ID);
        userPermission.setPermission(NAME);
        user.setId(ID);
        userPermission.setUser(user);
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("Test Completed");

    }

    @Test
    public void testSubCategoryDetails() throws Exception {
        assertEquals(NAME, userPermission.getPermission());
        assertEquals(ID, userPermission.getId());
        assert userPermission.getUser() != null;
    }
}
