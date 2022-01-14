package com.hospital.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.hospital.model.User;
import com.hospital.repository.UserRepository;

@WebMvcTest
public class CustomUserDetailsServiceTest {


	@Autowired
    private MockMvc mockMvc;
 
    @MockBean
    private UserRepository userRepo;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Test
    void loadUserByUsernameTest() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("testUser");
        user.setEmail("test@email.com");
        user.setPassword("test");
        when(userRepo.findByUserName(user.getName())).thenReturn(user);
        UserDetails userDetails = customUserDetailsService.loadUserByUsername("testUser");
        System.out.println("userDetails :"+userDetails);
        assert userDetails != null;
    } 

    @Test
    void loadUserByUsernameWithUsernameNotFoundExceptionTest() throws Exception {
        boolean thrown = false;
        when(userRepo.findByUserName("testUser")).thenReturn(null);
        try {
                customUserDetailsService.loadUserByUsername("testUser");
        } catch (Exception e) {
                thrown = true;
        }
        assertTrue(thrown);
    }
}
