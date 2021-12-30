package com.hospital.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.rest.core.annotation.RestResource;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Category")
@Getter
@Setter
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","subCategory"})
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id",scope = Category.class)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @RestResource(exported = false)
    private Set<SubCategory> subCategory;

}
