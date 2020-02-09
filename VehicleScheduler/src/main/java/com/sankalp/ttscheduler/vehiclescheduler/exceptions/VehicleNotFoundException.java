/**
 * 
 */
package com.sankalp.ttscheduler.vehiclescheduler.exceptions;

/**
 * @author sankalp
 *
 */
public class VehicleNotFoundException extends RuntimeException {
	public VehicleNotFoundException(String id) {
		super("Could not find vehicle " + id);
	}

}
