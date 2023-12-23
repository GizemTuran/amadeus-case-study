package backendjava.amadeuscasestudy.mock.dto;

import backendjava.amadeuscasestudy.entity.Airport;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
public class FlightMockDto {
    private AirportMockDto departureAirport;
    private AirportMockDto arrivalAirport;
    private Timestamp departureTime;
    private Timestamp arrivalTime;
    private double price;


    public AirportMockDto getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(AirportMockDto departureAirport) {
        this.departureAirport = departureAirport;
    }

    public AirportMockDto getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(AirportMockDto arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

