package com.hospital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.rest.core.annotation.RestResource;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "RiskAssement")
@RestResource
@Getter
@Setter
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
    private boolean show;

}
