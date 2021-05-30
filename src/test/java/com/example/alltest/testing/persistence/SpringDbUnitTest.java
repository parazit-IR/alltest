package com.example.alltest.testing.persistence;


import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static org.assertj.core.api.Java6Assertions.assertThat;


@DataJpaTest
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=create-drop",
        "spring.liquibase.enabled=false",
        "spring.flyway.enabled=false"
})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class
})
class SpringDbUnitTest {

  @Autowired
  private UserRepository userRepository;

  @Test
  @DatabaseSetup("createUser.xml")
  void whenInitializedByDbUnit_thenFindsByName() {
    UserEntity user = userRepository.findByName("Zaphod Beeblebrox");
    assertThat(user).isNotNull();
  }

}