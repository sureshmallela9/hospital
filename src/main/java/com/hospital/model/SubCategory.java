package com.hospital.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "SubCategory")
@Getter
@Setter
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id",scope = SubCategory.class)
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int template;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true)
    @RestResource(exported = false)
    @JsonIgnore
    private Category category;
    
}
