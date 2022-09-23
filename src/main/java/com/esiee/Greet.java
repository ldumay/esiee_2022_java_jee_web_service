package com.esiee;

import java.util.List;

public interface Greet {

    public void createGreeting(long id, String name);

    public Greeting getGreetings();

    public List<Greeting> getAllGreetings();

    public void updateGreeting(long id, String name);

    public void deleteGreeting(long id);
}
