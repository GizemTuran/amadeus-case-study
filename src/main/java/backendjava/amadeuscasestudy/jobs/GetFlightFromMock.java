package backendjava.amadeuscasestudy.jobs;

import backendjava.amadeuscasestudy.entity.Airport;
import backendjava.amadeuscasestudy.entity.Flight;
import backendjava.amadeuscasestudy.mock.dto.FlightMockDto;
import backendjava.amadeuscasestudy.repository.AirportRepository;
import backendjava.amadeuscasestudy.repository.FlightRepository;
import backendjava.amadeuscasestudy.service.FlightService;
import org.hibernate.sql.results.graph.collection.internal.ArrayInitializerProducer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GetFlightFromMock {

    private FlightRepository flightRepository;
    private AirportRepository airportRepository;

    private RestTemplate restTemplate;

    public GetFlightFromMock(FlightRepository flightRepository,AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
        restTemplate = new RestTemplate();
    }

    @Scheduled(fixedRate = 600000)
    private void getFlightFromMock(){

        System.out.println("GETTING FLIGHT FROM MOCK STARTED");

        FlightMockDto flightMockDtos;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        for(int i = 0; i<10;i++) {
            Flight flight = new Flight();
            flightMockDtos = restTemplate.exchange("http://localhost:8080/mock/api/flight", HttpMethod.GET, entity, FlightMockDto.class).getBody();
            flight.setPrice(flightMockDtos.getPrice());
            flight.setArrivalTime(flightMockDtos.getArrivalTime());
            flight.setDepartureTime(flightMockDtos.getDepartureTime());

            Airport arrivalAirport = airportRepository.findAirportByCity(flightMockDtos.getArrivalAirport().city);
            Airport departureAirport = airportRepository.findAirportByCity(flightMockDtos.getDepartureAirport().city);

            if(null == arrivalAirport) {
                arrivalAirport = airportRepository.save(new Airport(flightMockDtos.getArrivalAirport().city));
            }
            flight.setArrivalAirport(arrivalAirport);

            if(null == departureAirport) {
                departureAirport = airportRepository.save(new Airport(flightMockDtos.getDepartureAirport().city));
            }
            flight.setDepartureAirport(departureAirport);

            flightRepository.save(flight);
        }

        System.out.println("GETTING FLIGHT FROM MOCK FINISHED");
    }

}
