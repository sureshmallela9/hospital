package com.hospital.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hospital.model.ContributingFactorDetails;

@CrossOrigin(origins = "*", methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.PATCH,RequestMethod.DELETE})
@RepositoryRestResource(collectionResourceRel = "contributingFactorDetails", path = "contributingFactorDetails")
public interface ContributingFactorDetailsRepository extends CrudRepository<ContributingFactorDetails, Long> {
}
