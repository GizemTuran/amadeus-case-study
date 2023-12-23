package backendjava.amadeuscasestudy.controller;

import backendjava.amadeuscasestudy.entity.Airport;
import backendjava.amadeuscasestudy.entity.Flight;
import backendjava.amadeuscasestudy.service.AirportService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
@SecurityRequirement(name="bearerAuth")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @GetMapping("/find/all")
    public List<Airport> findAll(){
        return airportService.findAll();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/add")
    public String addAirport(@RequestBody Airport airport){
        return airportService.addAirport(airport);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping("/update")
    public String updateAirport(@RequestBody Airport airport){
        return airportService.updateAirport(airport);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String deleteAirport(@PathVariable("id")int id){
        return airportService.deleteAirport(id);
    }
}
