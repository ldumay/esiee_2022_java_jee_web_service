package com.esiee.services;

import com.esiee.interfaces.GreetingModel;
import com.esiee.models.Greeting;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GreetingService implements GreetingModel {

    private String info = "[GreetingService] ";
    private static List<Greeting> greetings = new ArrayList<>();

    @Override
    @GetMapping("/greeting/all/")
    public List<Greeting> getAllGreetings() {
        System.out.println(info + "Get all greetings : " + greetings.size());
        return greetings;
    }

    @Override
    @GetMapping("/greeting/get/{id}")
    public Greeting getGreetings(long id) {
        System.out.println(info + "Get greeting:" + id);
        return greetings.get((int) id);
    }

    @PostMapping("/greeting/create/")
    public void createGreetingWithObject(Greeting greeting) {
        int number = (greetings.size()>=0) ? greetings.size()+1 : 0;
        System.out.println(info
                + "Create greeting:" + number
                + " with content:" + greeting.getContent());
        greeting.setId(number);
        greetings.add(greeting);
    }
    
    @Override
    @PostMapping("/greeting/create/{content}")
    public void createGreeting(String content) {
        int number = (greetings.size()>=0) ? greetings.size()+1 : 0;
        System.out.println(info
                + "Create greeting:" + number
                + " with content:" + content);
        greetings.add(new Greeting(number, content));
    }

    @Override
    @PutMapping("/greeting/update/id={id}&content={content}")
    public void updateGreeting(long id, String content) {
        System.out.println(info + "Update greeting:" + id);
        greetings.set((int) id, new Greeting(id, content));
    }

    @Override
    @DeleteMapping("/greeting/delete/{id}")
    public void deleteGreeting(long id) {
        System.out.println(info + "Remove greeting:" + id);
        greetings.remove((int) id);
    }
}
