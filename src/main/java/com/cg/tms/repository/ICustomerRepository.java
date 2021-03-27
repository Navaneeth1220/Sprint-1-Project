package com.cg.tms.repository;

import java.util.List;

import com.cg.tms.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.tms.entities.Customer;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.exceptions.RouteNotFoundException;
import com.cg.tms.entities.Package;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByRoute(Route route);

    List<Customer> findByPack(Package pack);


}
