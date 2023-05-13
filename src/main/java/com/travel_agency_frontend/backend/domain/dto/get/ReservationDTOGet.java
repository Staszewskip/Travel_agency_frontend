package com.travel_agency_frontend.backend.domain.dto.get;

import com.travel_agency_frontend.backend.domain.dto.TouristGuestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTOGet {
    Long reservationOwnerId;
    String hotelName;
    LocalDate checkIn_date;
    LocalDate checkOut_date;
    List<TouristGuestDTO> touristGuestList;
    Long totalPrice;
}
