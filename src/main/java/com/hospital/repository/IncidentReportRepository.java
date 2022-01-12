package com.hospital.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.hospital.model.IncidentReport;

@RepositoryRestResource(collectionResourceRel = "IncidentReport", path = "IncidentReport")
public interface IncidentReportRepository extends CrudRepository<IncidentReport, Long> {
    public IncidentReport findById(int id);
    public Set<IncidentReport> findAll();

    @RestResource(path = "byDetails", rel = "customFindMethod")
    @Query("select e from IncidentReport e where " + "(:Patientname is null or e.Patientname = :Patientname) and "+"(:InciDescription is null or e.InciDescription = :InciDescription) and "+
            "(:status is null or e.status = :status)")
    List<IncidentReport> findByPatientnameAndInciDescription(
            @Param("Patientname") String Patientname,
            @Param("InciDescription") String InciDescription,
            @Param("status") String status);
    
    @Query("SELECT max(ch.id) FROM IncidentReport ch")
    Long getMaxId();
}
