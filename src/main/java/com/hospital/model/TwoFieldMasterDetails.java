package com.hospital.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.rest.core.annotation.RestResource;

import lombok.Data;


@Entity
@Table(name = "TwoFieldMasterDetails")
@RestResource
@Data
public class TwoFieldMasterDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "twoFieldMaster_id", nullable = false)
    private TwoFieldMaster twoFieldMaster;
}
