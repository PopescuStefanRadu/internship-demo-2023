package com.example.secondProject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles({"mailchimp", "gmail", "mailJet"})
class SecondProjectApplicationTests {

	@Test
	void contextLoads() {
	}

}
