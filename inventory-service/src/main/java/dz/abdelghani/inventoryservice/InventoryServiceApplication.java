package dz.abdelghani.inventoryservice;

import dz.abdelghani.inventoryservice.entities.Product;
import dz.abdelghani.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(InventoryServiceApplication.class, args);
	}
@Bean
	CommandLineRunner start(ProductRepository productRepository){
		return args -> {
			productRepository.save(new
					Product(null,"Samsung S3",10.5,4));
			productRepository.save(new
					Product(null,"Iphone 13",15.5,14));
			productRepository.save(new
					Product(null,"Toyota Yaris",100.5,2));

			productRepository.findAll().forEach(p->{
				System.out.println(p.toString());
			});
		};
	}

}
