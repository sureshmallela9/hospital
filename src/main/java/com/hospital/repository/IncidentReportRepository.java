package com.hospital.repository;



import java.time.LocalDate;
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
    public long countByStatus(String status);

    @RestResource(path = "byDetails", rel = "customFindMethod")
    @Query("select e from IncidentReport e where " + 
            "(:department is null or e.department = :department) and "+
            "(:#{#sequence == null} = true or e.sequence in (:sequence)) and "+
            "(:#{#status == null} = true or e.status in (:status)) and "+
            "(:userId is null or e.userId = :userId) and"+
            "(:#{#InciCateg == null} = true or e.InciCateg in (:InciCateg)) and"+
            "(:#{#typeofInci == null} = true or e.TypeofInci in (:typeofInci)) and "+
            "(:#{#irInvestigator == null} = true or e.irInvestigator in (:irInvestigator)) and"+
            "(:fromIncidentDateTime is null or e.Incident_Date_Time >= :fromIncidentDateTime) and"+
            "(:toIncidentDateTime is null or e.Incident_Date_Time <= :toIncidentDateTime) and"+
            "(:fromreportingDate is null or e.reportingDate >= :fromreportingDate)and "+ 
            "(:toreportingDate is null or e.reportingDate <= :toreportingDate)")
    List<IncidentReport> findByPatientnameAndInciDescription(
            @Param("department") String department,
            @Param("sequence") List<String> sequence,
            @Param("status") List<String> status,
            @Param("userId") Integer userId,
            @Param("InciCateg") List<Integer> InciCateg,
            @Param("typeofInci") List<Integer> typeofInci,
            @Param("irInvestigator") List<Integer> irInvestigator,
            @Param("fromIncidentDateTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromIncidentDateTime,
            @Param("toIncidentDateTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date toIncidentDateTime,
            @Param("fromreportingDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromreportingDate,
            @Param("toreportingDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date toreportingDate);
    

    @RestResource(path = "countByTypeofInci", rel = "customFindMethod")
    @Query("select count(e) from IncidentReport e where (:typeofInci is null or e.TypeofInci = :typeofInci)")
    public long countByInciCateg(Integer typeofInci);

    @RestResource(path = "countByReportingDate", rel = "customFindMethod")
    @Query("select count(e) from IncidentReport e where e.reportingDate between :startDate and :endDate")
    public long countByReportingDate();

    @RestResource(path = "countByIncidentDate", rel = "customFindMethod")
    @Query("select count(e) from IncidentReport e where e.Incident_Date_Time between :startDate and :endDate")
    public long countByIncidentDateTime();

    public static LocalDate startDate = getStartDate();
    public static LocalDate endDate = getEndDate();

    static LocalDate getStartDate() {
        LocalDate today = LocalDate.now();
        System.out.println("First day: " + today.withDayOfMonth(1));
        System.out.println("Last day: " + today.withDayOfMonth(today.lengthOfMonth()));
        LocalDate startDate = today.withDayOfMonth(1);
        return startDate;

    }
    static LocalDate getEndDate() {
        LocalDate today = LocalDate.now();
        System.out.println("First day: " + today.withDayOfMonth(1));
        System.out.println("Last day: " + today.withDayOfMonth(today.lengthOfMonth()));
        LocalDate endDate = today.withDayOfMonth(today.lengthOfMonth());
        return endDate;
        
    }
}
