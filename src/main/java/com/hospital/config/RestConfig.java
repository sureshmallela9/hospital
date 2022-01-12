package com.hospital.config;

import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.hospital.listener.IncidentReportListener;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {

    @Autowired
    private EntityManager entityManager;

    public RestConfig(){
        super();
    }

    @Bean
    IncidentReportListener incidentReportListener() {
        return new IncidentReportListener();
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        System.out.println("List of Entitys" +entityManager.getMetamodel().getEntities().stream().map(e -> e.getJavaType()).collect(Collectors.toList()));
        config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream().map(e -> e.getJavaType()).collect(Collectors.toList()).toArray(new Class[0]));
        cors.addMapping("/**").allowCredentials(false).allowedOrigins("*").allowedMethods("PUT", "POST", "GET", "OPTIONS", "DELETE").allowedHeaders("*");
    }

}