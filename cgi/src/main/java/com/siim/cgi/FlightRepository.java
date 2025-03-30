package com.siim.cgi;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FlightRepository {
    private List<Flight> flights = new ArrayList<>();

    List<Flight> findall(){
        return flights;
    }

    Optional<Flight> findById(Integer id){
        return flights.stream()
                .filter(flight -> flight.id() == id)
                .findFirst();
    }

    List<Flight> findByOrigDest(String origin, String destination){
        return flights.stream()
                .filter(flight -> flight.origin().equals(origin)&&flight.destination().equals(destination))
                .toList();
    }

    @PostConstruct
    private void init(){
        flights.add(new Flight(
                0,
                "Tallinn",
                "Helsinki",
                LocalDateTime.now(),
                10));

        flights.add(new Flight(
                1,
                "Tallinn",
                "Stockholm",
                LocalDateTime.now().plus(3, ChronoUnit.HOURS),
                40));
        flights.add(new Flight(
                2,
                "Tallinn",
                "Helsinki",
                LocalDateTime.now().plus(2,ChronoUnit.HOURS),
                50));
    }
}
