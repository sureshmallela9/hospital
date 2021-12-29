package com.hospital.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hospital.model.PersonAffected;

@RepositoryRestResource(collectionResourceRel = "personAffected", path = "personAffected")
@CrossOrigin("*")
public interface PersonAffectedRepository extends CrudRepository<PersonAffected, Long> {
}
