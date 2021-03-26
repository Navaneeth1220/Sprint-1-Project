package com.cg.tms.ui;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.tms.service.*;
import com.cg.tms.exceptions.*;
import com.cg.tms.entities.*;
import com.cg.tms.entities.Package;

@Component
public class PackageUI {

	@Autowired
	private IPackageService packageService;

	public void start() {

		try {

			System.out.println("Adding a new Package ");
			Package pack1 = new Package();
			pack1.setPackageId(1);
			pack1.setPackageName("Local");
			pack1.setPackageDescription("diverse and cultural");
			pack1.setPackageType("Normal");
			pack1.setPackageCost(8500.0);
			Package addPackage1 = packageService.addPackage(pack1);
			displayPackage(addPackage1);

			Package pack2 = new Package();
			pack2.setPackageId(2);
			pack2.setPackageName("International");
			pack2.setPackageDescription("challenging adventure");
			pack2.setPackageType("Ultra");
			pack2.setPackageCost(10500.0);
			Package addPackage2 = packageService.addPackage(pack2);
			displayPackage(addPackage2);

			Package pack3 = new Package();
			pack3.setPackageId(3);
			pack3.setPackageName("Holiday");
			pack3.setPackageDescription("peace and relaxation");
			pack3.setPackageType("Deluxe");
			pack3.setPackageCost(12500.0);
			Package addPackage3 = packageService.addPackage(pack3);
			displayPackage(addPackage3);

			System.out.println("Deleting a package ");
			Package deletePackage = packageService.deletePackage(pack3.getPackageId());
			displayPackage(deletePackage);

			System.out.println("Searching a package ");
			Package searchPackage = packageService.searchPackage(pack1.getPackageId());
			displayPackage(searchPackage);

			System.out.println("Viewing all packages ");
			List<Package> viewAllPackages = packageService.viewAllPackages();
			displayAllPackages(viewAllPackages);

		} catch (PackageNotFoundException e) {

			System.out.println("Package not found");
			e.printStackTrace();

		} catch (InvalidPackageIdException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (InvalidPackageNameException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (InvalidPackageDescriptionException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (InvalidPackageTypeException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println("Parent exception");
			e.printStackTrace();
		}

	}

	public void displayPackage(Package pack) {

		Hotel hotel = pack.getHotel();
		TicketDetails ticket = pack.getTicket();
		PaymentDetails payment = pack.getPayment();
		System.out.println("packageId: " + pack.getPackageId() + " packageName: " + pack.getPackageName()
				+ " packageDescription: " + pack.getPackageDescription() + " packageType: " + pack.getPackageType()
				+ " packageCost: " + pack.getPackageCost() + " hotelId: " + hotel.getHotelId() + " hotelName: "
				+ hotel.getHotelName() + " hotelDescription: " + hotel.getHotelDescription() + " hotelType: "
				+ hotel.getHotelType() + " hotel address: " + hotel.getAddress() + " hotel rent: " + hotel.getRent()
				+ " hotel status: " + hotel.getStatus() + " ticketId: " + ticket.getTicketId() + " ticket with route: "
				+ ticket.getRoute() + " ticket status: " + ticket.getStatus() + " paymentId: " + payment.getPaymentId()
				+ " paymentMode: " + payment.getPaymentMode() + " payment bankName: " + payment.getBankName()
				+ " payment cardNumber: " + payment.getCardNo() + " payment netAmount: " + payment.getNetAmount()
				+ " paymentStatus: " + payment.getPaymentStatus() + " payment userId: " + payment.getUserId());

	}

	public void displayAllPackages(Collection<Package> packs) {

		for (Package pack : packs) {

			displayPackage(pack);
		}
	}

}
