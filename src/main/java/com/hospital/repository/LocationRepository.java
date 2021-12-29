package com.hospital.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hospital.model.Location;

@RepositoryRestResource(collectionResourceRel = "location", path = "location")
@CrossOrigin("*")
public interface LocationRepository extends CrudRepository<Location, Long> {
    public Location findById(long id);
    public List<Location> findAll();
}
