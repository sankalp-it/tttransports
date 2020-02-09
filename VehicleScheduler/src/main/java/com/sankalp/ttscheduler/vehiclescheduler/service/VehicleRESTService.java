/**
 * 
 */
package com.sankalp.ttscheduler.vehiclescheduler.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sankalp.ttscheduler.vehiclescheduler.entity.Vehicle;
import com.sankalp.ttscheduler.vehiclescheduler.exceptions.VehicleNotFoundException;
import com.sankalp.ttscheduler.vehiclescheduler.repository.VehicleRepository;

/**
 * @author sankalp
 *
 */
@RestController

public class VehicleRESTService implements VehicleService {
	@Autowired
	VehicleRepository vehicleRepository;

	@Override
	@GetMapping("/vehicles")
	public List<Vehicle> findAll() {
		List<Vehicle> vehiclesList = new ArrayList<Vehicle>();
		vehiclesList = vehicleRepository.findAll();
		return vehiclesList;
	}
	@Override
	@GetMapping("/vehicles/{id}")
	public Vehicle findById(@PathVariable String id) {
		

		
		return vehicleRepository.findById(id)
				.orElseThrow(() -> new VehicleNotFoundException(id));

	}

	@Override
	@DeleteMapping("/vehicles/{id}")
	public void deleteById(@PathVariable String id) {
		vehicleRepository.deleteById(id);
	}

	@Override
	@PostMapping("/vehicles")
	public void insertAll(@RequestBody List<Vehicle> vehiclesList) {
		vehicleRepository.insert(vehiclesList);
		
	}
	
	@Override
	@PutMapping("/vehicles/{id}")
	public Vehicle updateVehicle(@RequestBody Vehicle newVehicle, @PathVariable String id) {
		Optional<Vehicle> vehicle = vehicleRepository.findById(id);
		Vehicle modVehicle;
		
		if (vehicle.isPresent()) {
			Vehicle originalVehicle = vehicle.get();
			originalVehicle.setManufacturer(newVehicle.getManufacturer());
			originalVehicle.setModel(newVehicle.getModel());
			originalVehicle.setPaxCapacity(newVehicle.getPaxCapacity());
			originalVehicle.setTypeOfPermit(newVehicle.getTypeOfPermit());
			originalVehicle.setVin(newVehicle.getVin());
			modVehicle = vehicleRepository.save(originalVehicle);
			
		} else {
			newVehicle.setId(id);
			modVehicle = vehicleRepository.save(newVehicle);
		}
		return modVehicle;
//		return vehicleRepository.findById(id).get()
//				.map(vehicle -> {
//					vehicle.setManufacturer(newVehicle.getManufacturer());
//					vehicle.setModel(newVehicle.getModel());
//				})
//				.orElseGet(() -> {
//					newVehicle.setId(id);
//				});
//				return vehicleRepository.save(newVehicle);

	}

}
