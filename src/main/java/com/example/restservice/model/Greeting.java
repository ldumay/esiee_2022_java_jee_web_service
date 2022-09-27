package com.example.restservice.model;

public abstract class Greeting {

	private final long id;
	private String content;
	protected String greet;
	private String name;

	public Greeting(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		updateContent(this.name);
		return content;
	}

	protected void updateContent(String name) {
		this.content = String.format(this.greet, name);
	}

	public abstract void setGreet();

	public String getName(String name) {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
