package backendjava.amadeuscasestudy.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int flightId;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "departureAirportId")
    private Airport departureAirport;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "arrivalAirportId")
    private Airport arrivalAirport;
    private Timestamp departureTime;
    private Timestamp arrivalTime;
    private double price;

    public Flight(){

    }

    public Flight(int flightId, Airport departureAirport, Airport arrivalAirport, Timestamp departureTime, Timestamp arrivalTime, double price) {
        this.flightId = flightId;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
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
