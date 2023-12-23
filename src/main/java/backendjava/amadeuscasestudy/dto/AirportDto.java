package backendjava.amadeuscasestudy.dto;

import jakarta.validation.constraints.NotNull;

public class AirportDto {

    private int airportId;
    private String city;

    public AirportDto(int airportId, String city) {
        this.airportId = airportId;
        this.city = city;
    }

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
