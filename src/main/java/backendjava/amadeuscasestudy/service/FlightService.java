package backendjava.amadeuscasestudy.service;

import backendjava.amadeuscasestudy.dto.FlightDto;
import backendjava.amadeuscasestudy.entity.Flight;
import backendjava.amadeuscasestudy.exception.InvalidTimeException;
import backendjava.amadeuscasestudy.exception.ServiceException;
import backendjava.amadeuscasestudy.request.FindDepartureTimeBetweenServiceRequest;

import java.util.Date;
import java.util.List;

public interface FlightService {
    Flight findById(int flightId);
    List<Flight> findAll();
    List<Flight> findByDepartureTimeBetween(FindDepartureTimeBetweenServiceRequest serviceRequest) throws ServiceException;
    String addFlight(FlightDto flightDto) throws InvalidTimeException;
    String deleteFlight(int flightId);
    String updateFlight(FlightDto flightDto);
}
