package com.hospital.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.hospital.model.PersonAffected;

@RepositoryRestResource(collectionResourceRel = "personAffected", path = "personAffected")
public interface PersonAffectedRepository extends CrudRepository<PersonAffected, Long> {
}
