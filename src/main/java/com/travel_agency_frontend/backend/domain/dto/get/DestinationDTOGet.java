package com.travel_agency_frontend.backend.domain.dto.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DestinationDTOGet {
    String country;
    String city;
    String postcode;
    List<HotelDTOGet> hotelsList;
}
