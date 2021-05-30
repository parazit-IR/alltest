package com.example.alltest.booking;

import com.example.alltest.booking.business.BookingService;
import com.example.alltest.booking.data.BookingRepository;
import com.example.alltest.customer.CustomerConfiguration;
import com.example.alltest.customer.data.CustomerRepository;
import com.example.alltest.flight.FlightConfiguration;
import com.example.alltest.flight.data.FlightService;
import org.springframework.context.annotation.*;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Component;

@Configuration
@Import({CustomerConfiguration.class, FlightConfiguration.class})
@ComponentScan
public class BookingConfiguration {

//  @Bean
//  public BookingService bookingService(
//          BookingRepository bookingRepository,
//          CustomerRepository customerRepository,
//          FlightService flightService) {
//    return new BookingService(bookingRepository, customerRepository, flightService);
//  }

}
