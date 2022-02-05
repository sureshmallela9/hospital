package com.hospital.service;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.util.HashMap;
import java.util.Map;

public class MasterService {
    public static Map<Object, Object> getDataSourceHashMap() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://139.59.44.254;databaseName=incident_report");
        dataSource.setUsername("SA");
        dataSource.setPassword("Mssql@123Password");

        DriverManagerDataSource dataSource1 = new DriverManagerDataSource();
        dataSource1.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource1.setUrl("jdbc:sqlserver://139.59.44.254;databaseName=star");
        dataSource1.setUsername("SA");
        dataSource1.setPassword("Mssql@123Password");
        
        DriverManagerDataSource defaultSchema = new DriverManagerDataSource();
        defaultSchema.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        defaultSchema.setUrl("jdbc:sqlserver://139.59.44.254;databaseName=defaultSchema");
        defaultSchema.setUsername("SA");
        defaultSchema.setPassword("Mssql@123Password");
        
        HashMap hashMap = new HashMap();
        hashMap.put("napier", dataSource);
        hashMap.put("star", dataSource1);
        hashMap.put("default", defaultSchema);
        return hashMap;
    }
}