package backendjava.amadeuscasestudy.service;

import backendjava.amadeuscasestudy.dto.FlightDto;
import backendjava.amadeuscasestudy.entity.Airport;
import backendjava.amadeuscasestudy.entity.Flight;
import backendjava.amadeuscasestudy.exception.InvalidTimeException;
import backendjava.amadeuscasestudy.exception.ServiceException;
import backendjava.amadeuscasestudy.repository.AirportRepository;
import backendjava.amadeuscasestudy.repository.FlightRepository;
import backendjava.amadeuscasestudy.request.FindDepartureTimeBetweenServiceRequest;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService{

    private FlightRepository flightRepository;
    private AirportRepository airportRepository;

    public FlightServiceImpl(FlightRepository flightRepository,AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
    }

    @Override
    public Flight findById(int flightId) {

        Optional<Flight> optional = flightRepository.findById(flightId);

        if(optional.isPresent()) {
            return optional.get();
        }
        else {
            return null;
        }
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public List<Flight> findByDepartureTimeBetween(FindDepartureTimeBetweenServiceRequest serviceRequest) throws ServiceException {

        Timestamp firstFlightTime;
        if (serviceRequest.getFirstflighttime() != null){
            firstFlightTime = new Timestamp(serviceRequest.getFirstflighttime().getTime());
        } else {
            throw new ServiceException("Flight is not available.");
        }

        List<Flight> flightList = new ArrayList<>();

        Optional<Airport> arrivalAirport = airportRepository.findById(serviceRequest.getArrivalAirportId());
        Optional<Airport> departureAirport = airportRepository.findById(serviceRequest.getDepartureAirportId());

        //First Flight
        if(arrivalAirport.isPresent() && departureAirport.isPresent()) {
            List<Flight> firstFlightList = flightRepository.findByDepartureTimeBetween(firstFlightTime, departureAirport.get(), arrivalAirport.get());
            if(firstFlightList.isEmpty()) {
                throw new ServiceException("Flight is not available.");
            }
            flightList.add(firstFlightList.get(0));
        }
        else {
            throw new ServiceException("Airport not found.");
        }

        //Returning Flight
        if(serviceRequest.getLastflighttime() != null){
            Timestamp lastFlightTime = new Timestamp(serviceRequest.getLastflighttime().getTime());
            List<Flight> returningFlightList = flightRepository.findByDepartureTimeBetween(lastFlightTime,arrivalAirport.get(),departureAirport.get());
            if(returningFlightList.isEmpty()){
                return flightList;
            }else {
                flightList.add(returningFlightList.get(0));
                return flightList;
            }
        }
        return flightList;
    }

    @Override
    public String addFlight(FlightDto flightDto) throws InvalidTimeException {

        Flight flight = new Flight();
        if(flightDto.getArrivalTime().before(flightDto.getDepartureTime())){
                throw new InvalidTimeException("Arrival time cannot be earlier than departure time!");
        }
        Optional<Airport> arrivalAirport = airportRepository.findById(flightDto.getArrivalAirportId());
        Optional<Airport> departureAirport = airportRepository.findById(flightDto.getDepartureAirportId());
        flight.setArrivalAirport(arrivalAirport.get());
        flight.setDepartureAirport(departureAirport.get());
        flight.setPrice(flightDto.getPrice());
        flight.setArrivalTime(flightDto.getArrivalTime());
        flight.setDepartureTime(flightDto.getDepartureTime());

        flightRepository.save(flight);
        return "Added successfully";
    }

    @Override
    public String deleteFlight(int flightId) {
        flightRepository.deleteById(flightId);
        return "Deleted successfully!";
    }

    @Override
    public String updateFlight(FlightDto flightDto) {

        Optional<Airport> arrivalAirport = airportRepository.findById(flightDto.getArrivalAirportId());
        Optional<Airport> departureAirport = airportRepository.findById(flightDto.getDepartureAirportId());
        Flight flight=flightRepository.findById(flightDto.getFlightId()).get();
        flight.setDepartureAirport(departureAirport.get());
        flight.setArrivalAirport(arrivalAirport.get());
        flight.setPrice(flightDto.getPrice());
        flight.setArrivalTime(flightDto.getArrivalTime());
        flight.setDepartureTime(flightDto.getDepartureTime());

        return "Updated successfully!";
    }
}
