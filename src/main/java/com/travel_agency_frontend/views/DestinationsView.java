package com.travel_agency_frontend.views;


import com.travel_agency_frontend.backend.domain.dto.ReservationForm;
import com.travel_agency_frontend.backend.domain.dto.get.DestinationDTOGet;
import com.travel_agency_frontend.service.DestinationService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;


@Route("destinations")
public class DestinationsView extends VerticalLayout {
    private final DestinationService destinationService;
    private final TextField filter = new TextField();
    private final Grid<DestinationDTOGet> grid = new Grid<>(DestinationDTOGet.class);

    public DestinationsView(DestinationService destinationService) {
        this.destinationService = destinationService;
        configureGrid();
        refresh();
        ReservationForm reservationForm = new ReservationForm();
//        HorizontalLayout layout = new HorizontalLayout(grid);

        add(grid);
        setSizeFull();
    }

    public void configureGrid() {
        filter.setPlaceholder("Filter by city");
        filter.setClearButtonVisible(true);
        filter.setValueChangeMode(ValueChangeMode.LAZY);
        setSizeFull();
        grid.setColumns("country", "city", "postcode", "hotelsList");
    }


    public void refresh() {
        grid.setItems(destinationService.getDestinations());
    }
}
