/**
 * 
 */
package com.sankalp.ttscheduler.vehiclescheduler.entity;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
/**
 * @author sankalp
 *
 */
public class Vehicle {
	@Id
	private String id;
	private String manufacturer;
	private String model;
	private String vin;
	private int paxCapacity;
	private String typeOfPermit;
	
	public Vehicle() {
		
	}
	/**
	 * @param id
	 * @param manufacturer
	 * @param model
	 * @param vin
	 * @param paxCapacity
	 * @param typeOfPermit
	 */
	public Vehicle(String id, String manufacturer, String model, String vin, int paxCapacity, String typeOfPermit) {
		super();
		this.id = id;
		this.manufacturer = manufacturer;
		this.model = model;
		this.vin = vin;
		this.paxCapacity = paxCapacity;
		this.typeOfPermit = typeOfPermit;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}
	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the vin
	 */
	public String getVin() {
		return vin;
	}
	/**
	 * @param vin the vin to set
	 */
	public void setVin(String vin) {
		this.vin = vin;
	}
	/**
	 * @return the paxCapacity
	 */
	public int getPaxCapacity() {
		return paxCapacity;
	}
	/**
	 * @param paxCapacity the paxCapacity to set
	 */
	public void setPaxCapacity(int paxCapacity) {
		this.paxCapacity = paxCapacity;
	}
	/**
	 * @return the typeOfPermit
	 */
	public String getTypeOfPermit() {
		return typeOfPermit;
	}
	/**
	 * @param typeOfPermit the typeOfPermit to set
	 */
	public void setTypeOfPermit(String typeOfPermit) {
		this.typeOfPermit = typeOfPermit;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + paxCapacity;
		result = prime * result + ((typeOfPermit == null) ? 0 : typeOfPermit.hashCode());
		result = prime * result + ((vin == null) ? 0 : vin.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (paxCapacity != other.paxCapacity)
			return false;
		if (typeOfPermit == null) {
			if (other.typeOfPermit != null)
				return false;
		} else if (!typeOfPermit.equals(other.typeOfPermit))
			return false;
		if (vin == null) {
			if (other.vin != null)
				return false;
		} else if (!vin.equals(other.vin))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", manufacturer=" + manufacturer + ", model=" + model + ", vin=" + vin
				+ ", paxCapacity=" + paxCapacity + ", typeOfPermit=" + typeOfPermit + "]";
	}

}
