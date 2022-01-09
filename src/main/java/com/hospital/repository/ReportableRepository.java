package com.hospital.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.hospital.model.Category;
import com.hospital.model.Reportable;

@RepositoryRestResource(collectionResourceRel = "reportable", path = "reportable")
public interface ReportableRepository extends CrudRepository<Reportable, Long> {
    public Category findById(int id);
    public Set<Reportable> findAll();
}
