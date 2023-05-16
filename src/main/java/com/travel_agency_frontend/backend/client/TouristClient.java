package com.travel_agency_frontend.backend.client;

import com.travel_agency_frontend.backend.config.BackendConfig;
import com.travel_agency_frontend.backend.domain.dto.TouristDTO;
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

    public List<TouristDTOGet> showAllTourists() {
        URI uri = UriComponentsBuilder.fromHttpUrl(backEndConfig.getEndpoint() + backEndConfig.getTourist() + "/admin")
                .build()
                .encode()
                .toUri();
        try {
            TouristDTOGet[] response = restTemplate.getForObject(uri, TouristDTOGet[].class);
            return new ArrayList<>(Optional.ofNullable(response)
                    .map(Arrays::asList)
                    .orElse(Collections.emptyList()));
        } catch (RestClientException e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }
}
