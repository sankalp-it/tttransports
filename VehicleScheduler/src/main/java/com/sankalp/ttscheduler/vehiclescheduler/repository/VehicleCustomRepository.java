package com.sankalp.ttscheduler.vehiclescheduler.repository;

import java.util.List;

import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.Criteria;

import com.sankalp.ttscheduler.vehiclescheduler.entity.Vehicle;

public interface VehicleCustomRepository<Vehicle, String> {
	
	public List<Vehicle> retrieveAllVehicles();
	public List<Vehicle> retrieveByMakeAndModel(String make, String model) ;
//	public List<Vehicle> findByManufacturerLikeOrderByMakeDesc(String make);
	public List<Vehicle> searchVehiclesByCriteria(List<Criteria> searchCriteriaList);
	public List<Vehicle> findByManufacturerLikeOrderByModelDesc(String manufacturer);
	public List<Vehicle> searchVehicles(List<Criteria> searchCriteriaList, List<Order> orderList);

}
