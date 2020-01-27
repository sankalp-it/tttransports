/**
 * 
 */
package com.sankalp.ttscheduler.vehiclescheduler.repository;

import java.util.List;

import com.sankalp.ttscheduler.vehiclescheduler.bean.Vehicle;

/**
 * @author sankalp
 *
 */
public interface VehicleRepository {
	public int insertVehicles(List<Vehicle> vehiclesList);
	public List<Vehicle> retrieveAllVehicles();
	public List<Vehicle> findVehiclesByManufacturer(String manufacturer);

}
