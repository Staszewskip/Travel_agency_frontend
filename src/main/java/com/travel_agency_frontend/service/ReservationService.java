package com.travel_agency_frontend.service;

import com.travel_agency_frontend.backend.client.ReservationClient;
import com.travel_agency_frontend.backend.domain.dto.ReservationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private static ReservationService reservationService;
    private final ReservationClient reservationClient;

    public static ReservationService getInstance(ReservationClient reservationClient) {
        if (reservationService == null) {
            reservationService = new ReservationService(reservationClient);
        }
        return reservationService;
    }

    public ReservationDTO addReservation(ReservationDTO reservationDTO) {
        return reservationClient.addReservation(reservationDTO);
    }
}
