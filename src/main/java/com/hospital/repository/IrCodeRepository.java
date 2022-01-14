package com.hospital.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.hospital.model.IRCodeConfiguration;

@RepositoryRestResource(collectionResourceRel = "sequence", path = "sequence")
public interface IrCodeRepository extends CrudRepository<IRCodeConfiguration, Long> {
    public IRCodeConfiguration findById(int id);
    public List<IRCodeConfiguration> findAll();
}
