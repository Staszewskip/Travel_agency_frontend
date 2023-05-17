package com.travel_agency_frontend.service;

import com.travel_agency_frontend.backend.client.HotelClient;
import com.travel_agency_frontend.backend.domain.dto.HotelDTO;
import com.travel_agency_frontend.backend.domain.dto.get.HotelDTOGet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<HotelDTO> getAdminHotels() {
        return hotelClient.getAdminHotels();
    }

    public String createExampleData() {
        return hotelClient.createExampleData();
    }

    public List<HotelDTOGet> findByCity(String city) {
        return getHotels().stream()
                .filter(name -> name.getCity().contains(city))
                .collect(Collectors.toList());
    }
}
