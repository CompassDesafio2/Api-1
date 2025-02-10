package com.compass;

import com.rafaelmachado.microservicea.MicroserviceAApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ContextConfiguration(classes = MicroserviceAApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	@Test
	void contextLoads() {
        assertDoesNotThrow(() -> MicroserviceAApplication.main(new String[]{}));
	}

}
