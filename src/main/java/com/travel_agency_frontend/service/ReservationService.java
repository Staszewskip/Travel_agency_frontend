package com.travel_agency_frontend.service;

import com.travel_agency_frontend.backend.client.ReservationClient;
import com.travel_agency_frontend.backend.domain.dto.ReservationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationClient reservationClient;
    public ReservationDTO addReservation(ReservationDTO reservationDTO) {
        return reservationClient.addReservation(reservationDTO);
    }
}
