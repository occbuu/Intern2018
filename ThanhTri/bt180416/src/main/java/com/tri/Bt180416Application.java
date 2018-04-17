package com.tri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.tri.model.*;

@SpringBootApplication
public class Bt180416Application {

	@Bean
	public Matrix getMatrix() {
		return new Matrix();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Bt180416Application.class, args);
	}
}
