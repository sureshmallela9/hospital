package com.hospital.listener;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import com.hospital.model.IRCodeConfiguration;
import com.hospital.model.IncidentReport;
import com.hospital.repository.IncidentReportRepository;
import com.hospital.repository.IrCodeRepository;

@RepositoryEventHandler
public class IncidentReportListener {

    private static final Logger logger = LogManager.getLogger(IncidentReportListener.class);

    @Autowired
    IncidentReportRepository incidentReportRepository;

    @Autowired
    IrCodeRepository irRepository;

    @HandleBeforeCreate
    public void handleIncidentReportBeforeCreate(IncidentReport incidentReport) {
        if (incidentReport != null && incidentReport.getStatus() != null && incidentReport.getStatus().equalsIgnoreCase("2")) {
            sequenceGen(incidentReport);
        }
    }
    
    @HandleBeforeSave
    public void handleIncidentReportBeforeSave(IncidentReport incidentReport) {
        if (incidentReport != null && incidentReport.getStatus() != null && incidentReport.getSequence() == null &&  incidentReport.getStatus().equalsIgnoreCase("2")) {
            sequenceGen(incidentReport);
        }
    }
    private void sequenceGen(IncidentReport incidentReport) {
        logger.info("Inside incidentReport Before Create....");
        Map<String, String> seqMap = new HashMap<>();
        seqMap.put("3", "irCode");
        seqMap.put("2", "preriod");
        seqMap.put("1", "prefix");
        seqMap.put("4", "suffix");
        List<IRCodeConfiguration> irc = irRepository.findAll();
        IRCodeConfiguration ircDcument = irc.get(0);
        int nextId = ircDcument.getIrCode();
        nextId = nextId + 1;
        String irCode = String.format("%03d", nextId);
        String prefix = ircDcument.getPrefix();
        String suffix = ircDcument.getSuffix();
        String preriod = "";
        logger.info("ircDcument.getPeriod()...." + ircDcument.getPeriod());
        if (ircDcument.getPeriod() != null && ircDcument.getPeriod().equalsIgnoreCase("MM")) {
            preriod = getMonth(ircDcument.getPeriod());
        } else if (ircDcument.getPeriod() != null && ircDcument.getPeriod().equalsIgnoreCase("MM/YYYY")) {
            preriod = getMonthAndYear(ircDcument.getPeriod());
        } else if (ircDcument.getPeriod() != null && ircDcument.getPeriod().equalsIgnoreCase("YYYY")) {
            preriod = getYear(ircDcument.getPeriod());
        }
        logger.info("preriod...." + preriod);
        String sequence = "";
        String[] res = ircDcument.getSequence().split(",");
        for (String myStr : res) {
            logger.info("sequence split one by one :" + myStr);
            if (seqMap.get(myStr).equalsIgnoreCase("irCode")) {
                if (sequence != null || !sequence.isEmpty()) {
                    sequence = sequence + " " + irCode;
                } else {
                    sequence = irCode;
                }
            }
            if (seqMap.get(myStr).equalsIgnoreCase("preriod")) {
                if (preriod != null) {
                    sequence = sequence + " " + "/" + preriod;
                }
            }
            if (seqMap.get(myStr).equalsIgnoreCase("prefix")) {
                sequence = sequence + " " + prefix;
            }
            if (seqMap.get(myStr).equalsIgnoreCase("suffix")) {
                sequence = sequence + " " + suffix;
            }
        }
        incidentReport.setSequence(sequence.trim());
        ircDcument.setIrCode(nextId);
        irRepository.save(ircDcument);
    }
    private String getMonth(String date) {
        logger.info("Start getMonthAndYear :"+date);
        YearMonth thisMonth = YearMonth.now();
        DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MM");
        date = thisMonth.format(monthYearFormatter);
        logger.info("end getMonthAndYear :"+date);
        return date;
    }

    private String getMonthAndYear(String date) {
        logger.info("Inside getMonthAndYear :"+date);
        YearMonth thisMonth = YearMonth.now();
        DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MM/yyyy");
        date = thisMonth.format(monthYearFormatter);
        logger.info("Inside incidentReport Before Create....date :"+date);
        return date;
    }

    private String getYear(String date) {
        logger.info("Inside getMonthAndYear :"+date);
        YearMonth thisMonth = YearMonth.now();
        DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("yyyy");
        date = thisMonth.format(monthYearFormatter);
        logger.info("Inside incidentReport Before Create....date :"+date);
        return date;
    }

    @HandleAfterCreate
    public void handleIncidentReportAfterCreate(IncidentReport incidentReport){
        logger.info("Inside Author After Create ....");
    }
}
