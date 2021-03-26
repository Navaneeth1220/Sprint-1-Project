package com.cg.tms.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PaymentDetails {

	@Id
	@Column(unique = true)
	private int paymentId;
	private String paymentMode;
	private String bankName;
	@Column(unique = true)
	private long cardNo;
	@Column(unique = true)
	private double netAmount;
	private String paymentStatus;
	@Column(unique = true)
	private int userId;

	public PaymentDetails() {

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

	@Override
	public String toString() {

		return "PaymentDetails [paymentId=" + paymentId + ", paymentMode=" + paymentMode + ", bankName=" + bankName
				+ ", cardNo=" + cardNo + ", netAmount=" + netAmount + ", paymentStatus=" + paymentStatus + ", userId="
				+ userId + "]";
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentDetails other = (PaymentDetails) obj;
		if (paymentId != other.paymentId)
			return false;
		return true;
	}

	@Override
	public int hashCode() {

		return Objects.hash(paymentId);
	}

}
