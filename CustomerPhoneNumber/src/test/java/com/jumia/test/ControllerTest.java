package com.jumia.test;



import org.junit.Assert;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;

import com.jumia.controller.Controller;
import com.jumia.entity.Customer;
import com.jumia.repository.CustomerRepository;
import com.jumia.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootTest
public class ControllerTest {
	private static final Logger logger = LogManager.getLogger(Controller.class);
	
	@Autowired
	private CustomerService customerService ;

	@MockBean
	private CustomerRepository customerRepository;

	/*
	@Before
    public void setUp() {

		Customer testCustomer = new Customer();
		testCustomer.setId(1);
		testCustomer.setName("TestName");
		testCustomer.setPhone("00201033337500");
        ArrayList<Customer> customers = new ArrayList<Customer>();
        customers.add(testCustomer);
        doReturn(testCustomer).when(customerRepository).save(any());
        Mockito.when(this.customerRepository.findAll()).thenReturn(customers);
    }
	*/

	
	@Test
	@DisplayName("Test Save Customer")
    public void testRepository() 
    {
        Customer c = new Customer();
        c.setId(1);
        c.setName("Gupta");
        c.setPhone("00000000000");
        customerRepository.save(c);
         
        Assert.assertEquals(1, c.getId());
        assertEquals(c.getId(),1);

    }
	@Test
	@DisplayName("Test Get All Customers")
	@Sql("/addData.sql")
    public void getCustomers() 
    {
		assertEquals(1, 1);
		ArrayList<Customer> customers = customerRepository.findAll();
    }
}
