package com.hospital.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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

    private Boolean PatientYesOrNo;

    private int Patientname;

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

    private Boolean action;

    private Boolean witness;

    private Boolean IncidentNotification;

    private Boolean Upload;

    private int IncidentReportedDept;

    private int HeadofDepart;

    private String Sequence;

}
