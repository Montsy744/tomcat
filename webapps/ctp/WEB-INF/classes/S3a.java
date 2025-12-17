import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/S3a")
public class S3a extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String url = "jdbc:postgresql://psqlserv/but2";
        String nom = "hugostraseeleetu";
        String pwd = "moi";

        try (Connection con = DriverManager.getConnection(url, nom, pwd);
            PreparedStatement pstmt = con.prepareStatement(
            "SELECT * FROM sport;")
        ) {

            try (ResultSet rs = pstmt.executeQuery()) {
                out.println("<form action=S3b >");
                while (rs.next()) {
                    String sport = rs.getString("nom");
                    out.println("<p>"+sport+"<input name=sport type=checkbox value="+sport+" ></p>");
                }
                out.println("<input type=submit>");
                out.println("</form>");
            }
        }catch (SQLException e) {
            out.println("<!doctype html>");
            out.println("<head><title>servlet Authent Failed</title></head><body><center> ");
            out.println("<h1>" + e.getMessage() + "</h1>");
            out.println("</body></html> ");
        }



    }
}

