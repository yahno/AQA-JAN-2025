package org.prog.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {
    public StreetDto street;
    public String city;
    public String state;
    public String country;
    public String postcode;
    public CoordinatesDto coordinates;
    public TimezoneDto timezone;
}
