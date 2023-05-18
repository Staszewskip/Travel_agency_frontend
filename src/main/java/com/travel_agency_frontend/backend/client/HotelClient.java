package com.travel_agency_frontend.backend.client;

import com.travel_agency_frontend.backend.config.BackendConfig;
import com.travel_agency_frontend.backend.domain.dto.HotelDTO;
import com.travel_agency_frontend.backend.domain.dto.get.HotelDTOGet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class HotelClient {
    private final RestTemplate restTemplate;
    private final BackendConfig backEndConfig;

    public List<HotelDTOGet> getHotels() {
        URI url = UriComponentsBuilder.fromHttpUrl(
                        backEndConfig.getEndpoint() + backEndConfig.getHotel())
                .build()
                .encode()
                .toUri();
        try {
            HotelDTOGet[] response = restTemplate.getForObject(url, HotelDTOGet[].class);
            return new ArrayList<>(Optional.ofNullable(response)
                    .map(Arrays::asList)
                    .orElse(Collections.emptyList()));
        } catch (RestClientException e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public List<HotelDTO> getAdminHotels() {
        URI url = UriComponentsBuilder.fromHttpUrl(
                        backEndConfig.getEndpoint() + backEndConfig.getHotel() + "/admin")
                .build()
                .encode()
                .toUri();
        try {
            HotelDTO[] response = restTemplate.getForObject(url, HotelDTO[].class);
            return new ArrayList<>(Optional.ofNullable(response)
                    .map(Arrays::asList)
                    .orElse(Collections.emptyList()));
        } catch (RestClientException e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public String createExampleData() {
        URI url = UriComponentsBuilder.fromHttpUrl(
                        backEndConfig.getEndpoint() + backEndConfig.getHotel() + "/testData")
                .build()
                .encode()
                .toUri();
        return restTemplate.postForObject(url, null, String.class);
    }
}
