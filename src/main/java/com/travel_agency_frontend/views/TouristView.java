package com.travel_agency_frontend.views;

import com.travel_agency_frontend.backend.client.TouristClient;
import com.travel_agency_frontend.forms.TouristForm;
import com.travel_agency_frontend.service.TouristService;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Tourist")
@Route("tourist")
public class TouristView extends FormLayout {
    public TouristView(TouristClient touristClient) {
        TouristService touristService = TouristService.getInstance(touristClient);
        TouristForm touristForm = new TouristForm(touristService, touristClient);
        add(touristForm);
    }
}


