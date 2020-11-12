package fr.stproject.appengine.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "Hello world!";
	}

	@GetMapping("/schlagcs")
	public String shlag() {
		return "QUIIIIII DIIIIIIT *** ?";
	}

	@GetMapping("/inputData")
	public String saveInputData() {
		return "data incoming";
	}

}
