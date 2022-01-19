package com.hospital.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.hospital.model.Category;

//import io.swagger.annotations.Api;

//@Api(tags = "category")
@RepositoryRestResource(collectionResourceRel = "category", path = "category")
public interface CategoryRepository extends CrudRepository<Category, Long> {
    public Category findById(int id);
    public Set<Category> findAll();
}
