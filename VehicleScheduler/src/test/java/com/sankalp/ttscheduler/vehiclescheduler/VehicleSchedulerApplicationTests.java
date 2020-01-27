package com.sankalp.ttscheduler.vehiclescheduler;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sankalp.ttscheduler.vehiclescheduler.bean.Vehicle;
import com.sankalp.ttscheduler.vehiclescheduler.repository.VehicleRepository;
import com.sankalp.ttscheduler.vehiclescheduler.service.VehicleService;

@SpringBootTest
class VehicleSchedulerApplicationTests {
	
	@Autowired
	Vehicle vehicle;
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private VehicleRepository vehicleRepository;
//	ApplicationContext ctx;
//	
//	@BeforeAll
//	void loadContext() {
//		ctx = SpringApplication.run(VehicleSchedulerApplication.class, new String[] {});
//	}

	@Test
	void contextLoads() {
	}
	
	@Test
	void testVehicleAutowire () {
		assertNotNull(vehicle);
	}
	
	@Test 
	void testVehicleServiceFindAllNotNull() {
		List<Vehicle> vehiclesList = vehicleService.findAll();
		assertNotNull(vehiclesList);
	}
	
	@Test
	void testInsertVehicleSuccess() {
		Vehicle vehicle = new Vehicle(123,"Nissan", "Leaf", "1234567GH890",12,"Commercial");
		List<Vehicle> vehiclesList = new ArrayList<Vehicle>();
		vehiclesList.add(vehicle);
		int rows = vehicleRepository.insertVehicles(vehiclesList);
		assertNotEquals(0, rows);
		
	}


}
