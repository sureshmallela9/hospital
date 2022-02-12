package com.hospital.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.rest.core.annotation.RestResource;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "api_urls")
@RestResource
@Getter
@Setter
public class DbConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String driverName;
    private String url;
    private String schemaName;
    private String tenantId;
}
