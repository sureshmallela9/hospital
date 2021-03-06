package com.hospital.model;

import javax.persistence.Column;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "TwoFieldMasterDetails")
@RestResource
@Getter
@Setter
public class TwoFieldMasterDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = true)
    private boolean showToggle;

    @ManyToOne
    @JoinColumn(name = "twoFieldMaster_id", nullable = true)
    @RestResource(exported = false)
    private TwoFieldMaster twoFieldMaster;

    @JsonBackReference
    public TwoFieldMaster getTwoFieldMaster() {
        return twoFieldMaster;
    }
    
}
