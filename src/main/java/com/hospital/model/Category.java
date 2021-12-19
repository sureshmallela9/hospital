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

import lombok.Data;
@Entity
@Table(name = "tbl_category")
@RestResource
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;
    private String categoryName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,targetEntity = SubCategory.class, orphanRemoval = true)
    @RestResource(exported = false)
    private List<SubCategory> subCategory;

}
