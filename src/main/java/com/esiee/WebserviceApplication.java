package com.esiee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebserviceApplication.class, args);
        //-
        System.out.println("[BDD-H2] No prise en charge");
    }

    @Bean
    public CommandLineRunner run() {
        return (args) -> {
            //-
            System.out.println("Hello world !");
        };
    }

}
