package com.travel_agency_frontend.backend.domain.dto.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TouristDTOGet {
    Long touristId;
    String firstname;
    String lastname;
    String login;
    LocalDate birthdate;
    String email;
    int phoneNumber;

    @Override
    public String toString() {
        return
                firstname + " "
                        + lastname;
    }
}
