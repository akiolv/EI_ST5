package fr.stproject.appengine.springboot;

import ConnectionBDD.SQL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MappingApplication {

	private static SQL interfacesql;

	public static void main(String[] args) {
		interfacesql = new SQL("/home/anouk9876543210/EI_ST5/serveurweb/springboot/db/db-st5-c0.db");
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
	public String saveInputData(@RequestParam(value = "date", defaultValue = "0") String date, @RequestParam(value = "taux", defaultValue = "0") String taux, @RequestParam(value = "id_patient", defaultValue = "0") String id_patient) {
		interfacesql.saveInputDataOnDataBase(date, taux, id_patient );
		return "lol";
	}
}
