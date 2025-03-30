package com.siim.cgi;

import java.time.LocalDateTime;

public record Flight(
        Integer id,
        String origin,
        String destination,
        LocalDateTime departure,
        Integer seats
) {
}
