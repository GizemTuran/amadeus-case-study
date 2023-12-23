package backendjava.amadeuscasestudy.repository;

import backendjava.amadeuscasestudy.entity.Airport;
import backendjava.amadeuscasestudy.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface AirportRepository extends JpaRepository<Airport,Integer> {

    Airport findAirportByCity(String city);
}
