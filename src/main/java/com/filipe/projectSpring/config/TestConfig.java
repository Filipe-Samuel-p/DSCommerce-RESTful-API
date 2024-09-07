package com.filipe.projectSpring.config;

import com.filipe.projectSpring.Entities.*;
import com.filipe.projectSpring.Entities.enums.OrderStatus;
import com.filipe.projectSpring.repositories.*;
import com.filipe.projectSpring.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

      @Autowired
      private UserRepository userRepository;

      @Autowired
      private OrderRepository orderRepository;

      @Autowired
      private CategoryRepository categoryRepository;

      @Autowired
      private ProductRepository productRepository;

      @Autowired
      private OrderItemRepository orderItemRepository;

      @Override
      public void run(String... args) throws Exception {



            Category cat1 = new Category(null, "Electronics");
            Category cat2 = new Category(null, "Books");
            Category cat3 = new Category(null, "Computers");

            Product p1 = new Product("Lorem ipsum dolor sit amet, consectetur.", null,"" ,"The Lord of the Rings", 90.5);
            Product p2 = new Product("Nulla eu imperdiet purus.", null, " ", "Smart TV", 2190.0);
            Product p3 = new Product("Nam eleifend maximus tortor, at mollis.", null, "", "Macbook Pro", 1250.0);
            Product p4 =  new Product("Donec aliquet odio ac rhoncus cursus.", null, "", "PC Gamer", 1200.0);
            Product p5 =  new Product("Cras fringilla convallis sem vel faucibus.", null, "", "Rails for Dummies", 100.90);

            categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
            productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

            p1.getCategories().add(cat2);
            p2.getCategories().add(cat1);
            p2.getCategories().add(cat3);
            p3.getCategories().add(cat3);
            p4.getCategories().add(cat3);
            p5.getCategories().add(cat2);

            productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

            User u1 = new User("maria@gmail.com",null,"maria@gmail.com" , "999999","123456");
            User u2 = new User("alex@gmail.com",null, "Alex green", "999999","123456");

            Order o1 = new Order(u1, Instant.parse("2019-06-20T19:53:07Z"), null,OrderStatus.PAID);
            Order o2 = new Order(u2, Instant.parse("2019-07-21T03:42:10Z"), null,OrderStatus.WAITING_PAYMENT);
            Order o3 = new Order(u1, Instant.parse("2019-07-22T15:21:22Z"), null,OrderStatus.CANCELED);

            userRepository.saveAll(Arrays.asList(u1,u2));
            orderRepository.saveAll(Arrays.asList(o1,o2,o3));

            OrderItem oi1 = new OrderItem(o1, p1, p1.getPrice(),2 );
            OrderItem oi2 = new OrderItem(o1, p3, p3.getPrice(),1 );
            OrderItem oi3 = new OrderItem(o2, p3, p3.getPrice(),2 );
            OrderItem oi4 = new OrderItem(o3, p5,  p5.getPrice(),2);

            orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));


      }
}
