package com.cws.oop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cws.oop.utl.Matrix;

@SpringBootApplication
public class CwsApplication {

	public static void main(String[] args) {
		Matrix a = new Matrix();
		Matrix b = new Matrix(3, 3);
		Matrix c = new Matrix(3, 3, "C");

		b.setName("B");

		a.setName("A");
		a.setN(5);
		a.setM(5);
		a.random();

		c.setName("C1");
		c.setM(40);
		c.random();

		a.save();
		a.save("C:\\a.txt");

		SpringApplication.run(CwsApplication.class, args);
	}
}