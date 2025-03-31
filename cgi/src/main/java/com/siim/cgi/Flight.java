package com.siim.cgi;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
public class Flight{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String origin;
    private String destination;
    private LocalDateTime departure;
    private Integer seats;

    private Flight(){};

    public Flight(Integer id, String origin, LocalDateTime departure, String destination, Integer seats) {
        this.id = id;
        this.origin = origin;
        this.departure = departure;
        this.destination = destination;
        this.seats = seats;
    }

    public Integer getId() {
        return id;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public Integer getSeats() {
        return seats;
    }
}
