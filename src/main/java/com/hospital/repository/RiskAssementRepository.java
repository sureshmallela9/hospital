package com.hospital.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hospital.model.RiskAssement;

@RepositoryRestResource(collectionResourceRel = "riskAssement", path = "riskAssement")
@CrossOrigin("*")
public interface RiskAssementRepository extends CrudRepository<RiskAssement, Long> {
    public RiskAssement findById(long id);
    public List<RiskAssement> findAll();
}
