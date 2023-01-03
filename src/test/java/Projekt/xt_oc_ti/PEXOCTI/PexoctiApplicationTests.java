package Projekt.xt_oc_ti.PEXOCTI;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class PexoctiApplicationTests {

	@Test
	void contextLoads() {
		String hello = "hello";
		assertEquals("hello",hello);


	}

	@Test
	@DisplayName("Backend Testing Test 1")
	void testTesting(){
		String hello = "hello";
		assertEquals("hello",hello);
	}

}
