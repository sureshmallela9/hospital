package com.hospital.listener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hospital.model.FileResponse;
import com.hospital.model.IRCodeConfiguration;
import com.hospital.model.IncidentReport;
import com.hospital.model.Upload;
import com.hospital.repository.IncidentReportRepository;
import com.hospital.repository.IrCodeRepository;
import com.hospital.service.StorageService;

@RepositoryEventHandler
public class IncidentReportListener {

    private static final Logger logger = LogManager.getLogger(IncidentReportListener.class);

    @Autowired
    IncidentReportRepository incidentReportRepository;

    @Autowired
    IrCodeRepository irRepository;
    
    @Autowired
    private StorageService storageService;

    @HandleBeforeCreate
    public void handleIncidentReportBeforeCreate(IncidentReport incidentReport) {
        if (incidentReport != null && incidentReport.getStatus() != null && incidentReport.getStatus().equalsIgnoreCase("2")) {
            sequenceGen(incidentReport);
        }
        logger.info("incidentReport.getUpload() :: "+incidentReport.getUpload().size());
        for (Upload u : incidentReport.getUpload()) {
            logger.info("u.getUploadFilePath() :: "+u.getUploadFilePath());
            if (u.uploadFilePath != null) {
            MultipartFile file = getMulFileByPath(u.uploadFilePath);
            String name = storageService.store(file);
            System.out.println("upload-file2 : "+file.getName());
            String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/download/")
                    .path(name)
                    .toUriString();
            FileResponse fileResp = new FileResponse(name, uri, file.getContentType(), file.getSize());
            u.setUploadFilePath(fileResp.getUri());
           }
        }
    }
    
    @HandleBeforeSave
    public void handleIncidentReportBeforeSave(IncidentReport incidentReport) {
        if (incidentReport != null && incidentReport.getStatus() != null && incidentReport.getSequence() == null &&  incidentReport.getStatus().equalsIgnoreCase("2")) {
            sequenceGen(incidentReport);
        }
        for (Upload u : incidentReport.getUpload()) {
            if (u.uploadFilePath != null) {
            MultipartFile file = getMulFileByPath(u.uploadFilePath);
            String name = storageService.store(file);
            System.out.println("upload-file2 : "+file.getName());
            String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/download/")
                    .path(name)
                    .toUriString();
            FileResponse fileResp = new FileResponse(name, uri, file.getContentType(), file.getSize());
            u.setUploadFilePath(fileResp.getUri());
            }
        }
    }

    private static MultipartFile getMulFileByPath(String picPath) {
        FileItem fileItem = createFileItem(picPath);
        MultipartFile mfile = new CommonsMultipartFile(fileItem);
        return mfile;
    }
    private static FileItem createFileItem(String filePath)
    {
        FileItemFactory factory = new DiskFileItemFactory(16, null);
        String textFieldName = "textField";
        logger.info("filePath :: "+filePath);
        Path path = Paths.get(filePath);
        Path fileName = path.getFileName();
        FileItem item = factory.createItem(textFieldName, "text/plain", true,
                fileName.toString());
        File newfile = new File(filePath);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        try
        {
            FileInputStream fis = new FileInputStream(newfile);
            OutputStream os = item.getOutputStream();
            while ((bytesRead = fis.read(buffer, 0, 8192))
                != -1)
            {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            fis.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return item;
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
