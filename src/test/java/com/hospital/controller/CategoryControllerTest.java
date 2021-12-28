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
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 * 
 * import com.hospital.model.Category; import com.hospital.model.SubCategory;
 * import com.hospital.repository.CategoryRepository;
 * 
 * @WebMvcTest public class CategoryControllerTest {
 * 
 * @Autowired private MockMvc mockMvc;
 * 
 * @Autowired private CategoryRepository categoryRepository;
 * 
 * @Test void findAllCategoryTest() throws Exception { List<Category>
 * categoryList = new ArrayList<>(); List<SubCategory> subCategoryList = new
 * ArrayList<>(); Category category = new Category();
 * category.setName("testName"); category.setSubCategory(subCategoryList);
 * categoryList.add(category);
 * when(categoryRepository.findAll()).thenReturn(categoryList);
 * mockMvc.perform(get("/category")) .andExpect(status().isOk())
 * .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
 * .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("testName")); }
 * 
 * 
 * @Test void saveUserTest() throws Exception { User user = new User();
 * user.setId(1); user.setUserName("testUser"); user.setEmail("test@email.com");
 * user.setFirstName("fname"); user.setLastName("lname");
 * user.setPassword("test"); mockMvc.perform(post("/saveUser")
 * .content(asJsonString(user)) .contentType(MediaType.APPLICATION_JSON))
 * .andExpect(status().isOk()); } public static String asJsonString(final Object
 * obj) { try { final ObjectMapper mapper = new ObjectMapper(); final String
 * jsonContent = mapper.writeValueAsString(obj); return jsonContent; } catch
 * (Exception e) { throw new RuntimeException(e); } }
 * 
 * }
 */