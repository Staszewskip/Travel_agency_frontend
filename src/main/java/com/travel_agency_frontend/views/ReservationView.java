package com.travel_agency_frontend.views;

import com.travel_agency_frontend.backend.client.HotelClient;
import com.travel_agency_frontend.backend.client.ReservationClient;
import com.travel_agency_frontend.backend.client.TouristClient;
import com.travel_agency_frontend.forms.ReservationForm;
import com.travel_agency_frontend.service.HotelService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("reservations")
public class ReservationView extends VerticalLayout {

    public ReservationView(HotelClient hotelClient, ReservationClient reservationClient, TouristClient touristClient) {
        HotelService hotelService = HotelService.getInstance(hotelClient);
        ReservationForm reservationForm = new ReservationForm(hotelService, reservationClient, touristClient);
        add(reservationForm);
    }
}
