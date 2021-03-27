package com.cg.tms.service;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
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

    /**
     * Scenario:  Customer added successfully
     * testing CustomerService#addCustomer
     **/
    @Test
    public void testAddCustomer_1() {
        Customer customer=mock(Customer.class);
        Customer saved=mock(Customer.class);
        Mockito.when(repo.save(customer)).thenReturn(saved);
        Customer result = service.addCustomer(customer);
        Assertions.assertNotNull(result);
        verify(repo).save(customer);
    }

    /**
     * Scenario L: validation failed
     * verifying AddCustomerException is thrown
     */
    @Test
    public void testAddCustomer_2(){
        Customer customer=mock(Customer.class);
        doThrow(AddCustomerException.class).when(service).validateCustomer(customer);
        Executable executable=()->service.addCustomer(customer);
        assertThrows(AddCustomerException.class,executable);
    }
  //Customer Found
    @Test
    void testViewCustomer_1() {
        int customerid=1;
        Customer customer=mock(Customer.class);
        Optional<Customer> optional= Optional.of(customer);
        when(repo.findById(customerid)).thenReturn(optional);
        Customer result= service.viewCustomer(customerid);
        Assertions.assertEquals(result,customer);
        verify(repo).findById(customerid);

    }
    //Customer Not Found
    @Test
    void testViewCustomer_2(){
        int customerId=11;
        Optional<Customer> optional= Optional.empty();
        when(repo.findById(customerId)).thenReturn(optional);
        Executable executable =()->service.viewCustomer(customerId);
        Assertions.assertThrows(CustomerNotFoundException.class,executable);
    }

	/**
	 * Deleting success scenario 
	 */
	
	@Test
	void deleteCustomerTest_1() {
		int customerid=1;
		Customer customer=mock(Customer.class);
		Optional<Customer> optional = Optional.of(customer);
		Mockito.when(repo.findById(customerid)).thenReturn(optional);
		//Mockito.when(repo.delete(book)).thenReturn(Optional.empty());
		doNothing().when(service).validateId(customerid);
		doNothing().when(repo).delete(customer);
		Customer result=service.deleteCustomer(customerid);
		Assertions.assertNotNull(optional);
		Assertions.assertEquals(customer,result);
		verify(repo).delete(result);
	}
	
	
	/**
	 * Scenario id not found for deleting. Delete failed
	 */
	@Test
	void deleteCustomerTest_2() {
		int customerid=1;
		Optional<Customer> optional = Optional.empty();
		when(repo.findById(customerid)).thenReturn(optional);
		Executable executable = () -> service.viewCustomer(customerid);
		Assertions.assertThrows(CustomerNotFoundException.class, executable);
	}
	
}
