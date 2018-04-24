package com.example.demo.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@RestController
public class WebController {
	@Autowired
	CustomerRepository repository;

	@RequestMapping("/save")
	public String process() {
		// save a single Customer
		repository.save(new Customer("Hanh", "Nguyen"));

		// save a list of Customers
		repository.save(Arrays.asList(new Customer("Trang", "Nguyen"), new Customer("Nguyen", "Ho")));
		return "Done";

	}

	@RequestMapping("/findall")
	public String findAll() {
		String result = "";

		for (Customer cust : repository.findAll()) {
			result += cust.toString() + "<br>";

		}
		return result;

	}

	@RequestMapping("/findbyid")
	public String findById(@RequestParam("id") long id) {
		String result = "";
		result = repository.findOne(id).toString();
		return result;
	}

	@RequestMapping("/findbylastname")
	public String fetchDataByLastName(@RequestParam("lastname") String lastName) {
		String result = "";

		for (Customer cust : repository.findAll()) {
			result += cust.toString() + "<br>";

		}
		return result;

	}
}