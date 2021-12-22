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

import lombok.Data;
@Entity
@Table(name = "ContributingFactors")
@RestResource
@Data
public class ContributingFactors {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cf_id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "contributingFactors", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContributingFactorDetails> contributingFactorDetails;

}
