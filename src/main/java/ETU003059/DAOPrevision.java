package main.java.ETU003059;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
public class DAOPrevision extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String libelle = req.getParameter("prev");
        int montant =Integer.parseInt(req.getParameter("mont"));
        Prevision prev = new Prevision(libelle, montant);
        
        try (Connection conn = Connect.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO prevision (libelle,montatnt) VALUES (?,?)")) {
            
            stmt.setString(1, prev.getLibelle());
            stmt.setInt(2, prev.getMontant());
            stmt.executeUpdate();
            
            res.sendRedirect("prevision.jsp");
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
