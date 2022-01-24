package com.hospital.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    
    @OneToMany(mappedBy = "incidentReport", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @RestResource(exported = false)
    private Set<ActionTaken> actionTaken;

    @JsonManagedReference(value="action-taken")
    public Set<ActionTaken> getActionTakens() {
        return actionTaken;
    }

    @OneToMany(mappedBy = "incidentReport", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @RestResource(exported = false)
    private Set<Witness> witness;

    @JsonManagedReference(value="witness")
    public Set<Witness> getWitness() {
        return witness;
    }

    @OneToMany(mappedBy = "incidentReport", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @RestResource(exported = false)
    private Set<Notification> notification;

    @JsonManagedReference(value="notification")
    public Set<Notification> getNotification() {
        return notification;
    }

    @OneToMany(mappedBy = "incidentReport", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @RestResource(exported = false)
    private Set<Upload> upload;

    @JsonManagedReference(value="upload")
    public Set<Upload> getUpload() {
        return upload;
    }
    
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
