package com.cg.tms.service;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Executable;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import com.cg.tms.service.*;
import com.cg.tms.entities.Customer;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.repository.ICustomerRepository;
import com.cg.tms.exceptions.*;
@ExtendWith(MockitoExtension.class)
class CustomerServiceImplementationTest {
@Mock
ICustomerRepository repo;
 @Spy
 @InjectMocks
 CustomerServiceImplementation service;
 
 //Success Test case
 
@Test
void test_1() {
	String customerName="Alifia";
	String customerAddress="Estancia";
	int customerId=1;
	
	Customer customer=new Customer();
	customer.setAddress(customerAddress);
	customer.setCustomerName(customerName);
	customer.setCustomerId(customerId);
	Mockito.when(repo.save(customer)).thenReturn(customer);
	Customer result = service.addCustomer(customer);
	
	Assertions.assertNotNull(result);
	Assertions.assertEquals(customerName,result.getCustomerName());
	Assertions.assertEquals(customerAddress,result.getAddress());
	Assertions.assertEquals(customerId,result.getCustomerId());
}

//Id cannot be Negative

@Test
void test_2() {
	int customerId=-1;
	Customer customer=new Customer();
	customer.setAddress("Estancia");
	customer.setCustomerName("Alifia");
	doThrow(InvalidIdException.class).when(service).validateId(customerId);
	Executable executable =()->service.addCustomer(customer);
	Assertions.assertThrows(InvalidIdException.class, executable);
	
}
 //Customer Found
@Test
void test_3() {
	int customerid=1;
	Customer customer=mock(Customer.class);
	Optional<Customer> optional= Optional.of(customer);
	when(repo.findById(customerid)).thenReturn(optional);
	Customer result= service.viewCustomer(customerid);
	Assertions.assertEquals(result,customer);
	
	}
 //Customer Not Found
@Test
void test_4(){
	
	int customerid=11;
Optional<Customer> optional= Optional.empty();
when(repo.findById(customerid)).thenReturn(optional);
Executable executable =()->service.viewCustomer(customerId);
Assertions.assertThrows(CustomerNotFoundException.class,executable);
}
}
