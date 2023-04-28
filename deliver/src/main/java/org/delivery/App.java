package org.delivery;

import org.delivery.Entity.Customer;
import org.delivery.Repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 *
 */
@SpringBootApplication
public class App

{
    public static void main(String[] args )
    {
        SpringApplication.run(App.class, args);

    }

    @Bean
    public CommandLineRunner run(CustomerRepository customerRepository) throws Exception{
        return(String[] args) ->{
            Customer customer1 = new Customer("Dylan", "dylan@gmail.com", "+48223123432", "05-600 Warszawa, Aleje Jerozolimskie 1/2");
            Customer customer2 = new Customer( "Addy", "addy@gmail.com", "+48234567654", "05-200 Poznań, Piłsudzkiego 2/5");
            customerRepository.save(customer1);
            customerRepository.save(customer2);
customerRepository.findAll().forEach(customer -> System.out.println(customer));
        };
    }
}
