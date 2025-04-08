package main.java.ETU003059;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {
    // private static final String DB_URL = "jdbc:mysql://localhost:3306/examen_servlet";
    // private static final String DB_USER = "root"; 
    // private static final String DB_PASSWORD = "";


     private static final String DB_URL = "jdbc:mysql://172.80.237.54:3306/db_s2_ETU003059";
     private static final String DB_USER = "ETU003059"; 
     private static final String DB_PASSWORD = "UI0he7Ff"; 

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            response.sendRedirect("login.jsp?error=Nom d'utilisateur et mot de passe requis");
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    response.sendRedirect("welcome.jsp");
                } else {
                    response.sendRedirect("login.jsp?error=Identifiants incorrects");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=Erreur de base de données");
        }
    }

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException("Driver MySQL non trouvé", e);
        }
    }
}
