package backendjava.amadeuscasestudy.mock;

import backendjava.amadeuscasestudy.entity.Airport;
import backendjava.amadeuscasestudy.entity.Flight;
import backendjava.amadeuscasestudy.mock.dto.AirportMockDto;
import backendjava.amadeuscasestudy.mock.dto.FlightMockDto;
import backendjava.amadeuscasestudy.repository.AirportRepository;
import backendjava.amadeuscasestudy.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

@RestController
public class MockService {

    private FlightRepository flightRepository;
    private AirportRepository airportRepository;

    private Random randomGenerator;

    public MockService(FlightRepository flightRepository,AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
        randomGenerator = new Random();
    }

    public static List<String> airportList = new ArrayList<String>(){
        {
            add("İstanbul");
            add("Ankara");
            add("İzmir");
            add("Rotterdam");
            add("Köln");
            add("Salzburg");
            add("Milano");
            add("Amsterdam");
            add("Venedik");
            add("Münih");
            add("Berlin");
            add("Roma");
            add("Londra");
            add("Edinburg");
            add("New York");
            add("Bakü");
            add("Dublin");
        }
    };

    @GetMapping("/mock/api/flight")
    public FlightMockDto generateFlight(){
        long offset = Timestamp.valueOf("2023-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2024-01-01 00:00:00").getTime();
        long diff = end - offset + 1;

        HashSet<Integer> arrivalDepartureIndex = new HashSet<>();
        while (arrivalDepartureIndex.size()<2) {
            arrivalDepartureIndex.add(randomGenerator.nextInt(airportList.size()));
        }

        String arrivalAirport = airportList.get(arrivalDepartureIndex.stream().toList().get(0));
        String departureAirport = airportList.get(arrivalDepartureIndex.stream().toList().get(1));

        Timestamp randTime = new Timestamp(offset + (long)(Math.random() * diff));
        FlightMockDto flight = new FlightMockDto();

        flight.setDepartureTime(randTime);
        flight.setArrivalTime(new Timestamp(randTime.getTime() + (1000*60*60*3)));
        flight.setArrivalAirport(new AirportMockDto(arrivalAirport));
        flight.setDepartureAirport(new AirportMockDto(departureAirport));
        flight.setPrice(randomGenerator.nextInt(10000-2000)+2000);

        return flight;
    }


}
