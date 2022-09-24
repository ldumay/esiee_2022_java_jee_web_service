package com.esiee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Lanceur de l'application.
 *
 * @author ldumay, hmaxence, xchen
 */
@SpringBootApplication
public class WebserviceApplication {

    /**
     * Code exécuter avant le lancement de l'application.
     * @return
     */
    @Bean
    public CommandLineRunner run() {
        return (args) -> {
            //-
            System.out.println("Hello world !");
        };
    }

    /**
     * Lancement de l'application.
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(WebserviceApplication.class, args);
        //-
        System.out.println("[BDD-H2] No prise en charge");
    }

}
