import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/Creat-Account")

public class CreatAccount extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "jdbc:postgresql://psqlserv/but2";
        String nom = "hugostraseeleetu";
        String pwd = "moi";

        String login = request.getParameter("login");
        String psw = request.getParameter("mdp");

        PrintWriter out = response.getWriter();

        try (Connection con = DriverManager.getConnection(url, nom, pwd);
                PreparedStatement pstmt = con.prepareStatement(
                        "Insert into personne (username, password, role) values ( ?, ?,'util')")) {
            pstmt.setString(1, login);
            pstmt.setString(2, psw);

            try {
                pstmt.executeUpdate();
            } catch (Exception e) {
                out.println("<!doctype html>");
                out.println("<head><title>servlet Authent Failed</title></head><body><center> ");
                out.println("<h1>" + e.getLocalizedMessage() + "</h1>");
                out.println("<h1>" + e.getLocalizedMessage() + "</h1>");
                out.println("</body></html> ");
            }

            con.close();
        } catch (SQLException e) {

            out.println("<!doctype html>");
            out.println("<head><title>servlet Authent Failed</title></head><body><center> ");
            out.println("<h1>" + e.getLocalizedMessage() + "</h1>");
            out.println("</body></html> ");
        }

        response.sendRedirect("index.html");
    }
}
