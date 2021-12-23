package com.hospital.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.rest.core.annotation.RestResource;
import lombok.Data;

@Entity
@Table(name = "Location")
@RestResource
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int code;
    private String name;
    private int locationType;
    private boolean status;

}
