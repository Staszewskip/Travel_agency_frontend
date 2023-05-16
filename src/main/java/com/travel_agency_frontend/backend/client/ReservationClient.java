package com.travel_agency_frontend.backend.client;

import com.travel_agency_frontend.backend.config.BackendConfig;
import com.travel_agency_frontend.backend.domain.dto.ReservationDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationClient {
    private final RestTemplate restTemplate;
    private final BackendConfig backEndConfig;

    public ReservationDTO addReservation(ReservationDTO reservationDTO) {
        URI url = UriComponentsBuilder.fromHttpUrl(backEndConfig.getEndpoint() + backEndConfig.getReservation())
                .build()
                .encode()
                .toUri();

        return restTemplate.postForObject(url, reservationDTO, ReservationDTO.class);
    }
}
