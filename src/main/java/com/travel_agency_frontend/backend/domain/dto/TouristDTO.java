package com.travel_agency_frontend.backend.domain.dto;

public record TouristDTO(Long touristId, String firstname, String lastname, boolean isAdult, String login,
                         String password, String email, int phoneNumber) {
}
