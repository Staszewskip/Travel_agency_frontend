package com.travel_agency_frontend.backend.client;

import com.travel_agency_frontend.backend.config.BackendConfig;
import com.travel_agency_frontend.backend.domain.dto.ReservationDTO;
import com.travel_agency_frontend.backend.domain.dto.get.ReservationDTOGet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationClient {
    private final RestTemplate restTemplate;
    private final BackendConfig backEndConfig;

    public List<ReservationDTOGet> getReservations() {
        URI url = UriComponentsBuilder.fromHttpUrl(backEndConfig.getEndpoint() + backEndConfig.getReservation() + "/admin")
                .build()
                .encode()
                .toUri();
        try {
            ReservationDTOGet[] response = restTemplate.getForObject(url, ReservationDTOGet[].class);
            return new ArrayList<>(Optional.ofNullable(response)
                    .map(Arrays::asList)
                    .orElse(Collections.emptyList()));
        } catch (RestClientException e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public ReservationDTO addReservation(ReservationDTO reservationDTO) {
        URI url = UriComponentsBuilder.fromHttpUrl(backEndConfig.getEndpoint() + backEndConfig.getReservation())
                .build()
                .encode()
                .toUri();
        return restTemplate.postForObject(url, reservationDTO, ReservationDTO.class);
    }
}
