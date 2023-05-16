package com.travel_agency_frontend.service;

import com.travel_agency_frontend.backend.client.TouristClient;
import com.travel_agency_frontend.backend.domain.dto.TouristDTO;
import com.travel_agency_frontend.backend.domain.dto.get.TouristDTOGet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TouristService {
    private static TouristService touristService;
    private final TouristClient touristClient;

    public static TouristService getInstance(TouristClient touristClient) {
        if (touristService == null) {
            touristService = new TouristService(touristClient);
        }
        return touristService;
    }

    public TouristDTO addTourist(TouristDTO touristDTO) {
        return touristClient.addTourist(touristDTO);
    }

    public List<TouristDTOGet> getTourists() {
        return touristClient.showAllTourists();
    }
}
