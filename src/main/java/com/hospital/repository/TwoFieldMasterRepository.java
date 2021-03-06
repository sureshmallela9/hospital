package com.hospital.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.hospital.model.TwoFieldMaster;

@RepositoryRestResource(collectionResourceRel = "twoFieldMaster", path = "twoFieldMaster")
public interface TwoFieldMasterRepository extends CrudRepository<TwoFieldMaster, Long> {
    public TwoFieldMaster findById(long id);
    public List<TwoFieldMaster> findAll();
}
