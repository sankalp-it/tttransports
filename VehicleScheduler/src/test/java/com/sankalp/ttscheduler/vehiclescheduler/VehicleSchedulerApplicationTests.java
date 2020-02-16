package com.sankalp.ttscheduler.vehiclescheduler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.Criteria;

import com.sankalp.ttscheduler.vehiclescheduler.entity.Vehicle;
import com.sankalp.ttscheduler.vehiclescheduler.repository.VehicleRepository;
import com.sankalp.ttscheduler.vehiclescheduler.service.VehicleService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class VehicleSchedulerApplicationTests {
	
	@Autowired
	Vehicle vehicle;
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private Environment env;

	@Autowired
	//@Value("#{environment['JAVA_HOME']}")
	//@Value("${VEH_MONGO_DB_URL}")
	//private String dbUrl;
//	ApplicationContext ctx;
//	
	//private static Logger logger = LoggerFactory.getLogger(VehicleSchedulerApplicationTests.class);
	

	@BeforeEach
	public void loadVehicles() {
		System.out.println("DB URL :" + env.getProperty("VEH_MONGO_DB_URL"));
		//System.out.println("DB URL :" + dbUrl);
		Vehicle vehicle1 = new Vehicle("123","Nissan", "Leaf", "1234567GH890",12,"Commercial");
		Vehicle vehicle2 = new Vehicle("124","Nissan", "Murano", "1234567GH896",8,"Commercial");
		Vehicle vehicle3 = new Vehicle("125","Tesla", "Model3", "1234567GH8908",5,"Commercial");
		Vehicle vehicle4 = new Vehicle("126","Chevrolet", "Corvette", "1234567GH886",2,"Commercial");
		//Logger.info("{}", env.getProperty("app.name"));
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
	
//	@AfterAll
//	void loadDBData() {
//		Vehicle vehicle1 = new Vehicle("123","Nissan", "Leaf", "1234567GH890",12,"Commercial");
//		Vehicle vehicle2 = new Vehicle("124","Nissan", "Murano", "1234567GH896",8,"Commercial");
//		Vehicle vehicle3 = new Vehicle("125","Tesla", "Model3", "1234567GH8908",5,"Commercial");
//		Vehicle vehicle4 = new Vehicle("126","Chevrolet", "Corvette", "1234567GH886",2,"Commercial");
//		List<Vehicle> dataInputList = new ArrayList<Vehicle>() ;
//		dataInputList.add(vehicle1);
//		dataInputList.add(vehicle2);
//		dataInputList.add(vehicle3);
//		dataInputList.add(vehicle4);
//		vehicleRepository.saveAll(dataInputList);		
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

		List<Vehicle> vehiclesList  = vehicleRepository.findAll();
		for (Vehicle veh: vehiclesList) {
			System.out.println(veh);
			
		}
		assertEquals(4, vehiclesList.size());

		
	}

	@Test
	@Disabled
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
	@Disabled
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
	@Disabled
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
	
	@Test
	void testVehicleServiceFindAll() {
		List<Vehicle> vehiclesList = new ArrayList<Vehicle>();
		vehiclesList = vehicleService.findAll();
		assertNotNull(vehiclesList);
		assertEquals(4, vehiclesList.size());
		
	}
	
	@Test
	void testVehicleServiceDeleteById() {
		
		vehicleService.deleteById("126");
		List<Vehicle> vehiclesList = new ArrayList<Vehicle>();
		vehiclesList = vehicleService.findAll();
		assertNotNull(vehiclesList);
		assertEquals(3, vehiclesList.size());
		
	}
	
	
	@Test
	void testVehicleServiceInsertAll() {
		Vehicle vehicle1 = new Vehicle("213","Nissan", "Leaf", "1234567GH890",12,"Commercial");
		Vehicle vehicle2 = new Vehicle("214","Nissan", "Murano", "1234567GH896",8,"Commercial");
		Vehicle vehicle3 = new Vehicle("215","Tesla", "Model3", "1234567GH8908",5,"Commercial");
		Vehicle vehicle4 = new Vehicle("216","Chevrolet", "Corvette", "1234567GH886",2,"Commercial");
		List<Vehicle> dataInputList = new ArrayList<Vehicle>() ;
		dataInputList.add(vehicle1);
		dataInputList.add(vehicle2);
		dataInputList.add(vehicle3);
		dataInputList.add(vehicle4);
		vehicleService.insertAll(dataInputList);
		List<Vehicle> vehiclesList = new ArrayList<Vehicle>();
		vehiclesList = vehicleService.findAll();
		assertNotNull(vehiclesList);
		assertEquals(8, vehiclesList.size());
		
	}
	
	void testVehicleServiceUpdate() {
		//Optional<Vehicle> originalVehicle = vehicleRepository.findById("123");
		Vehicle vehicle1 = new Vehicle("Nissan", "Leaf", "1234567GH890",5,"Passenger");
		//Vehicle changedVehicle = vehicleRepository.save(vehicle1);
		Vehicle changedVehicle = vehicleService.updateVehicle(vehicle1,"123");
		assertNotNull(changedVehicle);
		assertEquals(vehicle1, changedVehicle);
		
		
	}
}
