package com.example.alltest.testing;

import com.example.other.namespace.Foo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Import(com.example.other.namespace.Foo.class)
class SpringBootImportTest {

  @Autowired
  Foo foo;

  @Test
  void test() {
    assertThat(foo).isNotNull();
  }
}
