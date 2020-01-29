package com.sankalp.ttscheduler.vehiclescheduler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sankalp.ttscheduler.vehiclescheduler.entity.Vehicle;
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
	@Disabled
	void testInsertVehicleSuccess() {
		Vehicle vehicle = new Vehicle("123","Nissan", "Leaf", "1234567GH890",12,"Commercial");
		List<Vehicle> vehiclesList = new ArrayList<Vehicle>();
		vehiclesList.add(vehicle);
		Vehicle tVehicle = vehicleRepository.save(vehicle);
		System.out.println(tVehicle);
		assertEquals(tVehicle,vehicle);
		//clean up
		vehicleRepository.delete(vehicle);
		
	}
	@Test
	@Disabled
	void testVehicleRepoFindAll() {
		Vehicle vehicle = new Vehicle("123","Nissan", "Leaf", "1234567GH890",12,"Commercial");

		Vehicle tVehicle = vehicleRepository.save(vehicle);
		List<Vehicle> vehiclesList  = vehicleRepository.findAll();
		for (Vehicle veh: vehiclesList) {
			System.out.println(veh);
			
		}
		assertEquals(1, vehiclesList.size());
		//clean up
		vehicleRepository.delete(vehicle);
		
	}

	@Test
	@Disabled
	void testVehicleRepoFindByManufacturer() {
		Vehicle vehicle1 = new Vehicle("123","Nissan", "Leaf", "1234567GH890",12,"Commercial");
		Vehicle vehicle2 = new Vehicle("124","Nissan", "Murano", "1234567GH896",8,"Commercial");
		Vehicle vehicle3 = new Vehicle("125","Tesla", "Model3", "1234567GH8908",5,"Commercial");
		Vehicle vehicle4 = new Vehicle("126","Chevrolet", "Corvette", "1234567GH886",2,"Commercial");
		List<Vehicle> dataInputList = new ArrayList<Vehicle>() ;
		dataInputList.add(vehicle1);
		dataInputList.add(vehicle2);
		dataInputList.add(vehicle3);
		dataInputList.add(vehicle4);
		vehicleRepository.saveAll(dataInputList);
		List<Vehicle> tVehiclesList = vehicleRepository.findByManufacturer("Nissan");

		for (Vehicle veh: tVehiclesList) {
			System.out.println(veh);
			
		}
		assertEquals(2, tVehiclesList.size());
		//clean up
		vehicleRepository.deleteAll();
	}
	
	@Test
	@Disabled
	void testVehicleRepoFindByModel() {
		Vehicle vehicle1 = new Vehicle("123","Nissan", "Leaf", "1234567GH890",12,"Commercial");
		Vehicle vehicle2 = new Vehicle("124","Nissan", "Murano", "1234567GH896",8,"Commercial");
		Vehicle vehicle3 = new Vehicle("125","Tesla", "Model3", "1234567GH8908",5,"Commercial");
		Vehicle vehicle4 = new Vehicle("126","Chevrolet", "Corvette", "1234567GH886",2,"Commercial");
		List<Vehicle> dataInputList = new ArrayList<Vehicle>() ;
		dataInputList.add(vehicle1);
		dataInputList.add(vehicle2);
		dataInputList.add(vehicle3);
		dataInputList.add(vehicle4);
		vehicleRepository.saveAll(dataInputList);
		List<Vehicle> tVehiclesList = vehicleRepository.findByModel("Murano");

		for (Vehicle veh: tVehiclesList) {
			System.out.println(veh);
			
		}
		assertEquals(1, tVehiclesList.size());
		//clean up
		vehicleRepository.deleteAll();
	}

	@Test
	void testVehicleRepoFindByVin() {
		Vehicle vehicle1 = new Vehicle("123","Nissan", "Leaf", "1234567GH890",12,"Commercial");
		Vehicle vehicle2 = new Vehicle("124","Nissan", "Murano", "1234567GH896",8,"Commercial");
		Vehicle vehicle3 = new Vehicle("125","Tesla", "Model3", "1234567GH8908",5,"Commercial");
		Vehicle vehicle4 = new Vehicle("126","Chevrolet", "Corvette", "1234567GH886",2,"Commercial");
		List<Vehicle> dataInputList = new ArrayList<Vehicle>() ;
		dataInputList.add(vehicle1);
		dataInputList.add(vehicle2);
		dataInputList.add(vehicle3);
		dataInputList.add(vehicle4);
		vehicleRepository.saveAll(dataInputList);
		Vehicle tVehicle = vehicleRepository.findByVin("1234567GH886");
		System.out.println(tVehicle);

		assertEquals(vehicle4, tVehicle);
		//clean up
		vehicleRepository.deleteAll();
	}
}
