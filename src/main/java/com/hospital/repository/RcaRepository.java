package com.hospital.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hospital.model.Rca;

@RepositoryRestResource(collectionResourceRel = "rca", path = "rca")
public interface RcaRepository extends CrudRepository<Rca, Long> {
    public Rca findById(long id);
    public List<Rca> findAll();
}
