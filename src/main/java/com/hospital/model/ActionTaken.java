package com.hospital.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "ActionTaken")
@Getter
@Setter
public class ActionTaken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String immedActionTaken;
    
    private int accessTakenBy;

    private Date accessDateTime;

}
