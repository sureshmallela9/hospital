package com.hospital;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
//@OpenAPIDefinition
public class HospitalApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }
    
    @PostConstruct
    public void init(){
      TimeZone.setDefault(TimeZone.getTimeZone("IST"));
    }
}
