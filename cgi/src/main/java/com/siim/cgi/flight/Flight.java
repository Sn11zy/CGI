package com.siim.cgi.flight;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Flight{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String origin;
    private String destination;
    private LocalDateTime departure;
    private Integer seats;
}
