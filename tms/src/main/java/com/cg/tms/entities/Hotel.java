package com.cg.tms.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hotel {


	@Id
	private int hotelId;
	private String hotelName;
	private String hotelType;
	private String hotelDescription;
	private String address;
	private double rent;
	private String status;

	public Hotel() {

	}

	public int getHotelId() {

		return hotelId;
	}

	public void setHotelId(int hotelId) {

		this.hotelId = hotelId;
	}

	public String getHotelName() {

		return hotelName;
	}

	public void setHotelName(String hotelName) {

		this.hotelName = hotelName;
	}

	public String getHotelType() {

		return hotelType;
	}

	public void setHotelType(String hotelType) {

		this.hotelType = hotelType;
	}

	public String getHotelDescription() {

		return hotelDescription;
	}

	public void setHotelDescription(String hotelDescription) {

		this.hotelDescription = hotelDescription;
	}

	public String getAddress() {

		return address;
	}

	public void setAddress(String address) {

		this.address = address;
	}

	public double getRent() {

		return rent;
	}

	public void setRent(double rent) {

		this.rent = rent;
	}

	public String getStatus() {

		return status;
	}

	public void setStatus(String status) {

		this.status = status;
	}

	@Override
	public String toString() {

		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelType=" + hotelType
				+ ", hotelDescription=" + hotelDescription + ", address=" + address + ", rent=" + rent + ", status="
				+ status + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		if (hotelId != other.hotelId)
			return false;
		return true;
	}

	@Override
	public int hashCode() {

		return Objects.hash(hotelId);
	}

}

