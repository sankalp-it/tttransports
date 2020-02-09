/**
 * 
 */
package com.sankalp.ttscheduler.vehiclescheduler.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sankalp
 *
 */
@ControllerAdvice
public class VehicleNotFoundAdvice {
	@ResponseBody
	@ExceptionHandler(VehicleNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String vehicleNotFoundHandler(VehicleNotFoundException ex) {
		return ex.getMessage();
	}

}
