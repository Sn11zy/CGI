package com.siim.cgi.seats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer> {

    List<Seat> findByFlightid(Integer flightid);
    List<Seat> findByFlightidAndTaken(Integer flightid, Boolean taken);
}
