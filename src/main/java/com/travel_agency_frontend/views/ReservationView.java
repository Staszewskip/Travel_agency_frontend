package com.travel_agency_frontend.views;

import com.travel_agency_frontend.backend.client.HotelClient;
import com.travel_agency_frontend.backend.client.ReservationClient;
import com.travel_agency_frontend.backend.client.TouristClient;
import com.travel_agency_frontend.backend.domain.dto.ReservationForm;
import com.travel_agency_frontend.service.HotelService;
import com.travel_agency_frontend.service.TouristService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("reservations")
public class ReservationView extends VerticalLayout {

    public ReservationView(HotelClient hotelClient, TouristClient touristClient, ReservationClient reservationClient) {
        HotelService hotelService = HotelService.getInstance(hotelClient);
        TouristService touristService = TouristService.getInstance(touristClient);
        ReservationForm reservationForm = new ReservationForm(hotelService, touristService,  reservationClient);

        add(reservationForm);
    }
}
