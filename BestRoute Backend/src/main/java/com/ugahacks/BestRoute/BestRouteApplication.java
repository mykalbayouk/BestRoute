package com.ugahacks.BestRoute;

import java.net.MalformedURLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BestRouteApplication {

	public static void main(String[] args) throws MalformedURLException {
		SpringApplication.run(BestRouteApplication.class, args);
		Manager manager = new Manager();
		manager.getCarPrice();
	}

}
