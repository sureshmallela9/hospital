package com.hospital.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hospital.model.Notification;

@RepositoryRestResource(collectionResourceRel = "notification", path = "notification")
public interface NotificationRepository extends CrudRepository<Notification, Long> {
    public Notification findById(int id);
    public Set<Notification> findAll();
}
