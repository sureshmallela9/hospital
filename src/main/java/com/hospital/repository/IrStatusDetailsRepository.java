package com.hospital.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hospital.model.IrStatusDetails;

@RepositoryRestResource(collectionResourceRel = "irStatusDetails", path = "irStatusDetails")
public interface IrStatusDetailsRepository extends CrudRepository<IrStatusDetails, Long> {
    public IrStatusDetails findById(int id);
    public Set<IrStatusDetails> findAll();
}
