package com.siim.cgi.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class flightsController {

    @Autowired
    private FlightRepository repo;

    @GetMapping("")
    public String showFlights(
            Model model,
            @RequestParam(required = false) String origin,
            @RequestParam(required = false) String destination,
            @RequestParam(required = false) LocalDateTime from,
            @RequestParam(required = false) LocalDateTime till){

        if (origin==null&&destination==null||origin==""&&destination==""){
            model.addAttribute("flights", repo.findAll());
        } else if (from==null&&till==null){
            model.addAttribute("flights", repo.findByOriginAndDestination(origin, destination));
        } else {
            model.addAttribute("flights",repo.findByOriginAndDestinationAndDepartureBetween(origin,destination,from,till));
        }
        return "index";
    }

    @GetMapping("{id}")
    public String flightInfo(Model model, @PathVariable Integer id){
        Optional<Flight> flightOptional = repo.findById(id);
        if (flightOptional.isEmpty()){
            return "/error";
        }
        model.addAttribute("flight", flightOptional.get());
        return "flight";
    }



}
