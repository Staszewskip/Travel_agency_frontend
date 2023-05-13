
package com.travel_agency_frontend.backend.domain.dto.weather;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "location",
    "forecast"
})
@Generated("jsonschema2pojo")
public class WeatherDTO {

    @JsonProperty("location")
    @Valid
    private Location location;
    @JsonProperty("forecast")
    @Valid
    private Forecast forecast;
}
