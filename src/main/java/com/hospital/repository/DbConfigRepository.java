package com.hospital.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.hospital.model.DbConfig;

@RepositoryRestResource(collectionResourceRel = "dbConfig", path = "dbConfig")
public interface DbConfigRepository extends CrudRepository<DbConfig, Long> {
    public DbConfig findById(long id);
    public List<DbConfig> findAll();
}
