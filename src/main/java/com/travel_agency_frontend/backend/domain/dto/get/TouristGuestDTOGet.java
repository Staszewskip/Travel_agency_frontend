package com.travel_agency_frontend.backend.domain.dto.get;

import com.travel_agency_frontend.backend.domain.dto.ReservationDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TouristGuestDTOGet {
    String firstname;
    String lastname;
    boolean isAdult;
    List<ReservationDTO> reservationDTOList;
}
