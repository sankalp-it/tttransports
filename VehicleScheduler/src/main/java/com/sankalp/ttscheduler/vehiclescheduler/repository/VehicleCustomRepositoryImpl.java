/**
 * 
 */
package com.sankalp.ttscheduler.vehiclescheduler.repository;

import java.util.ArrayList;
import java.util.List;

import com.sankalp.ttscheduler.vehiclescheduler.entity.Vehicle;

/**
 * @author sankalp
 *
 */
public class VehicleCustomRepositoryImpl implements VehicleCustomRepository<Vehicle, String> {

	@Override
	public List<Vehicle> retrieveAllVehciles() {
		Vehicle vehicle1 = new Vehicle("123","Nissan", "Leaf", "1234567GH890",12,"Commercial");
		Vehicle vehicle2 = new Vehicle("124","Nissan", "Murano", "1234567GH896",8,"Commercial");
		Vehicle vehicle3 = new Vehicle("125","Tesla", "Model3", "1234567GH8908",5,"Commercial");
		Vehicle vehicle4 = new Vehicle("126","Chevrolet", "Corvette", "1234567GH886",2,"Commercial");
		List<Vehicle> dataInputList = new ArrayList<Vehicle>() ;
		dataInputList.add(vehicle1);
		dataInputList.add(vehicle2);
		dataInputList.add(vehicle3);
		dataInputList.add(vehicle4);
		return dataInputList;
	}
	
	

}
