package com.hospital.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hospital.model.Witness;

@RepositoryRestResource(collectionResourceRel = "witness", path = "witness")
public interface WitnessRepository extends CrudRepository<Witness, Long> {
    public Witness findById(int id);
    public Set<Witness> findAll();
}
