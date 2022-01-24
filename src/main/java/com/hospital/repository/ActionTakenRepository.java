package com.hospital.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hospital.model.ActionTaken;

@RepositoryRestResource(collectionResourceRel = "accessTaken", path = "accessTaken")
public interface ActionTakenRepository extends CrudRepository<ActionTaken, Long> {
    public ActionTaken findById(int id);
    public Set<ActionTaken> findAll();
}
