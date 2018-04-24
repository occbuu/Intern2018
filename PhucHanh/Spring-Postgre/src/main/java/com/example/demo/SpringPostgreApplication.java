package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.CustomerRepository;

@SpringBootApplication
public class SpringPostgreApplication implements CommandLineRunner{
	
	@Autowired
	CustomerRepository repository;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringPostgreApplication.class, args);
	}
	@Override
	public void run(String...args) throws Exception{
		//clear all record if existed before do the tutorial with new data
		repository.deleteAll();
	}
}
