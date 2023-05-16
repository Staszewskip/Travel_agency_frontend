package com.travel_agency_frontend.backend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    Long reservationOwner;
    String hotelName;
    LocalDate checkIn_date;
    LocalDate checkOut_date;
}
