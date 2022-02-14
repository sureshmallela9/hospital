package com.hospital.repository;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.hospital.model.UserPermission;

@Transactional
@RepositoryRestResource(collectionResourceRel = "userPermission", path = "userPermission")
public interface UserPermissionRepository extends CrudRepository<UserPermission, Long> {
    public UserPermission findById(int id);
    public Set<UserPermission> findAll();
    public UserPermission findByRole(String role);
    
    @DeleteMapping
    public Long deleteByRole(String role);
    
    @RestResource(path = "updateByRole", rel = "customFindMethod")
    @Query("update UserPermission u set u.permission = :permission where u.role = :role")
    @Modifying
    int updateByRole(@Param(value = "role") String role,
                      @Param(value = "permission") String permission
                      );
}
