package ConnectionBDD;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.*;

public class SQL {

    public static Connection con;
    public final String fichierBDD;
    public static Statement statement;

    public SQL() {
//        init();
        this.fichierBDD = null;
        this.con = null;
        this.statement = null;
    }

    public SQL(String fichierBDD) {
//        init();
        this.fichierBDD = fichierBDD;
        System.out.println("[Status] Connection to database " + fichierBDD);
        try {
            // Connection à la base de donnée
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + fichierBDD);
            System.out.println("[Status] Connected");
            statement = con.createStatement();
            System.out.println("[Status] Statement created");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void init(){
        ScriptRunner sr = new ScriptRunner(con);
        //Creating a reader object
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader("bdd.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Running the script
        sr.runScript(reader);
    }

    public static Connection getCon() {
        return con;
    }

    public static Statement getStatement() {
        return statement;
    }

    public String getFichierBDD() {
        return fichierBDD;
    }

    public static ResultSet select(String selectSQL){
        System.out.println("[Status] " + selectSQL.split(" ")[0] + " command");
        java.sql.ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(selectSQL);
            System.out.println("[Status] Done");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public static void update(String selectSQL){
        System.out.println("[Status] " + selectSQL.split(" ")[0] + " command");
        try {
            statement.executeUpdate(selectSQL);
            System.out.println("[Status] Done");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void close(){
        try {
            statement.close();
            con.close();
            System.out.println("[Status] Connection closed");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
