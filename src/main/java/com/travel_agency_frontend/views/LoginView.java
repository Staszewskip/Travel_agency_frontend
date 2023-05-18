package com.travel_agency_frontend.views;

import com.travel_agency_frontend.backend.client.TouristClient;
import com.travel_agency_frontend.forms.LoggingForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("login")
public class LoginView extends VerticalLayout {

    public LoginView(TouristClient touristClient) {
        LoggingForm loggingForm = new LoggingForm(touristClient);
        add(loggingForm);
    }
}
