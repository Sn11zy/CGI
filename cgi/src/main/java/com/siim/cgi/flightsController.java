package com.siim.cgi;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class flightsController {

    private final FlightRepository flightRepository;

    public flightsController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @GetMapping("/{id}")
    Flight findById(@PathVariable Integer id){
        Optional<Flight> flight = flightRepository.findById(id);
        if (flight.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return flight.get();
    }

    @GetMapping("")
    List<Flight> findByOrigDest(@RequestParam(required = false) String origin, @RequestParam(required = false) String destination){
        if (origin == null || destination == null){
            return flightRepository.findall();
        }
        return  flightRepository.findByOrigDest(origin,destination);
    }



}
