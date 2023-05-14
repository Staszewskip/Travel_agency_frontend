package com.travel_agency_frontend.service;

import com.travel_agency_frontend.backend.client.DestinationClient;
import com.travel_agency_frontend.backend.domain.dto.get.DestinationDTOGet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationService {
    private final DestinationClient destinationClient;

    public List<DestinationDTOGet> getDestinations() {
        return destinationClient.getDestinations();
    }
}
