package com.hospital.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hospital.model.Upload;

@RepositoryRestResource(collectionResourceRel = "upload", path = "upload")
public interface UploadRepository extends CrudRepository<Upload, Long> {
    public Upload findById(int id);
    public Set<Upload> findAll();
}
