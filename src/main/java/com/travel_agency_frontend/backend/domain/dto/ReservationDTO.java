package com.travel_agency_frontend.backend.domain.dto;

import java.time.LocalDate;

public record ReservationDTO(Long reservationId, Long reservationOwner, Long hotelId, LocalDate checkIn_date,
                             LocalDate checkOut_date, long totalPrice) {
}
