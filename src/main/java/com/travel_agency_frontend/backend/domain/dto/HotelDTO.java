package com.travel_agency_frontend.backend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
    Long hotelId;
    String name;
    Long destinationId;
    Long unitPrice;

    @Override
    public String toString() {
        return
                name;
    }
}
