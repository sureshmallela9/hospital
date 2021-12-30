/*
 * package com.hospital.controller;
 * 
 * import java.util.ArrayList; import java.util.HashSet; import java.util.List;
 * import java.util.Set;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.hospital.model.Category; import
 * com.hospital.model.CategoryResponse; import com.hospital.model.SubCategory;
 * import com.hospital.model.SubCategoryResponse; import
 * com.hospital.repository.CategoryRepository; import
 * com.hospital.repository.SubCategoryRepository;
 * 
 * @RestController public class CategoryController {
 * 
 * @Autowired private CategoryRepository categoryRepository;
 * 
 * @Autowired private SubCategoryRepository subCategoryRepository;
 * 
 * @GetMapping("/categorys") public Set<CategoryResponse> getData () {
 * Set<Category> set = categoryRepository.findAll();
 * System.out.println("set size ::"+set.size()); Set<CategoryResponse>
 * responseList = new HashSet<>(); set.forEach(s -> { Set<SubCategoryResponse>
 * subCategoryList = new HashSet<>(); CategoryResponse response = new
 * CategoryResponse(); response.setId(s.getId()); response.setName(s.getName());
 * System.out.println("s.getSubCategorys() size ::"+s.getSubCategorys().size());
 * for (SubCategory subCat : s.getSubCategorys()) { SubCategoryResponse sub =
 * new SubCategoryResponse(); sub.setId(subCat.getId());
 * sub.setName(subCat.getName()); subCategoryList.add(sub); }
 * response.setSubCategorys(subCategoryList); responseList.add(response); });
 * return responseList; }
 * 
 * }
 */