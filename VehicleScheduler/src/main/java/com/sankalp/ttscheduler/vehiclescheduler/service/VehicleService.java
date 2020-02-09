/**
 * 
 */
package com.sankalp.ttscheduler.vehiclescheduler.service;

import java.util.List;
import java.util.Optional;

import com.sankalp.ttscheduler.vehiclescheduler.entity.Vehicle;

/**
 * @author sankalp
 *
 */
public interface VehicleService {

	public List<Vehicle> findAll() ;
	
	public Vehicle findById(String id);

	public void deleteById(String id);

	public void insertAll(List<Vehicle> vehiclesList);

	public Vehicle updateVehicle(Vehicle vehicle1, String id);
	

}
