package com.hospital.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.hospital.model.TwoFieldMasterDetails;

@RepositoryRestResource(collectionResourceRel = "twoFieldMasterDetails", path = "twoFieldMasterDetails")
public interface TwoFieldMasterDetailsRepository extends CrudRepository<TwoFieldMasterDetails, Long> {
    public TwoFieldMasterDetails findById(long id);
    public List<TwoFieldMasterDetails> findAll();
}
