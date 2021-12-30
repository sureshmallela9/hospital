package com.hospital.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PersonAffected")
@RestResource
@Getter
@Setter
public class PersonAffected {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pa_id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "personAffected")
    @RestResource(exported = false)
    private List<PersonAffectedDetails> personAffectedDetails;

    @JsonManagedReference
    public List<PersonAffectedDetails> getPersonAffectedDetails() {
        return personAffectedDetails;
    }
}
