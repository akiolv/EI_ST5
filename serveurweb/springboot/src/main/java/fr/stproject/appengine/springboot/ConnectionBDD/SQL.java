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
        init();
        this.fichierBDD = null;
        this.con = null;
    }

    public SQL(String fichierBDD) {
        init();
        this.fichierBDD = fichierBDD;
        System.out.println("[Status] Connection to database " + fichierBDD);
        try {
            // Connection à la base de donnée
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + fichierBDD);
            System.out.println("[Status] Connected");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void init(){
        ScriptRunner sr = new ScriptRunner(con);
        //Creating a reader object
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/home/anouk9876543210/EI_ST5/serveurweb/springboot/src/main/java/fr/stproject/appengine/springboot/ConnectionBDD/bdd.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Running the script
        sr.runScript(reader);
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
                PreparedStatement stmt = con.prepareStatement("INSERT INTO Mesures VALUES (?, ?, ?, ?)");
                Statement statement = con.createStatement();
                ResultSet maxid = statement.executeQuery("SELECT MAX(id_mesure) AS idMesure FROM Mesures");
                if(maxid != null){stmt.setInt(1, maxid.getInt("idMesure"));}
                else{stmt.setInt(1, 1);}
                stmt.setString(2, date);
                stmt.setString(3, taux);
                stmt.setString(4, id_patient);
                stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
