package fr.st5c0.HelloWorld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "Bienvenue !";
	}

	@GetMapping("/helloworld")
	public String hello() {
		return "Hello world!";
	}

}
