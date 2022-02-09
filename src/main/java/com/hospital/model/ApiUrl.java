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
public class ApiUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String action;
    private String url;
    private String key1;
    private String key2;
    private String key3;
}
