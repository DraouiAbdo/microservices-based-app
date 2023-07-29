package dz.abdelghani.billingservice;

import dz.abdelghani.billingservice.entities.Bill;
import dz.abdelghani.billingservice.entities.ProductItem;
import dz.abdelghani.billingservice.feign.CustomerRestClient;
import dz.abdelghani.billingservice.feign.ProductRestClient;
import dz.abdelghani.billingservice.model.Customer;
import dz.abdelghani.billingservice.model.Product;
import dz.abdelghani.billingservice.repositories.BillRepository;
import dz.abdelghani.billingservice.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Date;
import java.util.Random;


@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(BillingServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(BillRepository billRepository,
							ProductItemRepository productItemRepository,
							CustomerRestClient customerRestClient,
							ProductRestClient productRestClient){
		return args -> {
			Customer customer = customerRestClient.getCustomerById(1L);
			Bill bill = billRepository.save(
					new Bill(null,new Date(),null,customer.getId(),null));
			PagedModel<Product> products = productRestClient.productsPage();
			products.forEach(p->{
				ProductItem productItem = new ProductItem();
				productItem.setProductId(p.getId());
				productItem.setPrice(p.getPrice());
				productItem.setBill(bill);
				productItem.setQuantity(111.5);
				productItemRepository.save(productItem);
			});

		};

	}
}
