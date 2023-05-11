package com.travel_agency_frontend.views;


import com.travel_agency_frontend.domain.domain.Destination;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.awt.*;


@PageTitle("destinations")
@Route
public class DestinationsView extends VerticalLayout {
    Grid<Destination> grid = new Grid<>(Destination.class);
    TextField filterText = new TextField();

    public DestinationsView() {
        setSizeFull();

        configureGrid();
    }

    private void configureGrid() {
        grid.setSizeFull();
        grid.setColumns("country", "city", "postcode", "hotelList");
    }
}
