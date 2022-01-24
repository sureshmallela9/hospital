package com.hospital.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
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
@Table(name = "Witness")
@Getter
@Setter
public class Witness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private int witnessName;

    private int witnessDept;
    
    private Date witnessDateTime;
    
    @ManyToOne
    @RestResource(exported = false)
    @JoinColumn(name = "incidentReport_id")
    private IncidentReport incidentReport;

    @JsonBackReference(value="witness")
    public IncidentReport getIncidentReport() {
        return incidentReport;
    }
}
