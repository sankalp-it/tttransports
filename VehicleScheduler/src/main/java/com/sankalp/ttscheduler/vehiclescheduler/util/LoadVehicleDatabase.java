/**
 * 
 */
package com.sankalp.ttscheduler.vehiclescheduler.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sankalp.ttscheduler.vehiclescheduler.entity.Vehicle;
import com.sankalp.ttscheduler.vehiclescheduler.repository.VehicleRepository;

/**
 * @author sankalp
 *
 */
import lombok.extern.slf4j.Slf4j;
@Configuration
@Slf4j
public class LoadVehicleDatabase {
	@Bean
	CommandLineRunner initDatabase(VehicleRepository repository) {
		return args -> {
			Vehicle vehicle1 = new Vehicle("123","Nissan", "Leaf", "1234567GH890",12,"Commercial");
			Vehicle vehicle2 = new Vehicle("124","Nissan", "Murano", "1234567GH896",8,"Commercial");
			Vehicle vehicle3 = new Vehicle("125","Tesla", "Model3", "1234567GH8908",5,"Commercial");
			Vehicle vehicle4 = new Vehicle("126","Chevrolet", "Corvette", "1234567GH886",2,"Commercial");
			List<Vehicle> dataInputList = new ArrayList<Vehicle>() ;
			dataInputList.add(vehicle1);
			dataInputList.add(vehicle2);
			dataInputList.add(vehicle3);
			dataInputList.add(vehicle4);
			repository.saveAll(dataInputList);	
		};
	}

}
