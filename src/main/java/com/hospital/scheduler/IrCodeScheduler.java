package com.hospital.scheduler;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hospital.model.IRCodeConfiguration;
import com.hospital.repository.IrCodeRepository;

@Component
public class IrCodeScheduler {

    private static final Logger logger = LogManager.getLogger(IrCodeScheduler.class);
    @Value("${irCodeValue}")
    private String irCodeValue;

    @Autowired
    IrCodeRepository irRepository;

//@monthly, Run once a month at midnight of the first day of the month
    @Scheduled(cron = "@monthly")
    public void IrCodeReset() {
        System.out.println("Printing hello after cron delay: " + System.currentTimeMillis() / 1000);
        List<IRCodeConfiguration> irCodeList =  irRepository.findAll();
        IRCodeConfiguration irCode = irCodeList.get(0);
        int currentDay = getDay("dd");
        String currentMonth = getMonth("MM");
        if (irCode.getReceed() != null && irCode.getReceed().equalsIgnoreCase("M")) {
            if (currentDay == 1) {
                irCode.setIrCode(0);
                irRepository.save(irCode);
            }
        } else if (irCode.getReceed() != null && irCode.getReceed().equalsIgnoreCase(currentMonth)) {
            if (currentDay == 1 ) {
                irCode.setIrCode(0);
                irRepository.save(irCode);
            }
        }
    }
    
    private int getDay(String date) {
        Calendar calendar = Calendar.getInstance();
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        logger.info(" get Day :"+calendar.get(Calendar.DAY_OF_MONTH));
        return currentDay;
    }
    
    private String getMonth(String date) {
        logger.info("Start getMonth :"+date);
        YearMonth thisMonth = YearMonth.now();
        DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern(date);
        date = thisMonth.format(monthYearFormatter);
        logger.info("end getMonth :"+date);
        return date;
    }
}
