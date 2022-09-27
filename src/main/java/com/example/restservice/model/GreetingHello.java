package com.example.restservice.model;

public class GreetingHello extends Greeting {

	public GreetingHello(long id, String name) {
		super(id, name);
		setGreet();
		updateContent(name);
	}

	@Override
	public void setGreet() {
		this.greet = "Hello %s";
	}

}
