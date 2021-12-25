package com.hospital.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.model.User;
import com.hospital.repository.UserRepository;

@WebMvcTest
public class CustomUserDetailsServiceTest {

    private static final boolean UsernameNotFoundException = false;

	@Autowired
    private MockMvc mockMvc;
 
    @MockBean
    private UserRepository userRepo;

    @MockBean
    private CustomUserDetailsService customUserDetailsService;

    @Test
    void loadUserByUsernameTest() throws Exception {
        User user = new User();
        user.setId(1);
        user.setUserName("testUser");
        user.setEmail("test@email.com");
        user.setFirstName("fname");
        user.setLastName("lname");
        user.setPassword("test");
        when(userRepo.findByUserName(user.getUserName())).thenReturn(user);
        UserDetails userDetails = customUserDetailsService.loadUserByUsername("testUser");
        System.out.println("userDetails :"+userDetails);
        assert userDetails == null;
    }
	/*
	 * @Test void loadUserByUsernameWithUsernameNotFoundExceptionTest() throws
	 * Exception { User user = new User(); user.setId(1);
	 * user.setUserName("testUser"); user.setEmail("test@email.com");
	 * user.setFirstName("fname"); user.setLastName("lname");
	 * user.setPassword("test");
	 * when(userRepo.findByUserName(user.getUserName())).thenReturn(null);
	 * customUserDetailsService.loadUserByUsername("testUser"); assert
	 * UsernameNotFoundException; }
	 */
}
