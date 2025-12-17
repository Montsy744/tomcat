import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/S4")
public class S4 extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String url = "jdbc:postgresql://psqlserv/but2";
        String nom = "hugostraseeleetu";
        String pwd = "moi";
        
        HttpSession session = request.getSession();
        String age = (String) session.getAttribute("age");
        String emploie = (String) session.getAttribute("situation");
        String nom2 = (String) session.getAttribute("nom");
        String[] sport = (String[]) session.getAttribute("sport");

        String sports = "";
        for(int i = 0; i < sport.length; i++) {
            sports = sports + " " +  sport[i];
        }

        try (Connection con = DriverManager.getConnection(url, nom, pwd);
            PreparedStatement pstmt = con.prepareStatement(
            "Update personn set age=? , situation=? , sports=? Where login=?")
        ) {
            pstmt.setInt(1, Integer.parseInt(age));
            pstmt.setString(2, emploie);
            pstmt.setString(3, sports);
            pstmt.setString(4,nom2);
            try {
                pstmt.executeUpdate();
            } catch (Exception e) {
                out.println("<!doctype html>");
                out.println("<head><title>servlet Authent Failed</title></head><body><center> ");
                out.println("<h1>" + e.getLocalizedMessage() + "</h1>");
                out.println("</body></html> ");
            }
        }catch (SQLException e) {
            out.println("<!doctype html>");
            out.println("<head><title>servlet Authent Failed</title></head><body><center> ");
            out.println("<h1>" + e.getMessage() + "</h1>");
            out.println("</body></html> ");
        }

        response.sendRedirect("Synthese");



    }
}
