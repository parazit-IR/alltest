package com.example.alltest.flight.data;

import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class FlightService {

  public Optional<Flight> findFlight(String flightNumber) {
    return Optional.of(Flight.builder()
            .airline("Oceanic")
            .flightNumber("815")
            .build());
  }

}
