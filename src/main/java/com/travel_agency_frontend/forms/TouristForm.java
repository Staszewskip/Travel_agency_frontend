package com.travel_agency_frontend.forms;

import com.travel_agency_frontend.backend.client.TouristClient;
import com.travel_agency_frontend.backend.domain.dto.Role;
import com.travel_agency_frontend.backend.domain.dto.TouristDTO;
import com.travel_agency_frontend.service.TouristService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

public class TouristForm extends FormLayout {
    private final TouristService touristService;
    private final TextField firstName = new TextField("Firstname");
    private final TextField lastName = new TextField("Lastname");
    private final DatePicker birthday = new DatePicker("Date of birth");
    private final TextField login = new TextField("Login");
    private final PasswordField password = new PasswordField("Password");
    private final EmailField email = new EmailField("Email");
    private final NumberField phoneNumber = new NumberField("Phone number");
    private final ComboBox<Role> role = new ComboBox<>("Role");
    private final Button saveButton = new Button("Save");

    public TouristForm(TouristService touristService, TouristClient touristClient) {
        this.touristService = TouristService.getInstance(touristClient);
        configureButtons();
        add(firstName, lastName, birthday, login, password, email, phoneNumber, role, saveButton);
        saveButton.addClickListener(event -> addTourist());
    }

    public void configureButtons() {
        role.setItems(Role.ADMIN, Role.USER);
        firstName.setMinLength(3);
        firstName.setHelperText("Min 3 characters");
        lastName.setMinLength(3);
        lastName.setHelperText("Min 3 characters");
        login.setMinLength(5);
        login.setHelperText("Min 5 characters");
        password.setMinLength(8);
        password.setHelperText("Min 5 characters");
        phoneNumber.setHelperText("Only digits allowed");
    }

    public TouristDTO addTourist() {
        TouristDTO touristDTO = new TouristDTO();
        touristDTO.setFirstname(firstName.getValue());
        touristDTO.setLastname(lastName.getValue());
        touristDTO.setBirthdate(birthday.getValue());
        touristDTO.setLogin(login.getValue());
        touristDTO.setPassword(password.getValue());
        touristDTO.setEmail(email.getValue());
        touristDTO.setPhoneNumber(Integer.parseInt(phoneNumber.getValue().toString()));
        touristDTO.setRole(role.getValue());
        if (firstName.isEmpty() || lastName.isEmpty() || birthday.isEmpty() || login.isEmpty()
                || password.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || role.isEmpty()) {
            Notification.show("Please fill in all fields");
            return null;
        }
        UI.getCurrent().navigate("/home");
        Notification.show("Tourist saved");
        return touristService.addTourist(touristDTO);
    }
}
