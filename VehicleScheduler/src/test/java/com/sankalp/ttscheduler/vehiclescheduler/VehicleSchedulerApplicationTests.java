package com.sankalp.ttscheduler.vehiclescheduler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

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
	@BeforeEach
	public void loadVehicles() {
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
	}
	
	@AfterEach
	void clearVehicles() {
		vehicleRepository.deleteAll();
	}

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
	void testVehicleRepoFindAll() {

		List<Vehicle> vehiclesList  = vehicleRepository.findAll();
		for (Vehicle veh: vehiclesList) {
			System.out.println(veh);
			
		}
		assertEquals(4, vehiclesList.size());

		
	}

	@Test
	void testVehicleRepoFindByManufacturer() {

		List<Vehicle> tVehiclesList = vehicleRepository.findByManufacturer("Nissan");

		for (Vehicle veh: tVehiclesList) {
			System.out.println(veh);
			
		}
		assertEquals(2, tVehiclesList.size());
		//clean up
		vehicleRepository.deleteAll();
	}
	
	@Test
	void testVehicleRepoFindByModel() {

		List<Vehicle> tVehiclesList = vehicleRepository.findByModel("Murano");

		for (Vehicle veh: tVehiclesList) {
			System.out.println(veh);
			
		}
		assertEquals(1, tVehiclesList.size());
		//clean up
//		vehicleRepository.deleteAll();
	}

	@Test
	void testVehicleRepoFindByVin() {
		Vehicle vehicle4 = new Vehicle("126","Chevrolet", "Corvette", "1234567GH886",2,"Commercial");
		Vehicle tVehicle = vehicleRepository.findByVin("1234567GH886");
		System.out.println(tVehicle);


		assertEquals(vehicle4, tVehicle);

	}
	
	@Test 
	void testSearchByMakeNModel() {
		Vehicle vehicle1 = new Vehicle("123","Nissan", "Leaf", "1234567GH890",12,"Commercial");

		List<Vehicle> resultsList = vehicleRepository.retrieveByMakeAndModel("Nissan", "Leaf");
		assertEquals(1, resultsList.size());
		assertEquals(resultsList.get(0),vehicle1);
	}
	
	@Test
	@Disabled
	void testVehicleBySearchCriteria() {
		List<Criteria> searchCriteriaList = new ArrayList<Criteria>();
		//Test1
		Criteria criteria = Criteria.where("manufacturer").is("Nissan");
		searchCriteriaList.add(criteria);
		List<Vehicle> vehiclesList = vehicleRepository.searchVehiclesByCriteria(searchCriteriaList);
		assertEquals(2, vehiclesList.size());
		System.out.println("\n Vehicles ::" + vehiclesList+"\n##################\n");
		
	}
	
	@Test 
	@Disabled
	void testSearchByManufacturerOrderDesc() {
		

		List<Vehicle> vehiclesList = vehicleRepository.findByManufacturerLikeOrderByModelDesc("N");
		for (Vehicle veh: vehiclesList) {
			System.out.println("########"+veh);
			
		}
		assertEquals(2, vehiclesList.size());
		
	}
	@Test 
	void testVehicleBySearchCriteriaAndSortResults() {
		List<Criteria> searchCriteriaList = new ArrayList<Criteria>();
		List<Order> orderList = new ArrayList<Order>();
		Criteria searchCriteria = new Criteria();
		searchCriteria = Criteria.where("manufacturer").regex("^Niss");
		searchCriteriaList.add(searchCriteria);
        Order modelOrder = new Order(Direction.DESC, "vin");
		orderList.add(modelOrder);
		List<Vehicle> vehiclesList = vehicleRepository.searchVehicles(searchCriteriaList,orderList);
		assertEquals(2, vehiclesList.size());
		System.out.println("\n Vehicles123 ::" + vehiclesList+"\n##################\n");
		
	}
}
