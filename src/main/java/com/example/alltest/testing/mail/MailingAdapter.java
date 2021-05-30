package com.example.alltest.testing.mail;

import com.example.alltest.testing.domain.SendMailPort;
import org.springframework.stereotype.Component;

@Component
public class MailingAdapter implements SendMailPort {

  @Override
  public void sendMail(String subject, String text) {
      // sending a mail...
  }

}
