package com.example.restservice.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.model.Greeting;
import com.example.restservice.service.GreetingService;

@RestController
public class GreetingController {

	private final GreetingService greetingService;
	private final AtomicLong counter;

	public GreetingController() {
		this.greetingService = new GreetingService();
		this.counter = new AtomicLong();
	}

	@GetMapping("/greeting")
	public List<Greeting> getGreeting(@RequestParam(value = "id", required = false, defaultValue = "0") int id) {
		if (id > 0) {
			List<Greeting> greetingListTemp = new ArrayList<Greeting>();
			greetingListTemp.add(greetingService.getGreeting(id));
			return greetingListTemp;
		}
		return greetingService.getAllGreeting();
	}

	@RequestMapping(value = { "/greeting" }, method = { RequestMethod.POST, RequestMethod.PUT })
	public String createGreeting(@RequestParam(value = "name", defaultValue = "World") String name, @RequestParam(value = "type", required = false, defaultValue = "") String type) {
		return greetingService.createGreeting(counter.incrementAndGet(), type, name);
	}

	@PatchMapping("/greeting")
	public String updateGreeting(@RequestParam(value = "id") int id, @RequestParam(value = "name", defaultValue = "World") String name) {
		return greetingService.updateGreeting(id, name);
	}

	@DeleteMapping("/greeting")
	public String deleteGreeting(@RequestParam(value = "id") int id) {
		return greetingService.deleteGreeting(id);
	}
}
