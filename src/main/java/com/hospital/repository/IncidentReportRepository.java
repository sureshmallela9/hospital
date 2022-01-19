package com.hospital.repository;



import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;
import com.hospital.model.IncidentReport;

@RepositoryRestResource(collectionResourceRel = "IncidentReport", path = "IncidentReport")
public interface IncidentReportRepository extends CrudRepository<IncidentReport, Long> {
    public IncidentReport findById(int id);
    public Set<IncidentReport> findAll();

    @RestResource(path = "byDetails", rel = "customFindMethod")
    @Query("select e from IncidentReport e where " + 
            "(:department is null or e.department = :department) and "+
            "(:sequence is null or e.sequence = :sequence) and "+
            "(:status is null or e.status = :status) and"+
            "(:userId is null or e.userId = :userId) and"+
            "(:InciCateg is null or e.InciCateg = :InciCateg) and"+
            "(:TypeofInci is null or e.TypeofInci = :TypeofInci) and"+
            "(:irInvestigator is null or e.irInvestigator = :irInvestigator) and"+
            "(:fromIncidentDateTime is null or e.Incident_Date_Time >= :fromIncidentDateTime) and"+
            "(:toIncidentDateTime is null or e.Incident_Date_Time <= :toIncidentDateTime) and"+
            "(:fromreportingDate is null or e.reportingDate >= :fromreportingDate)and "+ 
            "(:toreportingDate is null or e.reportingDate <= :toreportingDate)")
    List<IncidentReport> findByPatientnameAndInciDescription(
            @Param("department") String department,
            @Param("sequence") String sequence,
            @Param("status") String status,
            @Param("userId") Integer userId,
            @Param("InciCateg") Integer InciCateg,
            @Param("TypeofInci") Integer TypeofInci,
            @Param("irInvestigator") Integer irInvestigator,
            @Param("fromIncidentDateTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromIncidentDateTime,
            @Param("toIncidentDateTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date toIncidentDateTime,
            @Param("fromreportingDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromreportingDate,
            @Param("toreportingDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date toreportingDate);

}
