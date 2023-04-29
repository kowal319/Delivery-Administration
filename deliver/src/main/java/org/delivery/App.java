package org.delivery;

import jakarta.transaction.Transactional;
import org.delivery.Entity.Courier;
import org.delivery.Entity.Customer;
import org.delivery.Entity.Delivery;
import org.delivery.Repository.CourierRepository;
import org.delivery.Repository.CustomerRepository;
import org.delivery.Repository.DeliveryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    public CommandLineRunner run(CustomerRepository customerRepository, CourierRepository courierRepository, DeliveryRepository deliveryRepository) throws Exception{
        return(String[] args) ->{
            LocalDateTime estimatedDeliveryTime1 = LocalDateTime.parse("2023-05-10T15:30:00");

            Customer customer1 = new Customer("Dylan", "dylan@gmail.com", "+48223123432", "05-600 Warszawa, Aleje Jerozolimskie 1/2");
            Customer customer2 = new Customer( "Addy", "addy@gmail.com", "+48234567654", "05-200 Poznań, Piłsudzkiego 2/5");
            customerRepository.save(customer1);
            customerRepository.save(customer2);

            Courier courier1 = new Courier("Wojtek", "wojtekSokol@onet.pl", "+48883021043", "WU65434", "VAN");
            courierRepository.save(courier1);

            Customer customer3 = new Customer( "Alek", "alon@gmail.com", "+482345434354", "05-200 Zamość, Piłsudzkiego 3/4");
            customerRepository.save(customer3);

            Delivery delivery1 = new Delivery(courier1, "undelivered", estimatedDeliveryTime1);
            deliveryRepository.save(delivery1);

            customerRepository.findAll().forEach(customer -> System.out.println(customer));
            courierRepository.findAll().forEach(courier -> System.out.println(courier));
            deliveryRepository.findAll().forEach(delivery -> System.out.println(delivery));
        };
    }
}
