package com.esiee.interfaces;

import com.esiee.models.Greeting;
import java.util.List;

public interface GreetingModel {

    public void createGreeting(String name);

    public Greeting getGreetings(long id);

    public List<Greeting> getAllGreetings();

    public void updateGreeting(long id, String name);

    public void deleteGreeting(long id);
}
