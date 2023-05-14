package com.travel_agency_frontend.backend.domain.dto;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;

public class ReservationForm extends FormLayout {
    private final TextField name = new TextField("Reservation owner");
    private final TextField hotel = new TextField("Hotel");
    private final DatePicker checkIn = new DatePicker("Check-in date");
    private final DatePicker checkOut = new DatePicker("Check-out date");
}
