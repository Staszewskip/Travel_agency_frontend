package com.travel_agency_frontend;

import com.travel_agency_frontend.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TravelAgencyFrontendApplication {
    public static void main(String[] args) {
        SpringApplication.run(TravelAgencyFrontendApplication.class, args);
    }

}
