package com.siim.cgi;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FlightRepository {
    private final JdbcClient jdbcClient;

    public FlightRepository(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public List<Flight> findall(){
        return jdbcClient.sql("SELECT * FROM flights;")
                .query(Flight.class)
                .list();
    }

    public Optional<Flight> findById(Integer id){
        return jdbcClient.sql("SELECT * FROM flights WHERE id = :id;")
                .param("id",id)
                .query(Flight.class)
                .optional();
    }

    List<Flight> findByOrigDest(String origin, String destination){
        return jdbcClient.sql("SELECT * FROM flights WHERE origin = :origin AND destination= :destination;")
                .param("origin",origin)
                .param("destination",destination)
                .query(Flight.class)
                .list();
    }
}
