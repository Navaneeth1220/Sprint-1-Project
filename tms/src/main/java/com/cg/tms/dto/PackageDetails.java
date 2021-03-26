package com.cg.tms.dto;

import javax.persistence.OneToOne;

import com.cg.tms.entities.Route;

public class PackageDetails {

	private int packageId;
	private String packageName;
	private String packageDescription;
	private String packageType;
	private double packageCost;
	private int hotelId;
	private String hotelName;
	private String hotelType;
	private String hotelDescription;
	private String address;
	private double rent;
	private String hotelStatus;
	private int paymentId;
	private String paymentMode;
	private String bankName;
	private long cardNo;
	private double netAmount;
	private String paymentStatus;
	private int userId;
	private String ticketId;
	@OneToOne
	private Route route;
	private String ticketStatus;

	public int getPackageId() {

		return packageId;
	}

	public void setPackageId(int packageId) {

		this.packageId = packageId;
	}

	public String getPackageName() {

		return packageName;
	}

	public void setPackageName(String packageName) {

		this.packageName = packageName;
	}

	public String getPackageDescription() {

		return packageDescription;
	}

	public void setPackageDescription(String packageDescription) {

		this.packageDescription = packageDescription;
	}

	public String getPackageType() {

		return packageType;
	}

	public void setPackageType(String packageType) {

		this.packageType = packageType;
	}

	public double getPackageCost() {

		return packageCost;
	}

	public void setPackageCost(double packageCost) {

		this.packageCost = packageCost;
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

	public String getHotelStatus() {

		return hotelStatus;
	}

	public void setHotelStatus(String hotelStatus) {

		this.hotelStatus = hotelStatus;
	}

	public int getPaymentId() {

		return paymentId;
	}

	public void setPaymentId(int paymentId) {

		this.paymentId = paymentId;
	}

	public String getPaymentMode() {

		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {

		this.paymentMode = paymentMode;
	}

	public String getBankName() {

		return bankName;
	}

	public void setBankName(String bankName) {

		this.bankName = bankName;
	}

	public long getCardNo() {

		return cardNo;
	}

	public void setCardNo(long cardNo) {

		this.cardNo = cardNo;
	}

	public double getNetAmount() {

		return netAmount;
	}

	public void setNetAmount(double netAmount) {

		this.netAmount = netAmount;
	}

	public String getPaymentStatus() {

		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {

		this.paymentStatus = paymentStatus;
	}

	public int getUserId() {

		return userId;
	}

	public void setUserId(int userId) {

		this.userId = userId;
	}

	public String getTicketId() {

		return ticketId;
	}

	public void setTicketId(String ticketId) {

		this.ticketId = ticketId;
	}

	public Route getRoute() {

		return route;
	}

	public void setRoute(Route route) {

		this.route = route;
	}

	public String getTicketStatus() {

		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {

		this.ticketStatus = ticketStatus;
	}

}
