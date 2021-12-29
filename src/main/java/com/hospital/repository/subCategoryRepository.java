package com.hospital.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.hospital.model.SubCategory;

@RepositoryRestResource(collectionResourceRel = "subCategory", path = "subCategory")
@CrossOrigin("*")
public interface subCategoryRepository extends CrudRepository<SubCategory, Long> {
    public SubCategory findById(Integer id);
    public List<SubCategory> findAll();
}
