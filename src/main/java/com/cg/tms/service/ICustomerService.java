package com.cg.tms.service;

import java.util.List;

import com.cg.tms.entities.Customer;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.exceptions.RouteNotFoundException;

public interface ICustomerService {

    Customer addCustomer(Customer customer);

    Customer updateCustomer(Customer customer) throws CustomerNotFoundException;

    Customer deleteCustomer(Customer customer) throws CustomerNotFoundException;

    Customer viewCustomer(int custid) throws CustomerNotFoundException;

    List<Customer> viewAllCustomers(int packageId) throws PackageNotFoundException;

    List<Customer> viewCustomerList(int routeId) throws RouteNotFoundException;


}
