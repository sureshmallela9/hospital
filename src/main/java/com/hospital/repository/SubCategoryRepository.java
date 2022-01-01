package com.hospital.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.hospital.model.SubCategory;

@RepositoryRestResource(collectionResourceRel = "subCategory", path = "subCategory")
public interface SubCategoryRepository extends CrudRepository<SubCategory, Long> {
    public SubCategory findById(int id);
    public Set<SubCategory> findAll();
}
