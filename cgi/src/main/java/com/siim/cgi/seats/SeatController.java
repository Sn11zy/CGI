package com.siim.cgi.seats;

import com.siim.cgi.flight.Flight;
import com.siim.cgi.flight.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class SeatController {
    @Autowired
    private FlightRepository flightRepo;
    @Autowired
    private SeatRepository seatRepo;

    @GetMapping("/{id}")
    public String flightInfo(Model model, @PathVariable("id") Integer id){
        Optional<Flight> flightOptional = flightRepo.findById(id);
        List<Seat> takenSeats = seatRepo.findByFlightidAndTaken(id, true);
        if (flightOptional.isEmpty()){
            return "/error";
        }
        model.addAttribute("flight", flightOptional.get());
        model.addAttribute("takenSeats", takenSeats);
        return "flight";
    }
}
