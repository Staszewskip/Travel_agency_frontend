package com.travel_agency_frontend.backend.domain.dto;

import com.travel_agency_frontend.backend.client.HotelClient;
import com.travel_agency_frontend.backend.client.ReservationClient;
import com.travel_agency_frontend.backend.client.TouristClient;
import com.travel_agency_frontend.backend.domain.dto.get.HotelDTOGet;
import com.travel_agency_frontend.backend.domain.dto.get.TouristDTOGet;
import com.travel_agency_frontend.service.HotelService;
import com.travel_agency_frontend.service.ReservationService;
import com.travel_agency_frontend.service.TouristService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.data.binder.Binder;


public class ReservationForm extends FormLayout {
    private ReservationService reservationService;
    private HotelService hotelService;
    private TouristService touristService;
    private final ComboBox<TouristDTOGet> name = new ComboBox<>("Tourist name");
    private final ComboBox<HotelDTOGet> hotel = new ComboBox<>("Hotel name");
    private final DatePicker checkIn = new DatePicker("Check-in date");
    private final DatePicker checkOut = new DatePicker("Check-out date");
    private final Button save = new Button("Add reservation");
    private Binder<TouristDTO> touristDTOBinder = new Binder<TouristDTO>(TouristDTO.class);
    private Binder<HotelDTO> hotelDTOBinder = new Binder<HotelDTO>(HotelDTO.class);
    private Binder<ReservationDTO> reservationDTOBinder = new Binder<ReservationDTO>(ReservationDTO.class);

    public ReservationForm(HotelService hotelService, TouristService touristService, HotelClient hotelClient, ReservationClient reservationClient, TouristClient touristClient) {
        this.hotelService = HotelService.getInstance(hotelClient);
        this.touristService = TouristService.getInstance(touristClient);
        this.reservationService = ReservationService.getInstance(reservationClient);
        name.setItems(touristService.getTourists());
        hotel.setItems(hotelService.getHotels());

        save.addClickListener(reservation -> addReservation());
        add(name, hotel, checkIn, checkOut, save);
    }

    public ReservationDTO addReservation() {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setReservationOwner(name.getValue().getTouristId());
        reservationDTO.setHotelName(hotel.getValue().getName());
        reservationDTO.setCheckIn_date(checkIn.getValue());
        reservationDTO.setCheckOut_date(checkOut.getValue());
        if (name.isEmpty() || hotel.isEmpty() || checkIn.isEmpty() || checkOut.isEmpty()) {
            Notification.show("Please fill in all fields");
            return null;
        }
        return reservationService.addReservation(reservationDTO);
    }
}
