package com.example.alltest.booking.business;

class FlightDoesNotExistException extends RuntimeException {

  FlightDoesNotExistException(String flightNumber) {
    super(String.format("A flight with ID '%d' doesn't exist!", flightNumber));
  }

}
