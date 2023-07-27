package dz.abdelghani.customerservice;

import dz.abdelghani.customerservice.entities.Customer;
import dz.abdelghani.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerServiceApplication.class, args);
    }
@Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(
                    new Customer(null,"Dadi","dadi@gmail"));
            customerRepository.save(
                    new Customer(null,"Amine","amine@gmail"));
            customerRepository.save(
                    new Customer(null,"Youcef","youcef@gmail"));

            customerRepository.findAll().forEach(c->{
                System.out.println(c.toString());
            });
        };
    }

}
