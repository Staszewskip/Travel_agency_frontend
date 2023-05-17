package com.travel_agency_frontend.backend.domain.dto;

import com.travel_agency_frontend.backend.client.ReservationClient;
import com.travel_agency_frontend.backend.domain.dto.get.TouristDTOGet;
import com.travel_agency_frontend.service.HotelService;
import com.travel_agency_frontend.service.ReservationService;
import com.travel_agency_frontend.service.TouristService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;


public class ReservationForm extends FormLayout {
    private final ReservationService reservationService;

    private final ComboBox<TouristDTOGet> name = new ComboBox<>("Tourist name");
    private final ComboBox<HotelDTO> hotel = new ComboBox<>("Hotel name");
    private final DatePicker checkIn = new DatePicker("Check-in date");
    private final DatePicker checkOut = new DatePicker("Check-out date");
    private final Button save = new Button("Add reservation");
//    private Binder<TouristDTO> touristDTOBinder = new Binder<TouristDTO>(TouristDTO.class);
//    private Binder<HotelDTO> hotelDTOBinder = new Binder<HotelDTO>(HotelDTO.class);
//    private Binder<ReservationDTO> reservationDTOBinder = new Binder<ReservationDTO>(ReservationDTO.class);

    public ReservationForm(HotelService hotelService, TouristService touristService,  ReservationClient reservationClient) {
        this.reservationService = ReservationService.getInstance(reservationClient);
        name.setItems(touristService.getTourists());
        hotel.setItems(hotelService.getAdminHotels());

        save.addClickListener(reservation -> addReservation());
        add(name, hotel, checkIn, checkOut, save);
    }

    public ReservationDTO addReservation() {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setReservationOwner(name.getValue().getTouristId());
        reservationDTO.setHotelId(hotel.getValue().getHotelId());
        reservationDTO.setCheckIn_date(checkIn.getValue());
        reservationDTO.setCheckOut_date(checkOut.getValue());
        if (name.isEmpty() || hotel.isEmpty() || checkIn.isEmpty() || checkOut.isEmpty()) {
            Notification.show("Please fill in all fields");
            return null;
        }
        Notification.show("Reservation added. Thank you!");
        return reservationService.addReservation(reservationDTO);
    }
}
