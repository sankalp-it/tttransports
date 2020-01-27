/**
 * 
 */
package com.sankalp.ttscheduler.vehiclescheduler.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sankalp.ttscheduler.vehiclescheduler.bean.Vehicle;

/**
 * @author sankalp
 *
 */
@Component
public class VehicleRESTService implements VehicleService {

	@Override
	public List<Vehicle> findAll() {
		List<Vehicle> vehiclesList = new ArrayList<Vehicle>();
		
		return vehiclesList;
	}

}
