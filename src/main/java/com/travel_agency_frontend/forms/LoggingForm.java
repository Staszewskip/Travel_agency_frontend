package com.travel_agency_frontend.forms;

import com.travel_agency_frontend.backend.client.TouristClient;
import com.travel_agency_frontend.backend.domain.dto.TouristLoggedDTO;
import com.travel_agency_frontend.backend.domain.dto.TouristLoggingDTO;
import com.travel_agency_frontend.service.TouristService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;

@Getter
public class LoggingForm extends FormLayout {
    private final TouristService touristService;
    private final TextField login = new TextField("Login");
    private final PasswordField password = new PasswordField("Password");
    private final Button log_in = new Button("Log in", event -> UI.getCurrent().navigate("/reservations"));

    public LoggingForm(TouristClient touristClient) {
        this.touristService = TouristService.getInstance(touristClient);
        log_in.addClickListener(login -> login());
        setMaxWidth("800px");
        add(login, password, log_in);
    }

    public TouristLoggedDTO login() {
        TouristLoggingDTO touristLoggingDTO = new TouristLoggingDTO();
        touristLoggingDTO.setLogin(login.getValue());
        touristLoggingDTO.setPassword(password.getValue());
        if (login.isEmpty() || password.isEmpty()) {
            Notification.show("Please fill in all fields");
            return null;
        } else {
            return touristService.login(touristLoggingDTO);
        }
    }
}
