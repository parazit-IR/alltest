package com.example.alltest.testing;

import com.example.alltest.testing.domain.RegisterUseCase;
import com.example.alltest.testing.domain.SaveUserPort;
import com.example.alltest.testing.domain.SendMailPort;
import com.example.alltest.testing.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegisterUseCaseTest {

  @Mock
  private SaveUserPort saveUserPort;

  @Mock
  private SendMailPort sendMailPort;

  private RegisterUseCase registerUseCase;

  @BeforeEach
  void initUseCase() {
    registerUseCase = new RegisterUseCase(saveUserPort, sendMailPort);
  }

  @Test
  void savedUserHasRegistrationDate() {
    User user = new User("zaphod", "zaphod@mail.com");
    when(saveUserPort.saveUser(any(User.class))).thenReturn(42L);
    Long userId = registerUseCase.registerUser(user, false);
    assertThat(userId).isNotNull();
  }

}