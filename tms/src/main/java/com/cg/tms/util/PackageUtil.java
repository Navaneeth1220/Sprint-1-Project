package com.cg.tms.util;

import org.springframework.stereotype.Component;
import com.cg.tms.dto.*;
import com.cg.tms.entities.*;
import com.cg.tms.entities.Package;
import java.util.*;

@Component
public class PackageUtil {

	public PackageDetails toDetailPackage(Package pack) {

		PackageDetails packageDetails = new PackageDetails();
		packageDetails.setPackageId(pack.getPackageId());
		packageDetails.setPackageName(pack.getPackageName());
		packageDetails.setPackageDescription(pack.getPackageDescription());
		packageDetails.setPackageType(pack.getPackageType());
		packageDetails.setPackageCost(pack.getPackageCost());

		Hotel hotel = pack.getHotel();
		if (hotel != null) {

			packageDetails.setHotelId(hotel.getHotelId());
			packageDetails.setHotelName(hotel.getHotelName());
			packageDetails.setHotelDescription(hotel.getHotelDescription());
			packageDetails.setHotelType(hotel.getHotelType());
			packageDetails.setAddress(hotel.getAddress());
			packageDetails.setRent(hotel.getRent());
			packageDetails.setHotelStatus(hotel.getStatus());

		}

		PaymentDetails payment = pack.getPayment();
		if (payment != null) {

			packageDetails.setPaymentId(payment.getPaymentId());
			packageDetails.setPaymentMode(payment.getPaymentMode());
			packageDetails.setBankName(payment.getBankName());
			packageDetails.setCardNo(payment.getCardNo());
			packageDetails.setNetAmount(payment.getNetAmount());
			packageDetails.setPaymentStatus(payment.getPaymentStatus());
			packageDetails.setUserId(payment.getUserId());

		}

		TicketDetails ticket = pack.getTicket();
		if (ticket != null) {

			packageDetails.setTicketId(ticket.getTicketId());
			packageDetails.setRoute(ticket.getRoute());
			packageDetails.setTicketStatus(ticket.getStatus());
		}

		return packageDetails;

	}

	public List<PackageDetails> toDetailsPackages(Collection<Package> packages) {
		
		List<PackageDetails> packs = new ArrayList<>();
		for (Package pack : packages) {

			PackageDetails packageDetails = toDetailPackage(pack);
			packs.add(packageDetails);
		}

		return packs;

	}

}
