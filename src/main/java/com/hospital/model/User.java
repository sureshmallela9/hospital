package com.hospital.model;

import java.util.Date;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gender;
    private Date dob;
    private String employeeId;
    private String contact;
    private String email;
    private int department;
    private int role;
    private String password;
}
