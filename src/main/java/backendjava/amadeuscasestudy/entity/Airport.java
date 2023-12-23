package backendjava.amadeuscasestudy.entity;

import jakarta.persistence.*;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int airportId;
    private String city;

    public Airport(){

    }

    public Airport(int airportId, String city) {
        this.airportId = airportId;
        this.city = city;
    }

    public Airport(String city) {
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
