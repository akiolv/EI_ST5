package fr.stproject.appengine.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MappingApplication {

	public static ConnectionBDD.SQL bdd;

	public static void main(String[] args) {
		bdd = new ConnectionBDD.SQL("C:/Users/antoi/Desktop/Fichier_perso/Cours/ST5/EI/EI_ST5/serveurweb/springboot/db/db-st5-c0.db");
		SpringApplication.run(MappingApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "Hello world!";
	}

	@GetMapping("/schlagcs")
	public String schlag() {
		return "QUIIIIII DIIIIIIT *** ?";
	}

	@GetMapping("/inputdata")
	public String saveInputData(@RequestParam(value = "date", defaultValue = "00-00-0000-00-00-00") String date, @RequestParam(value = "taux", defaultValue = "0") String taux, @RequestParam(value = "id_patient", defaultValue = "0") String id_patient) {
		String test = date + "\n" + taux + "\n" + id_patient;
		return test;
	}

}
