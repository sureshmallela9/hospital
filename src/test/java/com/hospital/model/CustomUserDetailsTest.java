package com.hospital.model;


import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.hospital.repository.UserRepository;
import com.hospital.service.CustomUserDetailsService;

public class CustomUserDetailsTest {

    public static final String STRINGVALUE = "userName";

    @InjectMocks
    private CustomUserDetails customUserDetails;

    @Mock
    private UserRepository userRepo;

    @Mock
    private CustomUserDetailsService customUserDetailsService;
    private User user;

    @BeforeEach
    public void setUp() throws Exception {
        user = new User();
        user.setName("testUser");
        user.setEmail("eamil@com");
        user.setPassword("test password");
        user.setContact(STRINGVALUE);
        user.setDepartment(0);
        user.setCountry(STRINGVALUE);
        user.setEmployeeId(STRINGVALUE);
        user.setGender(STRINGVALUE);
        user.setEmail(STRINGVALUE);
        user.setRole(STRINGVALUE);
        user.setId(0L);
        user.setDob(new Date());
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
        assert user.getContact() != null;
        assert user.getContact() != null;
        assert user.getDepartment() == 0;
        assert user.getEmail() != null;
        assert user.getEmployeeId() != null;
        assert user.getGender() != null;
        assert user.getRole() != null;
        assert user.getContact() != null;
        assert user.getCountry() != null;
        assert user.getId() == 0;
        assert user.getDob() != null;
        assert customUserDetails.isEnabled();
    }

	/*
	 * @Test public void testLoadUserName() throws Exception { UserDetails
	 * userDetails = customUserDetailsService.loadUserByUsername(NAME);
	 * when(userRepo.findByUserName(NAME)).thenReturn(user); assert userDetails !=
	 * null; }
	 */
}
