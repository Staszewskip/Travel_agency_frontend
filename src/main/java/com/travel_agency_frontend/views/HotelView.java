package com.travel_agency_frontend.views;


import com.travel_agency_frontend.backend.client.HotelClient;
import com.travel_agency_frontend.backend.domain.dto.get.HotelDTOGet;
import com.travel_agency_frontend.service.HotelService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;


@Route("hotels")
public class HotelView extends VerticalLayout {
    private final HotelService hotelService;
    private final TextField filter = new TextField();
    private final Grid<HotelDTOGet> grid = new Grid<>(HotelDTOGet.class);

    public HotelView(HotelClient hotelClient) {
        this.hotelService = HotelService.getInstance(hotelClient);
        createExampleData();
        configureGrid();
        refresh();
        add(filter, grid);
    }

    public void configureGrid() {
        filter.setPlaceholder("Filter by city");
        filter.setClearButtonVisible(true);
        filter.setValueChangeMode(ValueChangeMode.LAZY);
        filter.addValueChangeListener(e -> update());
        grid.setColumns("country", "city", "name", "unitPrice");
    }

    public void refresh() {
        grid.setItems(hotelService.getHotels());
    }

    private void update() {
        grid.setItems(hotelService.findByCity(filter.getValue()));
    }

    private void createExampleData() {
        hotelService.createExampleData();
    }
}
