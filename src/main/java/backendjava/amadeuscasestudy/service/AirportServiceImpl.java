package backendjava.amadeuscasestudy.service;

import backendjava.amadeuscasestudy.entity.Airport;
import backendjava.amadeuscasestudy.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AirportServiceImpl implements AirportService{

    private AirportRepository airportRepository;

    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository=airportRepository;
    }

    @Override
    public List<Airport> findAll() {
        return airportRepository.findAll();
    }

    @Override
    public String addAirport(Airport airport) {
        airportRepository.save(airport);
        return "Added successfully";
    }

    @Override
    public String updateAirport(Airport airport) {
        airportRepository.save(airport);
        return "Updated successfully";
    }

    @Override
    public String deleteAirport(int airportId) {
        airportRepository.deleteById(airportId);
        return "Deleted successfully";
    }
}
