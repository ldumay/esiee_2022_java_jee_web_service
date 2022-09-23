package com.esiee;

import java.util.List;

public class Greeting implements Greet {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    @Override
    public void createGreeting(long id, String name) {

    }

    @Override
    public Greeting getGreetings() {
        return null;
    }

    @Override
    public List<Greeting> getAllGreetings() {
        return null;
    }

    @Override
    public void updateGreeting(long id, String name) {

    }

    @Override
    public void deleteGreeting(long id) {
        
    }
}
