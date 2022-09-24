package com.esiee;

import com.esiee.models.Greeting;
import com.esiee.services.GreetingService;
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
public class WebserviceApplication {

    public static List<Greeting> greetings;
    public static GreetingService greeting;

    /**
     * Code exécuter avant le lancement de l'application.
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
     */
    public static void main(String[] args) {
        SpringApplication.run(WebserviceApplication.class, args);
        //-init array
        greetings = new ArrayList<>();
        //-
        //Check the size of the array, get the init id value with ternary operator
        int number = (greetings.size()>=0) ? greetings.size()+1 : 0;
        //add greeting id and content into the array
        greetings.add(new Greeting(number, "Velo"));
        //id value ++
        number++;
        //add greeting id and content into the array
        greetings.add(new Greeting(number, "Bateau"));
        //id value ++
        number++;
        //add greeting id and content into the array
        greetings.add(new Greeting(number, "Train"));
        //-
        greeting = new GreetingService(greetings);
        //-
        System.out.println("[BDD-H2] No prise en charge");
    }
}
