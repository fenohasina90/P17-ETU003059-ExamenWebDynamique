package main.java.ETU003059;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DAOEtat extends HttpServlet {
    
    private Connection getConnection() throws SQLException {
        // String url = "jdbc:mysql://localhost:3306/examen_servlet";
        // String user = "root"; 
        // String password = ""; 


        String url = "jdbc:mysql://172.80.237.54:3306/db_s2_ETU003059";
        String user = "ETU003059"; 
        String password = "UI0he7Ff"; 
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = Connect.getConnection();
            
            String sql = "SELECT p.libelle AS libelle_prevision, " +
                         "p.montatnt AS montant_previsionnel, " +
                         "SUM(d.montatnt) AS total_depenses, " +
                         "(p.montatnt - SUM(d.montatnt)) AS reste " +
                         "FROM prevision p " +
                         "LEFT JOIN depense d ON p.id = d.libelle " +
                         "GROUP BY p.id, p.libelle, p.montatnt";
            
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title></title>");
            out.println("<style>");
            out.println("table");
            out.println("th, td ");
            out.println("th ");
            out.println("tr:nth-child(even)");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>etat</h1>");
            
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Cat</th>");
            out.println("<th>libele</th>");
            out.println("<th>depense</th>");
            out.println("<th>rest</th>");
            out.println("</tr>");
            
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString("libelle_prevision") + "</td>");
                out.println("<td>" + rs.getInt("montant_previsionnel") + "</td>");
                out.println("<td>" + rs.getInt("total_depenses") + "</td>");
                out.println("<td>" + rs.getInt("reste") + "</td>");
                out.println("</tr>");
            }
            
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            
        } catch (SQLException e) {
            e.printStackTrace();
           
        } 
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        doGet(req, res);
    }
}