package com.travel_agency_frontend.backend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TouristDTO{
    Long touristId;
    String firstname;
    String lastname;
    boolean isAdult;
    String login;
    String password;
    String email;
    int phoneNumber;
}
