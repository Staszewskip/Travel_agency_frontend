package com.travel_agency_frontend.backend.domain.dto.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TouristDTOGet {
    Long touristId;
    String firstname;
    String lastname;
    boolean isAdult;
    String email;
    int phoneNumber;

    @Override
    public String toString() {
        return
                firstname + " "
                        + lastname;
    }
}
