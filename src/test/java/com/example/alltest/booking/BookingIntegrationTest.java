package com.example.alltest.booking;

import com.example.alltest.customer.data.Customer;
import com.example.alltest.customer.data.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class BookingIntegrationTest {

  @Autowired
  private WebApplicationContext applicationContext;

  @Autowired
  private CustomerRepository customerRepository;

  private MockMvc mockMvc;

  @BeforeEach
  void setup() {
    this.mockMvc = MockMvcBuilders
            .webAppContextSetup(applicationContext)
            .build();
  }

  @Test
  void bookFlightReturnsHttpStatusOk() throws Exception {
    this.customerRepository.save(Customer.builder()
            .name("Hurley")
            .build());

    this.mockMvc.perform(
            post("/booking")
                    .param("customerId", "1")
                    .param("flightNumber", "Oceanic 815"))
            .andExpect(status().isOk());
  }

}
