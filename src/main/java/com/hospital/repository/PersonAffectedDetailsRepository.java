package com.hospital.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hospital.model.PersonAffectedDetails;

@RepositoryRestResource(collectionResourceRel = "personAffectedDetails", path = "personAffectedDetails")
public interface PersonAffectedDetailsRepository extends CrudRepository<PersonAffectedDetails, Long> {
}
