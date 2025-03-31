package com.siim.cgi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class homecontroller {

    @GetMapping("")
    String landingPage(@RequestParam(required = false) Integer id){
        if (id == null){
            return "index.html";
        }
        return  "flight.html";
    }


}
