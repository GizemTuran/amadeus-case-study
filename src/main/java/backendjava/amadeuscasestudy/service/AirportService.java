package backendjava.amadeuscasestudy.service;

import backendjava.amadeuscasestudy.entity.Airport;

import java.util.List;

public interface AirportService {

    List<Airport> findAll();
    String addAirport(Airport airport);
    String updateAirport(Airport airport);
    String deleteAirport(int airportId);
}
