package org.delivery;

import jakarta.transaction.Transactional;
import org.delivery.Entity.*;
import org.delivery.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
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
    public CommandLineRunner run(CustomerRepository customerRepository,
                                 CourierRepository courierRepository,
                                 DeliveryRepository deliveryRepository,
                                 OrderRepository orderRepository,
                                 TrackingRepository trackingRepository) throws Exception{
        return(String[] args) ->{

            //Customer test adding
            Customer customer1 = new Customer("Dylan", "dylan@gmail.com", "+48223123432", "05-600 Warszawa, Aleje Jerozolimskie 1/2");
            Customer customer2 = new Customer( "Addy", "addy@gmail.com", "+48234567654", "05-200 Poznań, Piłsudzkiego 2/5");
            customerRepository.save(customer1);
            customerRepository.save(customer2);

            //Courier test adding
            Courier courier1 = new Courier("Wojtek", "wojtekSokol@onet.pl", "+48883021043", "WU65434", "VAN");
            courierRepository.save(courier1);

            //Next cusotmer test adding
            Customer customer3 = new Customer( "Alek", "alon@gmail.com", "+482345434354", "05-200 Zamość, Piłsudzkiego 3/4");
            customerRepository.save(customer3);

            //Delivery test adding
            LocalDateTime estimatedDeliveryTime1 = LocalDateTime.parse("2023-05-10T15:30:00");
            Delivery delivery1 = new Delivery(courier1, "undelivered", estimatedDeliveryTime1);
            deliveryRepository.save(delivery1);

            //Order test adding
            BigDecimal totalPrice1 = BigDecimal.valueOf(100.50);
            Order order1 = new Order(customer1, courier1, delivery1);
            order1.setTotalPrice(totalPrice1);
            orderRepository.save(order1);

            //Tracking test adding
            LocalDateTime updatedAt1 = LocalDateTime.parse("2023-05-11T15:40:00");
            Tracking tracking1 = new Tracking(delivery1, "undelivered", "Warszawa", updatedAt1);
            trackingRepository.save(tracking1);


            //
            customerRepository.findAll().forEach(customer -> System.out.println(customer));
            courierRepository.findAll().forEach(courier -> System.out.println(courier));
            deliveryRepository.findAll().forEach(delivery -> System.out.println(delivery));
            orderRepository.findAll().forEach(order -> System.out.println(order));
            trackingRepository.findAll().forEach(tracking -> System.out.println(tracking));

        };
    }
}
