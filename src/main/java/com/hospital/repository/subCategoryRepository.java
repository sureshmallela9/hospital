package com.hospital.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.hospital.model.SubCategory;

@RepositoryRestResource(collectionResourceRel = "subCategory", path = "subCategory")
public interface subCategoryRepository extends CrudRepository<SubCategory, Long> {
}
