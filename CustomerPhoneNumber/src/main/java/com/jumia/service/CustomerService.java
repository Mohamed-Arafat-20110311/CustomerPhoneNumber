package com.jumia.service;

import java.util.ArrayList;
import java.util.regex.Pattern;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumia.entity.Customer;
import com.jumia.model.User;
import com.jumia.repository.CustomerRepository;



@Service
public class CustomerService {

	public static final String[] COUNTRY_NAMES = {"Cameroon","Ethiopia","Morocco","Mozambique","Uganda"};
	public static final String[] COUNTRY_REGEX = {"\\(237\\)\\ ?[2368]\\d{7,8}$", "\\(251\\)\\ ?[1-59]\\d{8}$", "\\(212\\)\\ ?[5-9]\\d{8}$", "\\(258\\)\\ ?[28]\\d{7,8}$", "\\(256\\)\\ ?\\d{9}$"};
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public ArrayList<Customer> getAllCustomers() {
		ArrayList<Customer> customer = customerRepository.findAll();
		return customer;
	}
	
	public ArrayList<User> getCustomers() {
		ArrayList<Customer> customers = getAllCustomers();
		ArrayList<User> users = new ArrayList<User>();
		for(Customer customer : customers) {
			String phone = customer.getPhone();
			String countryIdx = getCustomerCountry(phone);
			String regex = COUNTRY_REGEX[Integer.parseInt(countryIdx.substring(0,1))];
			String country = countryIdx.substring(2);
			boolean isMatched = Pattern.matches(regex,phone);
			User user = new User(customer.getId(),customer.getName(),phone,country,isMatched);
			users.add(user);
		}
		return users;
	}
	
	public String getCustomerCountry(String phone) {
		String key = phone.substring(1,4);
		if (key.equals("237")) {
			return "0_" +  COUNTRY_NAMES[0];
		}else if (key.equals("251")) {
			return "1_" +  COUNTRY_NAMES[1];
		}else if (key.equals("212")) {
			return "2_" +  COUNTRY_NAMES[2];
		}else if (key.equals("258")) {
			return "3_" +  COUNTRY_NAMES[3];
		}else if (key.equals("256")) {
			return "4_" +  COUNTRY_NAMES[4];
		}
		return "";
	}

	public Customer findByName(String string) {
		return customerRepository.findByName(string);
	}
}
