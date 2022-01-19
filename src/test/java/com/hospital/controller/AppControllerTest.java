/*
 * package com.hospital.controller;
 * 
 * import static org.mockito.Mockito.when;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.junit.jupiter.api.Test; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.http.MediaType; import
 * org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers;
 * 
 * import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
 * import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 * 
 * import com.fasterxml.jackson.databind.ObjectMapper; import
 * com.hospital.model.User; import com.hospital.repository.UserRepository;
 * 
 * @WebMvcTest public class AppControllerTest {
 * 
 * @Autowired private MockMvc mockMvc;
 * 
 * @MockBean private UserRepository userRepo;
 * 
 * @Test void findAllUserDetailsTest() throws Exception { List<User> userList =
 * new ArrayList<>(); User user = new User(); user.setId(1L);
 * user.setName("testUser"); user.setEmail("test@email.com");
 * userList.add(user); user.setPassword("test");
 * when(userRepo.findAll()).thenReturn(userList);
 * mockMvc.perform(get("/userDetails")) .andExpect(status().isOk())
 * .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
 * .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("testUser")); }
 * 
 * @Test void saveUserTest() throws Exception { User user = new User();
 * user.setId(1L); user.setName("testUser"); user.setEmail("test@email.com");
 * user.setPassword("test"); mockMvc.perform(post("/saveUser")
 * .content(asJsonString(user)) .contentType(MediaType.APPLICATION_JSON))
 * .andExpect(status().isOk()); } public static String asJsonString(final Object
 * obj) { try { final ObjectMapper mapper = new ObjectMapper(); final String
 * jsonContent = mapper.writeValueAsString(obj); return jsonContent; } catch
 * (Exception e) { throw new RuntimeException(e); } } }
 */