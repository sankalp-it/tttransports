/**
 * 
 */
package com.sankalp.ttscheduler.vehiclescheduler.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.sankalp.ttscheduler.vehiclescheduler.entity.Vehicle;

/**
 * @author sankalp
 *
 */
public class VehicleCustomRepositoryImpl implements VehicleCustomRepository<Vehicle, String> {
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<Vehicle> retrieveAllVehicles() {
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

	@Override
	public List<Vehicle> retrieveByMakeAndModel(String make, String model) {

		List<Vehicle> vehiclesList = new ArrayList<Vehicle>();

		Query query = new Query();
		query.addCriteria(Criteria.where("manufacturer").is("Nissan")).addCriteria(Criteria.where("model").is("Leaf"));
		vehiclesList = mongoTemplate.find(query, Vehicle.class);
		return vehiclesList;
	}

	@Override
	public List<Vehicle> searchVehiclesByCriteria(List<Criteria> searchCriteriaList) {

		List<Vehicle> vehiclesList = new ArrayList<Vehicle>();

		Query query = new Query();
		for (Criteria tCriteria : searchCriteriaList) {
			query.addCriteria(tCriteria);
		}
		vehiclesList = mongoTemplate.find(query, Vehicle.class);
		return vehiclesList;
	}

	@Override
	public List<Vehicle> findByManufacturerLikeOrderByModelDesc(String manufacturer) {
		List<Vehicle> vehiclesList = new ArrayList<Vehicle>();
		Criteria searchCriteria = new Criteria();
		searchCriteria = Criteria.where("manufacturer").regex("^" + manufacturer);
		//Sort sort = new Sort(Sort.Direction.DESC,new ArrayList<String>() {"make"});
		Query query = new Query();
        query.addCriteria(searchCriteria);
        //Sort sort2 = new Sort(Sort.Direction.DESC, null));
        ///query.with(new Sort()
        Order modelOrder = new Order(Direction.DESC, "model");
        //query.with(new Sort(new ArrayList<Order>() {nameOrder}));
        query.with(Sort.by(modelOrder));
		vehiclesList = mongoTemplate.find(query, Vehicle.class);
		return vehiclesList;
	}

	@Override
	public List<Vehicle> searchVehicles(List<Criteria> searchCriteriaList, List<Order> orderList) {
		List<Vehicle> vehiclesList = new ArrayList<Vehicle>();
		Query query = new Query();
		for (Criteria criteria: searchCriteriaList) {
			query.addCriteria(criteria);
		}
		for (Order order: orderList) {
			query.with(Sort.by(order));
		}
		vehiclesList = mongoTemplate.find(query, Vehicle.class);
		return vehiclesList;
	}
	


	

}
