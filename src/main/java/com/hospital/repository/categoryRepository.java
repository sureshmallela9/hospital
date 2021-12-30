package com.hospital.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.hospital.model.Category;

@RepositoryRestResource(collectionResourceRel = "category", path = "category")
@CrossOrigin("*")
public interface CategoryRepository extends CrudRepository<Category, Long> {
    public Category findById(int id);
    public Set<Category> findAll();
}
