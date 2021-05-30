package com.example.alltest.testing.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class UserResource {

  private final String name;

  private final String email;

  private LocalDateTime registrationDate;

  public UserResource(
          @JsonProperty("name") String name,
          @JsonProperty("email") String email) {
    this.name = name;
    this.email = email;
    this.registrationDate = null;
  }
}
