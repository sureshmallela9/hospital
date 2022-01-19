package com.hospital.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.hospital.model.ContributingFactorDetails;

//import io.swagger.annotations.Api;

//@Api(tags = "contributingFactorDetails")
@RepositoryRestResource(collectionResourceRel = "contributingFactorDetails", path = "contributingFactorDetails")
public interface ContributingFactorDetailsRepository extends CrudRepository<ContributingFactorDetails, Long> {
}
