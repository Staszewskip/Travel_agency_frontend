package com.travel_agency_frontend.forms;

import com.travel_agency_frontend.backend.client.ReservationClient;
import com.travel_agency_frontend.backend.client.TouristClient;
import com.travel_agency_frontend.backend.domain.dto.HotelDTO;
import com.travel_agency_frontend.backend.domain.dto.ReservationDTO;
import com.travel_agency_frontend.backend.exception.TouristNotFoundException;
import com.travel_agency_frontend.service.HotelService;
import com.travel_agency_frontend.service.ReservationService;
import com.travel_agency_frontend.service.TouristService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;


public class ReservationForm extends FormLayout {
    private final ReservationService reservationService;
    private final TouristService touristService;
    private final TextField name = new TextField("Login");
    private final ComboBox<HotelDTO> hotel = new ComboBox<>("Hotel name");
    private final DatePicker checkIn = new DatePicker("Check-in date");
    private final DatePicker checkOut = new DatePicker("Check-out date");
    private final Button save = new Button("Add reservation");

    public ReservationForm(HotelService hotelService, ReservationClient reservationClient, TouristClient touristClient) {
        this.reservationService = ReservationService.getInstance(reservationClient);
        this.touristService = TouristService.getInstance(touristClient);
        hotel.setItems(hotelService.getAdminHotels());
        save.addClickListener(reservation -> {
            try {
                addReservation();
            } catch (TouristNotFoundException e) {
                e.getMessage();
            }
        });
        add(name,hotel, checkIn, checkOut, save);
    }

    public void addReservation() throws TouristNotFoundException {
        ReservationDTO reservationDTO = new ReservationDTO();
        Long foundTouristId = touristService.findByLogin(name.getValue()).getTouristId();

        reservationDTO.setReservationOwnerId(foundTouristId);
        reservationDTO.setHotelId(hotel.getValue().getHotelId());
        reservationDTO.setCheckIn_date(checkIn.getValue());
        reservationDTO.setCheckOut_date(checkOut.getValue());
        if (name.isEmpty() || hotel.isEmpty() || checkIn.isEmpty() || checkOut.isEmpty()) {
            Notification.show("Please fill in all fields");
        } else if (!(touristService.existsByLogin(name.getValue()))) {
            Notification.show("User with such login does not exists");
            throw new TouristNotFoundException();
        } else {
            Notification.show("Reservation added. Thank you!");
            reservationService.addReservation(reservationDTO);
        }
    }
}
