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
import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PersonAffectedDetails")
@RestResource
@Getter
@Setter
public class PersonAffectedDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private boolean show;

    @ManyToOne
    @JoinColumn(name = "pa_id", nullable = true)
    @RestResource(exported = false)
    private PersonAffected personAffected;

    @JsonBackReference
    public PersonAffected getPersonAffected() {
        return personAffected;
    }
}
