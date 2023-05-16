package com.travel_agency_frontend.service;

import com.travel_agency_frontend.backend.client.HotelClient;
import com.travel_agency_frontend.backend.domain.dto.get.HotelDTOGet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {
    private static HotelService hotelService;
    private final HotelClient hotelClient;

    public static HotelService getInstance(HotelClient hotelClient) {
        if (hotelService == null) {
            hotelService = new HotelService(hotelClient);
        }
        return hotelService;
    }

        public List<HotelDTOGet> getHotels() {
        return hotelClient.getHotels();
    }
}
