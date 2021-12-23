package com.hospital.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.hospital.model.RcaCauses;

@RepositoryRestResource(collectionResourceRel = "rcaCauses", path = "rcaCauses")
public interface RcaCausesRepository extends CrudRepository<RcaCauses, Long> {
    public RcaCauses findById(long id);
    public List<RcaCauses> findAll();
}
