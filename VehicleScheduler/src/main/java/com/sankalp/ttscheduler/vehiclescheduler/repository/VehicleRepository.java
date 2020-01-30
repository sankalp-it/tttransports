/**
 * 
 */
package com.sankalp.ttscheduler.vehiclescheduler.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sankalp.ttscheduler.vehiclescheduler.entity.Vehicle;

/**
 * @author sankalp
 *
 */
//@Repository
//public interface VehicleRepository extends MongoRepository<Vehicle, String>{
//	public List<Vehicle> retrieveAllVehicles();
//
//
//}

@Repository 
public interface VehicleRepository extends MongoRepository<Vehicle, String>, VehicleCustomRepository<Vehicle, String> {
	public List<Vehicle> findByManufacturer(String manufacturer);
	public List<Vehicle> findByModel(String model);
	public Vehicle findByVin(String vin);
	
}