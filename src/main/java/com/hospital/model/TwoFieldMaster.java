package com.hospital.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TwoFieldMaster")
@RestResource
@Getter
@Setter
public class TwoFieldMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "twoFieldMaster")
    @RestResource(exported = false)
    private List<TwoFieldMasterDetails> twoFieldMasterDetails;

    @JsonManagedReference
    public List<TwoFieldMasterDetails> getTwoFieldMasterDetails() {
        return twoFieldMasterDetails;
    }

}
