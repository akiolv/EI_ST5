package fr.stproject.appengine.springboot;

import fr.stproject.appengine.springboot.ConnectionBDD.SQL;
import org.apache.ibatis.mapping.ResultSetType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

	@GetMapping("/test")
	public String schlag() {
//		String test = "resultat: ";
//		try {
//			Connection con = interfacesql.getCon();
//			Statement stmt = con.createStatement();
//			ResultSet res = stmt.executeQuery("SELECT id_mesure AS idMesure FROM Mesures LIMIT 1");
//			test += res.getString("idMesure");
//		} catch (SQLException throwables) {
//			throwables.printStackTrace();
//		}
		return "test";
	}

	@GetMapping("/inputdata")
	public String saveInputData(@RequestParam(value = "date", defaultValue = "0") String date, @RequestParam(value = "taux", defaultValue = "0") String taux, @RequestParam(value = "id_patient", defaultValue = "0") String id_patient) {
//		interfacesql.saveInputDataOnDataBase(date, taux, id_patient );
		return "lol";
	}
}
