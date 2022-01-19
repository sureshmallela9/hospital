package com.hospital.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.rest.core.annotation.RestResource;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "IncidentReport")
@RestResource
@Getter
@Setter
public class IncidentReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date Incident_Date_Time;

    @Column(nullable = true)
    private Integer Location;

    private String LocationDetailsEntry;

    @Column(nullable = true)
    private Boolean PatientYesOrNo;

    private String Patientname;

    private Date ComplaIntegerDatetime;

    private String ComplaIntegerIdEntry;

    private Integer TypeofInci;

    private Integer InciCateg;

    private Integer InciSubCat;

    private Integer Template;

    private Boolean PersonAffected;

    private String InciDescription;

    private String DeptsLookupMultiselect;

    private Boolean ContribFactorYesOrNo;

    private Integer ContribFactor;

    private Integer Preventability;

    @Column(nullable = true)
    private Boolean action;

    @Column(nullable = true)
    private Boolean witness;

    @Column(nullable = true)
    private Boolean IncidentNotification;

    @Column(nullable = true)
    private Boolean Upload;
    
    @Column(nullable = true)
    private Integer IncidentReportedDept;
    
    @Column(nullable = true)
    private Integer HeadofDepart;
    
    @Column(nullable = true)
    private String sequence;
    
    @Column(nullable = true)
    private String status;
    
    @Column(nullable = true)
    private String department;
    
    @Column(nullable = true)
    private String userDept;
    
    @Column(nullable = true)
    private Integer userId;
    
    @Column(nullable = true)
    private Integer irInvestigator;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date reportingDate = new java.sql.Date(new java.util.Date().getTime());
}
