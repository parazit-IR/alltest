package com.example.alltest.customer;

import com.example.alltest.booking.business.BookingService;
import com.example.alltest.booking.data.BookingRepository;
import com.example.alltest.booking.web.BookingController;
import com.example.alltest.customer.business.CustomerService;
import com.example.alltest.customer.data.CustomerRepository;
import com.example.alltest.customer.web.CustomerController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CustomerModuleTest {

  @Autowired(required = false)
  private BookingController bookingController;
  @Autowired(required = false)
  private BookingService bookingService;
  @Autowired(required = false)
  private BookingRepository bookingRepository;

  @Autowired
  private CustomerController customerController;
  @Autowired
  private CustomerService customerService;
  @Autowired
  private CustomerRepository customerRepository;

  @Test
  void onlyCustomerModuleIsLoaded() {
    assertThat(customerController).isNotNull();
    assertThat(customerService).isNotNull();
    assertThat(customerRepository).isNotNull();
    assertThat(bookingController).isNull();
    assertThat(bookingService).isNull();
    assertThat(bookingRepository).isNull();
  }

}