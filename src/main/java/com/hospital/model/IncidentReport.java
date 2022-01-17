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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.CreatedDate;
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

    private Date Incident_Date_Time;

    private int Location;

    private String LocationDetailsEntry;

    @Column(nullable = true)
    private Boolean PatientYesOrNo;

    private String Patientname;

    private Date ComplaintDatetime;

    private String ComplaintIdEntry;

    private int TypeofInci;

    private int InciCateg;

    private int InciSubCat;

    private int Template;

    private Boolean PersonAffected;

    private String InciDescription;

    private String DeptsLookupMultiselect;

    private Boolean ContribFactorYesOrNo;

    private int ContribFactor;

    private int Preventability;

    @Column(nullable = true)
    private Boolean action;

    @Column(nullable = true)
    private Boolean witness;

    @Column(nullable = true)
    private Boolean IncidentNotification;

    @Column(nullable = true)
    private Boolean Upload;

    private int IncidentReportedDept;

    private int HeadofDepart;

    private String Sequence;
    
    private String status;
    
    private String department;
    
    private String userDept;

    @CreationTimestamp
    private Date reportingDate = new java.sql.Date(new java.util.Date().getTime());
}
