package com.travel_agency_frontend.backend.domain.dto.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTOGet {
    String country;
    String city;
    String name;
    Long unitPrice;

    @Override
    public String toString() {
        return
                city + " -> " + name;
    }
}
