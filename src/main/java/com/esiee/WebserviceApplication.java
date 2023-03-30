package com.esiee;

import com.esiee.models.Greeting;
import com.esiee.services.GreetingService;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;
import java.util.List;

/**
 * Lanceur de l'application.
 *
 * @author ldumay, hmaxence, xchen
 */
@SpringBootApplication
@EnableSwagger2
public class WebserviceApplication {

    public static List<Greeting> greetings;
    public static GreetingService greeting;

    /**
     * Code exécuter avant le lancement de l'application.
     * @return
     */
    @Bean
    public CommandLineRunner run() {
        return (args) -> {
            //-
            System.out.println("Hello world !");
            //-

        };
    }

    /**
     * Lancement de l'application.
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(WebserviceApplication.class, args);
        //-
        greetings = new ArrayList<>();
        //-
        int number = (greetings.size()>=0) ? greetings.size()+1 : 0;
        greetings.add(new Greeting(number, "Velo"));
        number++;
        greetings.add(new Greeting(number, "Bateau"));
        number++;
        greetings.add(new Greeting(number, "Train"));
        //-
        greeting = new GreetingService(greetings);
        //-
        System.out.println("[BDD-H2] No prise en charge");
    }
}
