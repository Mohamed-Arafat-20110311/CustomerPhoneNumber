package com.jumia.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jumia.model.User;
import com.jumia.service.CustomerService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Controller {
	private static final Logger logger = LogManager.getLogger(Controller.class);
	@Autowired
	private CustomerService customerService; 
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET, produces = "application/json")
	public ArrayList<User> firstPage() {
		logger.info("Hello from Fisrt Page");
		ArrayList<User> users = customerService.getCustomers();
		return users;
	}

}
