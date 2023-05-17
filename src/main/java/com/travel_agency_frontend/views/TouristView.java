package com.travel_agency_frontend.views;

import com.travel_agency_frontend.backend.domain.dto.TouristDTO;
import com.travel_agency_frontend.service.TouristService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Tourist")
@Route("tourist")
public class TouristView extends FormLayout {
    private final TouristService touristService;
    private final TextField firstName = new TextField("Firstname");
    private final TextField lastName = new TextField("Lastname");
    private final DatePicker birthday = new DatePicker("Date of birth");
    private final TextField login = new TextField("Login");
    private final PasswordField password = new PasswordField("Password");
    private final EmailField email = new EmailField("Email");
    private final TextField phoneNumber = new TextField("Phone number");
    private final Button saveButton = new Button("Save");


    public TouristView(TouristService touristService) {
        this.touristService = touristService;
        add(firstName, lastName, birthday, login, password, email, phoneNumber, saveButton);
        saveButton.addClickListener(event -> addTourist());
    }


    public void addTourist() {
        TouristDTO touristDTO = new TouristDTO();
        touristDTO.setFirstname(firstName.getValue());
        touristDTO.setLastname(lastName.getValue());
        touristDTO.setBirthdate(birthday.getValue());
        touristDTO.setLogin(login.getValue());
        touristDTO.setPassword(password.getValue());
        touristDTO.setEmail(email.getValue());
        touristDTO.setPhoneNumber(Integer.parseInt(phoneNumber.getValue()));
        Notification.show("Tourist saved");
        touristService.addTourist(touristDTO);
    }
}


