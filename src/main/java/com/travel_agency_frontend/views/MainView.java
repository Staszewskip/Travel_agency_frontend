package com.travel_agency_frontend.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("home")
public class MainView extends VerticalLayout {
    public MainView() {
        H1 title = new H1("Travel agency");
        H4 text = new H4("This is a simple travel agency application - final project of the Kodilla Java Developer Course");
        H6 author = new H6("Author details:");
        H6 name = new H6("Paweł Staszewski");
        Anchor github = new Anchor("https://github.com/Staszewskip", "Link to my GitHub");
        Image downImage = new Image("images/beach.jpg", "Image at the main page of website");
        Button loginButton = new Button("Click to register new user", event -> UI.getCurrent().navigate("/tourist"));
        Button hotelButton = new Button("Click to check available destinations", event -> UI.getCurrent().navigate("/hotels"));
        Button reservationButton = new Button("Click to make reservation", event -> UI.getCurrent().navigate("/reservations"));

        VerticalLayout header = new VerticalLayout(title, text, author, name, github);
        header.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        HorizontalLayout horizontalLayout = new HorizontalLayout(loginButton, hotelButton, reservationButton);
        horizontalLayout.setDefaultVerticalComponentAlignment(Alignment.CENTER);

        VerticalLayout downImageLayout = new VerticalLayout(downImage);
        downImageLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add(header, horizontalLayout, downImageLayout);
    }

}

