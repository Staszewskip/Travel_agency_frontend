package com.travel_agency_frontend.service;

import com.travel_agency_frontend.backend.client.TouristClient;
import com.travel_agency_frontend.backend.domain.dto.TouristDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TouristService {
    private  final TouristClient touristClient;

    public TouristDTO addTourist(TouristDTO touristDTO) {
        return touristClient.addTourist(touristDTO);
    }
}
