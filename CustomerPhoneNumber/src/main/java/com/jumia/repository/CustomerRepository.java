package com.jumia.repository;

import org.springframework.stereotype.Repository;

import com.jumia.entity.Customer;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	public ArrayList<Customer> findAll();

	public Customer findByName(String string);
	
}
