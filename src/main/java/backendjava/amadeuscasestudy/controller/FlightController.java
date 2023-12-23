package backendjava.amadeuscasestudy.controller;

import backendjava.amadeuscasestudy.dto.FlightDto;
import backendjava.amadeuscasestudy.entity.Flight;
import backendjava.amadeuscasestudy.exception.InvalidTimeException;
import backendjava.amadeuscasestudy.exception.ServiceException;
import backendjava.amadeuscasestudy.request.FindDepartureTimeBetweenServiceRequest;
import backendjava.amadeuscasestudy.service.FlightService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
@SecurityRequirement(name = "bearerAuth")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @GetMapping("/find/{id}")
    public Flight findById(@PathVariable("id")int id){
        return flightService.findById(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @PostMapping("/find/departure-time-between")
    public ResponseEntity<List<Flight>> findByDepartureTimeBetween(@RequestBody FindDepartureTimeBetweenServiceRequest serviceRequest){
        try {
            return ResponseEntity.ok(flightService.findByDepartureTimeBetween(serviceRequest));
        }catch (ServiceException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/add")
    public String addFlight(@RequestBody FlightDto flightDto) throws InvalidTimeException {
            return flightService.addFlight(flightDto);
        }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping("/update")
    public String updateFlight(@RequestBody FlightDto flightDto){
        return flightService.updateFlight(flightDto);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String deleteFlight(@PathVariable("id")int id){
        return flightService.deleteFlight(id);
    }
}
