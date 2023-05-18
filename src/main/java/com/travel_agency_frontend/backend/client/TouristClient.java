package com.travel_agency_frontend.backend.client;

import com.travel_agency_frontend.backend.config.BackendConfig;
import com.travel_agency_frontend.backend.domain.dto.TouristDTO;
import com.travel_agency_frontend.backend.domain.dto.TouristLoggedDTO;
import com.travel_agency_frontend.backend.domain.dto.TouristLoggingDTO;
import com.travel_agency_frontend.backend.domain.dto.get.TouristDTOGet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

@Component
@Slf4j
@RequiredArgsConstructor
public class TouristClient {
    private final RestTemplate restTemplate;
    private final BackendConfig backEndConfig;

    public TouristDTO addTourist(TouristDTO touristDTO) {
        URI uri = UriComponentsBuilder.fromHttpUrl(backEndConfig.getEndpoint() + backEndConfig.getTourist())
                .build()
                .encode()
                .toUri();
        return restTemplate.postForObject(uri, touristDTO, TouristDTO.class);
    }

    public TouristLoggedDTO login(TouristLoggingDTO touristLoggingDTO) {
        URI uri = UriComponentsBuilder.fromHttpUrl(backEndConfig.getEndpoint() + backEndConfig.getTourist() + "/login")
                .build()
                .encode()
                .toUri();
        return restTemplate.getForObject(uri, TouristLoggedDTO.class);
    }

    public TouristDTOGet findByLogin(String login) {
        URI uri = UriComponentsBuilder.fromHttpUrl(backEndConfig.getEndpoint() + backEndConfig.getTourist())
                .queryParam("login", login)
                .build()
                .encode()
                .toUri();
        return restTemplate.getForObject(uri, TouristDTOGet.class);
    }
    public boolean existsByLogin(String login) {
        URI uri = UriComponentsBuilder.fromHttpUrl(backEndConfig.getEndpoint() + backEndConfig.getTourist() + "/logincheck")
                .queryParam("login", login)
                .build()
                .encode()
                .toUri();
        return restTemplate.getForObject(uri, boolean.class);
    }
}
