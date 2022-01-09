package com.hospital.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Reportable")
@Getter
@Setter
public class Reportable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int Report_to;

    private String reporting_instructions;

    @ManyToOne
    @RestResource(exported = false)
    @JoinColumn(name = "subCategory_id")
    private SubCategory subCategory;

    @JsonBackReference
    public SubCategory getSubCategory() {
        return subCategory;
    }
}
