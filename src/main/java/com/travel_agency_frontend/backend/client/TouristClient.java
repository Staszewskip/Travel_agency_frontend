package com.travel_agency_frontend.backend.client;

import com.travel_agency_frontend.backend.config.BackendConfig;
import com.travel_agency_frontend.backend.domain.dto.TouristDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class TouristClient {
    private final RestTemplate restTemplate;
    private final BackendConfig backEndConfig;

    public String addTourist(TouristDTO touristDTO) {
        URI uri = UriComponentsBuilder.fromHttpUrl(backEndConfig.getEndpoint() + backEndConfig.getTourist())
                .build()
                .encode()
                .toUri();
        return restTemplate.postForObject(uri, touristDTO, String.class);
    }

    public void deleteTourist(Long touristId) {
        URI uri = UriComponentsBuilder.fromHttpUrl(backEndConfig.getEndpoint() + backEndConfig.getTourist() + "/" + touristId)
                .build()
                .encode()
                .toUri();
        restTemplate.delete(uri);
    }

}
