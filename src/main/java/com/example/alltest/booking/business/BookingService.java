package com.example.alltest.booking.business;


import com.example.alltest.booking.data.Booking;
import com.example.alltest.booking.data.BookingRepository;
import com.example.alltest.customer.data.Customer;
import com.example.alltest.customer.data.CustomerRepository;
import com.example.alltest.flight.data.Flight;
import com.example.alltest.flight.data.FlightService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BookingService {

  private BookingRepository bookingRepository;

  private CustomerRepository customerRepository;

  FlightService flightService;

  public BookingService(
          BookingRepository bookingRepository,
          CustomerRepository customerRepository,
          FlightService flightService) {
    this.bookingRepository = bookingRepository;
    this.customerRepository = customerRepository;
    this.flightService = flightService;
  }

  /**
   * Books the given flight for the given customer.
   */
  public Booking bookFlight(Long customerId, String flightNumber) {

    Optional<Customer> customer = customerRepository.findById(customerId);
    if (!customer.isPresent()) {
      throw new CustomerDoesNotExistException(customerId);
    }

    Optional<Flight> flight = flightService.findFlight(flightNumber);
    if (!flight.isPresent()) {
      throw new FlightDoesNotExistException(flightNumber);
    }

    Booking booking = Booking.builder()
            .customer(customer.get())
            .flightNumber(flight.get().getFlightNumber())
            .build();

    return this.bookingRepository.save(booking);
  }

}
