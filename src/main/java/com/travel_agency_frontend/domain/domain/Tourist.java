package com.travel_agency_frontend.domain.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name = "tourists")
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long touristId;

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @NotNull
    private boolean isAdult;

    @NotNull
    private String login;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @NotNull
    private int phoneNumber;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "join_tourist_reservation",
            joinColumns = {@JoinColumn(name = "touristId", referencedColumnName = "touristId")},
            inverseJoinColumns = {@JoinColumn(name = "reservationId", referencedColumnName = "reservationId")}
    )
    private List<Reservation> reservationList = new ArrayList<>();

    public Tourist(String firstname, String lastname, boolean isAdult, String login, String password, String email, int phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.isAdult = isAdult;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
