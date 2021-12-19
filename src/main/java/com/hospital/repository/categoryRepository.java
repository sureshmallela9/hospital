package com.hospital.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hospital.model.Category;

@RepositoryRestResource(collectionResourceRel = "category", path = "category")
public interface categoryRepository extends CrudRepository<Category, Long> {
}
