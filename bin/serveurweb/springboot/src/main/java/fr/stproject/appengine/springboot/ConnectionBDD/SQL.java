package fr.stproject.appengine.springboot.ConnectionBDD;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.*;


public class SQL {

    public static Connection con;
    public final String fichierBDD;

    public SQL() {
        this.fichierBDD = null;
        this.con = null;
    }

    public SQL(String fichierBDD) {
        this.fichierBDD = fichierBDD;
        System.out.println("[Status] Connection to database " + fichierBDD);
        try {
            // Connection à la base de donnée
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + fichierBDD);
            System.out.println("[Status] Connected");
            init();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void init(){
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS `Mesures` (\n" +
                    "  `id_mesure` SERIAL PRIMARY KEY,\n" +
                    "  `date_prise` DATETIME NOT NULL,\n" +
                    "  `niveau_glycemine`  FLOAT NOT NULL,\n" +
                    "  `id_patient` BIGINT unsigned NOT NULL,\n" +
                    "  FOREIGN KEY (id_patient) REFERENCES Patient(id_patient) ON DELETE cascade\n" +
                    "  )");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Connection getCon() {
        return con;
    }

    public String getFichierBDD() {
        return fichierBDD;
    }

    public void close(){
        try {
            con.close();
            System.out.println("[Status] Connection closed");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void saveInputDataOnDataBase(String date, String taux, String id_patient) {
        if (date != "0" || taux != "0" || id_patient != "0") {
            try {
                PreparedStatement stmt = con.prepareStatement("INSERT INTO Mesures VALUES ( ?, ?, ?)");
                stmt.setString(1, date);
                stmt.setString(2, taux);
                stmt.setString(3, id_patient);
                stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
