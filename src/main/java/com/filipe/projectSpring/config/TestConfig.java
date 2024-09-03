package com.filipe.projectSpring.config;


import com.filipe.projectSpring.Entities.User;
import com.filipe.projectSpring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

      @Autowired
      private UserRepository userRepository;

      @Override
      public void run(String... args) throws Exception {

            User u1 = new User("maria@gmail.com",null,"maria@gmail.com" , "999999","123456");
            User u2 = new User("maria@gmail.com",null, "Alex green", "999999","123456");

            userRepository.saveAll(Arrays.asList(u1,u2));
      }
}
