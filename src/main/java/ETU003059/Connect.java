package main.java.ETU003059;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    // private static final String URL = "jdbc:mysql://localhost:3306/examen_servlet";
    // private static final String USER = "root"; 
    // private static final String PASSWORD = "";

    private static final String URL = "jdbc:mysql://172.80.237.54:3306/db_s2_ETU003059";
    private static final String USER = "ETU003059"; 
    private static final String PASSWORD = "UI0he7Ff"; 
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion réussie !");
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur : Driver MySQL non trouvé !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données !");
            e.printStackTrace();
        }
        return conn;
    }
}
