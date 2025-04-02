package com.siim.cgi.flight;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>{

    List<Flight> findByOriginAndDestination(String origin, String destination);

    List<Flight> findByOriginAndDestinationAndDepartureBetween(String origin, String Destination, LocalDateTime from, LocalDateTime till);
}
