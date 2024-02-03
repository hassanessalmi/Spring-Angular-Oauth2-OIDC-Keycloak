package com.example.inventoryservice;

import com.example.inventoryservice.entities.Product;
import com.example.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
 public CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return args -> {
			productRepository.save(Product.builder()
							.id(UUID.randomUUID().toString())
							.name("computer")
							.price(20000)
							.quantity(11)
					.build());
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("iphon")
					.price(120000)
					.quantity(11)
					.build());
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("print")
					.price(20000)
					.quantity(10)
					.build());

		};
}
}
