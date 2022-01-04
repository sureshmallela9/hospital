package com.hospital.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.hospital.model.UserPermission;

@RepositoryRestResource(collectionResourceRel = "userPermission", path = "userPermission")
public interface UserPermissionRepository extends CrudRepository<UserPermission, Long> {
    public UserPermission findById(int id);
    public Set<UserPermission> findAll();
}
