package com.hospital.listener;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import com.hospital.model.IncidentReport;
import com.hospital.repository.IncidentReportRepository;

@RepositoryEventHandler
public class IncidentReportListener {

    private static final Logger logger = LogManager.getLogger(IncidentReportListener.class);
    private static final String staticCode = "00";
    private static final String prefix="IR/";
    private static final String suffix="NAP";

    @Autowired
    IncidentReportRepository incidentReportRepository;

    @HandleBeforeCreate
    public void handleIncidentReportBeforeCreate(IncidentReport incidentReport){
        logger.info("Inside incidentReport Before Create....");
        //001IR/01/2022NAP
        Long nextId = incidentReportRepository.getMaxId();
        if (nextId == null) {
            nextId = 1L;
        } else {
            nextId = nextId +1;
        }
        logger.info("Inside incidentReport Before Create....nextId :"+nextId);
        YearMonth thisMonth = YearMonth.now();
        DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MM/yyyy");
        String date = thisMonth.format(monthYearFormatter);
        logger.info("Inside incidentReport Before Create....date :"+date);
        incidentReport.setSequence((staticCode+nextId+prefix+date+suffix).trim().toString());
    }

    @HandleAfterCreate
    public void handleIncidentReportAfterCreate(IncidentReport incidentReport){
        logger.info("Inside Author After Create ....");
    }
}
