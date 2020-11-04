package com.example.javaxvalidation;

import com.example.javaxvalidation.entity.User;
import com.example.javaxvalidation.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaxValidationApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaxValidationApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(UserRepository userRepository) throws Exception {
        return (String[] args) -> {
            User user1 = new User();
            user1.setName("Bob");
            user1.setEmail("bob@domain.com");
            user1.setCountry("SL");
            User user2 = new User();
            user2.setName("Jenny");
            user2.setEmail("jenny@domain.com");
            user2.setCountry("AUS");
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.findAll().forEach(System.out::println);
        };
    }

}
