package com.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class CsrfApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsrfApplication.class, args);
	}

	@GetMapping
	public String greeting(){
		return "Greetings !!!";
	}

	@PostMapping("/name")
	public String greetUser(@RequestParam(value = "name", defaultValue = "") String name){
		return String.format("Hello, welcome to %s", name);
	}

}
