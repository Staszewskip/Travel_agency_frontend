package com.travel_agency_frontend.views;


import com.travel_agency_frontend.backend.domain.dto.get.DestinationDTOGet;
import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


//@PageTitle("destinations")
@Route("destinations")
public class DestinationsView extends VerticalLayout {


    public DestinationsView() {

        setSizeFull();


    }

    public static Grid<DestinationDTOGet> setDestinationGrid(DestinationDTOGet destinationDTOGet) {
        Grid<DestinationDTOGet> destinationDTGrid = new Grid<>(DestinationDTOGet.class);
        destinationDTGrid.setColumns();

        destinationDTGrid.addComponentColumn(item -> {
                    Label label = new Label();
                    label.setText(destinationDTOGet.getCountry());
                    label.setWhiteSpace(HasText.WhiteSpace.NORMAL);
                    return label;
                })
                .setHeader("Country");
        destinationDTGrid.addComponentColumn(item -> {
                    Label label = new Label();
                    label.setText(destinationDTOGet.getCity());
                    label.setWhiteSpace(HasText.WhiteSpace.NORMAL);
                    return label;
                })
                .setHeader("City");
        destinationDTGrid.addComponentColumn(item -> {
                    Label label = new Label();
                    label.setText(destinationDTOGet.getHotelsList().toString());
                    label.setWhiteSpace(HasText.WhiteSpace.NORMAL);
                    return label;
                })
                .setHeader("Hotels");

        return destinationDTGrid;
    }
}
