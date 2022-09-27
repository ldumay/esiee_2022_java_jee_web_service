package com.example.restservice.model;

public class GreetingSalut extends Greeting {

	public GreetingSalut(long id, String name) {
		super(id, name);
		setGreet();
		updateContent(name);
	}

	@Override
	public void setGreet() {
		this.greet = "Salut %s";
	}

}
