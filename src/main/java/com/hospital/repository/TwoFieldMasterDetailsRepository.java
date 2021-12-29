package com.hospital.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hospital.model.TwoFieldMasterDetails;

@RepositoryRestResource(collectionResourceRel = "twoFieldMasterDetails", path = "twoFieldMasterDetails")
@CrossOrigin("*")
public interface TwoFieldMasterDetailsRepository extends CrudRepository<TwoFieldMasterDetails, Long> {
    public TwoFieldMasterDetails findById(long id);
    public List<TwoFieldMasterDetails> findAll();
}
