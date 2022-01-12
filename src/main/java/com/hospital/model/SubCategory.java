package com.hospital.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "SubCategory")
@Getter
@Setter
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int template;

    private boolean sentinel;

    private boolean reportStatus;

    private boolean status;

    @ManyToOne
    @RestResource(exported = false)
    @JoinColumn(name = "category_id")
    private Category category;

    @JsonBackReference
    public Category getCategory() {
        return category;
    }

    @OneToMany(mappedBy = "subCategory")
    @RestResource(exported = false)
    private Set<Reportable> reportable;

    @JsonManagedReference
    public Set<Reportable> getReportable() {
        return reportable;
    }
}
