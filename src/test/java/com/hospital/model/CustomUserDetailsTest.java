package com.hospital.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomUserDetailsTest {

    private User user;
    private CustomUserDetails customUserDetails;
    
    @BeforeEach
    public void setUp() throws Exception {
        user = new User();
        user.setName("testUser");
        user.setEmail("eamil@com");
        user.setPassword("test password");
        customUserDetails = new CustomUserDetails(user);
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("Test Completed");

    }

    @Test
    public void testCustomUserDetails() throws Exception {
        assert customUserDetails.getAuthorities() == null;
        assert customUserDetails.getPassword() != null;
        assert customUserDetails.getUsername() != null;
        assert customUserDetails.isAccountNonExpired();
        assert customUserDetails.isAccountNonLocked();
        assert customUserDetails.isCredentialsNonExpired();
        assert customUserDetails.isEnabled();
    }
}
