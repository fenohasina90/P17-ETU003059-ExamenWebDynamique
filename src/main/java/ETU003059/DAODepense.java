package main.java.ETU003059;
import java.util.ArrayList;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;





public class DAODepense extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        int  libelle = Integer.parseInt(req.getParameter("libelle"));
        int montant = Integer.parseInt(req.getParameter("montant")) ;
        Depense dep = new Depense(libelle, montant);



        int total=0;
        String sql2="SELECT (p.montatnt - SUM(d.montatnt)) AS reste FROM prevision p LEFT JOIN depense d ON p.id = d.libelle WHERE d.libelle=?;";


        // String sql1 = "SELECT SUM(d.montatnt) AS total_depenses (p.montatnt - SUM(d.montatnt)) AS reste FROM prevision p LEFT JOIN depense d ON p.id = d.libelle  GROUP BY p.id, p.libelle, p.montatnt;";
        try (Connection conn = Connect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql2)) {
            stmt.setInt(1, dep.getLibelle());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
               total=rs.getInt("reste");
               break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (montant < total || total==0) {
            try (Connection conn = Connect.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO depense (libelle,montatnt) VALUES (?,?)")) {
           
           stmt.setInt(1, (Integer)dep.getLibelle());
           stmt.setInt(2, (Integer)dep.getMontant());
           stmt.executeUpdate();

           res.sendRedirect("depense.jsp");
           
           
       } catch (SQLException e) {
           e.printStackTrace();
       }
        }
        else{
            out.println("le montant depasse le solde");
        }

      
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try { 
              ArrayList<Prevision> select = Depense.getAllPrev();
              HttpSession session = req.getSession();
              session.setAttribute("select", select);
              RequestDispatcher dispatcher = req.getRequestDispatcher("formDepense.jsp");
              dispatcher.forward(req, res);
            
          } catch (Exception e) {
            e.printStackTrace();
          }
        
    }
}
