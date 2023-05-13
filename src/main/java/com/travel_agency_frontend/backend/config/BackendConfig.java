package com.travel_agency_frontend.backend.config;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class BackendConfig {
    @Value("${backend.server.endpoint}")
    private String endpoint;
    @Value("${backend.destination}")
    private String destinaton;
    @Value("${backend.hotel}")
    private String hotel;
    @Value("${backend.tourist}")
    private String tourist;
    @Value("${backend.reservation}")
    private String reservation;
}
