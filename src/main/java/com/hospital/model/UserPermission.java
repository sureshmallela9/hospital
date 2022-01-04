package com.hospital.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "UserPermission")
@Getter
@Setter
public class UserPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String permission;

    @ManyToOne
    @RestResource(exported = false)
    @JoinColumn(name = "user_id")
    private User user;

}
