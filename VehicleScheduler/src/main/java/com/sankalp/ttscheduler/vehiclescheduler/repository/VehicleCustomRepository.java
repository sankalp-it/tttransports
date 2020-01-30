package com.sankalp.ttscheduler.vehiclescheduler.repository;

import java.util.List;

public interface VehicleCustomRepository<Vehicle, String> {
	
	public List<Vehicle> retrieveAllVehciles();

}
