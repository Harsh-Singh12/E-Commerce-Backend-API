package com.ecommerce.backend;

import com.ecommerce.backend.model.Product;
import com.ecommerce.backend.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(EcommerceBackendApplication.class, args);
	}
	@Bean
	public CommandLineRunner testDatabase(ProductRepository repository) {
		return args -> {
			Product p = new Product();
			p.setName("Test Product");
			p.setPrice(99.99);
			repository.save(p);
			System.out.println("Product saved to DB.");
		};
	}
}
