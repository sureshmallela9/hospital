package com.hospital.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hospital.model.ContributingFactors;

@RepositoryRestResource(collectionResourceRel = "contributingFactors", path = "contributingFactors")
public interface ContributingFactorsRepository extends CrudRepository<ContributingFactors, Long> {
}
