package com.hospital.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.rest.core.annotation.RestResource;
import lombok.Data;

@Entity
@Table(name = "RiskAssement")
@RestResource
@Data
public class RiskAssement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int likelihood;
    private int serverity;
    private int riskscore;
    private int riskstatus;
    private String color;
    private String template;
    private boolean status;

}
