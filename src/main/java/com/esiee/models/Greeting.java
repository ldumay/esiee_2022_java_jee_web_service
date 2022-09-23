package com.esiee.models;

import com.esiee.interfaces.GreetingModel;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Data
@RestController
public class Greeting implements GreetingModel {

    private long id;
    private String content;
    private static List<Greeting> greetings = new ArrayList<Greeting>();

    public Greeting() {
        this.id = 0;
        this.content = "";
    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    @GetMapping("/greeting/all/")
    public List<Greeting> getAllGreetings() {
        System.out.println("Get all greetings : " + greetings.size());
        return greetings;
    }

    @Override
    @GetMapping("/greeting/get/{id}")
    public Greeting getGreetings() {
        return greetings.get((int) id);
    }

    @Override
    @PostMapping("/greeting/create/{content}")
    public void createGreeting(String name) {
        greetings.add(new Greeting(greetings.size()+1, name));
    }

    @Override
    @PutMapping("/greeting/update/{id}&{content}")
    public void updateGreeting(long id, String name) {
        greetings.set((int) id, new Greeting(id, name));
    }

    @Override
    @DeleteMapping("/greeting/delete/{id}")
    public void deleteGreeting(long id) {
        greetings.remove((int) id);
    }
}
