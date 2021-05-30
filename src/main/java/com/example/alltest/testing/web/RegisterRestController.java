package com.example.alltest.testing.web;

import com.example.alltest.testing.domain.RegisterUseCase;
import com.example.alltest.testing.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
class RegisterRestController {

  private final RegisterUseCase registerUseCase;

  @PostMapping("/forums/{forumId}/register")
  UserResource register(
          @PathVariable("forumId") Long forumId,
          @RequestBody UserResource userResource,
          @RequestParam("sendWelcomeMail") boolean sendWelcomeMail) {

    User user = new User(
            userResource.getName(),
            userResource.getEmail());
    Long userId = registerUseCase.registerUser(user, sendWelcomeMail);

    return new UserResource(
            user.getName(),
            user.getEmail());
  }

}
