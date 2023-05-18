package com.travel_agency_frontend.service;

import com.travel_agency_frontend.backend.client.TouristClient;
import com.travel_agency_frontend.backend.domain.dto.TouristDTO;
import com.travel_agency_frontend.backend.domain.dto.TouristLoggedDTO;
import com.travel_agency_frontend.backend.domain.dto.TouristLoggingDTO;
import com.travel_agency_frontend.backend.domain.dto.get.TouristDTOGet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TouristService {
    public static TouristService touristService;
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

    public TouristLoggedDTO login(TouristLoggingDTO touristLoggingDTO) {
        return touristClient.login(touristLoggingDTO);
    }

    public TouristDTOGet findByLogin(String login) {
        return touristClient.findByLogin(login);
    }

    public boolean existsByLogin(String login) {
        return touristClient.existsByLogin(login);
    }

}
