package com.sankalp.ttscheduler.driverscheduler;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
@TestInstance( Lifecycle.PER_CLASS)
class DriverSchedulerApplicationTests {
	ApplicationContext ctx;
	
	@BeforeAll 
	void loadContext() {
		ctx = SpringApplication.run(DriverSchedulerApplicationTests.class, new String[] {});
	}

	@Test
	void contextLoads() {
		assertNotNull(ctx);
	}
	
	@Test
	void testGetAllSchedules() {
		
	}

}
