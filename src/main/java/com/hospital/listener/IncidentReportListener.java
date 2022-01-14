package com.hospital.listener;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.sound.midi.Sequence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
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
    public void handleIncidentReportBeforeCreate(IncidentReport incidentReport){
        logger.info("Inside incidentReport Before Create....");
        //001IR/01/2022NAP
        //006IR/01/2022NAP
        List<IRCodeConfiguration> irc = irRepository.findAll();
        IRCodeConfiguration ircDcument = irc.get(0);
        int nextId = ircDcument.getIrCode();
        nextId = nextId +1;
        logger.info("Inside incidentReport Before Create....nextId :"+nextId);
        YearMonth thisMonth = YearMonth.now();
        DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MM/yyyy");
        String date = thisMonth.format(monthYearFormatter);
        logger.info("Inside incidentReport Before Create....date :"+date);
        incidentReport.setSequence((ircDcument.getStaticCode()+nextId+ircDcument.getPrefix()+date+ircDcument.getSuffix()).trim().toString());
        ircDcument.setIrCode(nextId);
        ircDcument.setPeriod(date);
        ircDcument.setSequence(incidentReport.getSequence());
        irRepository.save(ircDcument);
    }

    @HandleAfterCreate
    public void handleIncidentReportAfterCreate(IncidentReport incidentReport){
        logger.info("Inside Author After Create ....");
    }
}
