package com.example.restservice.service;

import com.example.restservice.model.Greeting;
import com.example.restservice.model.GreetingHello;
import com.example.restservice.model.GreetingSalut;

public class GreetingBuilder {

	private GreetingBuilder() {
	}

	public static Greeting createGreeting(String type, long id, String name) {
		if (type == null) {
			type = "";
		}
		switch (type) {
		case "Salut":
			return createSalutGreeting(id, name);
		case "Hello":
		default:
			return createHelloGreeting(id, name);
		}
	}

	public static Greeting createHelloGreeting(long id, String name) {
		return new GreetingHello(id, name);
	}

	public static Greeting createSalutGreeting(long id, String name) {
		return new GreetingSalut(id, name);
	}
}
