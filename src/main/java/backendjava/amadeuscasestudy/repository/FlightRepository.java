package backendjava.amadeuscasestudy.repository;

import backendjava.amadeuscasestudy.entity.Airport;
import backendjava.amadeuscasestudy.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Integer> {
    @Query("select f from Flight AS f where f.departureTime>=:departureTime and f.departureAirport=:departureAirport and f.arrivalAirport=:arrivalAirport")
    List<Flight> findByDepartureTimeBetween(Timestamp departureTime, Airport departureAirport, Airport arrivalAirport);

}
