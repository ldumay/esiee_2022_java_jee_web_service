package com.example.restservice.service;

import java.util.ArrayList;
import java.util.List;

import com.example.restservice.exception.NoGreetingFoundException;
import com.example.restservice.model.Greeting;

public class GreetingService {
	private final List<Greeting> greetingList = new ArrayList<Greeting>();

	public String createGreeting(long id, String type, String name) {
		greetingList.add(GreetingBuilder.createGreeting(type, id, name));
		return "Greeting added";
	}

	public Greeting getGreeting(long id) {
		for (Greeting greeting : greetingList) {
			if (id == greeting.getId()) {
				return greeting;
			}
		}
		throw new NoGreetingFoundException(id);
	}

	public List<Greeting> getAllGreeting() {
		if (greetingList.size() <= 0) {
			throw new NoGreetingFoundException();
		}
		return greetingList;
	}

	public String updateGreeting(long id, String name) {
		getGreeting(id).setName(name);
		return "Greeting updated";
	}

	public String deleteGreeting(long id) {
		Greeting greetingToDelete = null;
		for (Greeting greeting : greetingList) {
			if (id == greeting.getId()) {
				greetingToDelete = greeting;
			}
		}
		if (greetingToDelete != null) {
			greetingList.remove(greetingToDelete);
			return "Greeting deleted";
		}
		throw new NoGreetingFoundException();
	}
}
