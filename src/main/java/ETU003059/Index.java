package main.java.ETU003059;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Index extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
}