package com.travel_agency_frontend.views;


import com.travel_agency_frontend.backend.client.HotelClient;
import com.travel_agency_frontend.backend.client.ReservationClient;
import com.travel_agency_frontend.backend.client.TouristClient;
import com.travel_agency_frontend.backend.domain.dto.ReservationForm;
import com.travel_agency_frontend.backend.domain.dto.get.HotelDTOGet;
import com.travel_agency_frontend.service.HotelService;
import com.travel_agency_frontend.service.TouristService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;


@Route("reservation")
public class HotelView extends VerticalLayout {
    private final HotelService hotelService;
    private final TouristService touristService;
    private TextField filter = new TextField();
    private Grid<HotelDTOGet> grid = new Grid<>(HotelDTOGet.class);


    public HotelView(HotelClient hotelClient, ReservationClient reservationClient, TouristClient touristClient) {
        this.hotelService = HotelService.getInstance(hotelClient);
        this.touristService = TouristService.getInstance(touristClient);
        configureGrid();
        refresh();
        ReservationForm reservationForm = new ReservationForm(hotelService, touristService, hotelClient, reservationClient, touristClient);

//        HorizontalLayout layout = new HorizontalLayout(grid);
//        HorizontalLayout layout = new HorizontalLayout(grid, reservationForm);
        add(reservationForm,grid);
//        setSizeFull();
    }

    public void configureGrid() {
        filter.setPlaceholder("Filter by city");
        filter.setClearButtonVisible(true);
        filter.setValueChangeMode(ValueChangeMode.LAZY);
        grid.setColumns("country", "city", "name");
    }


    public void refresh() {
        grid.setItems(hotelService.getHotels());
    }
}
