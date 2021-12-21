package com.hospital.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hospital.model.ContributingFactorDetails;

@RepositoryRestResource(collectionResourceRel = "contributingFactorDetails", path = "contributingFactorDetails")
public interface ContributingFactorDetailsRepository extends CrudRepository<ContributingFactorDetails, Long> {
}
