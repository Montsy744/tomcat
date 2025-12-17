import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/S5b")
public class S5b extends HttpServlet {

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
            "SELECT * FROM personn WHERE login = ? AND mdp = ?;")
        ) {
            pstmt.setString(1, login);
            pstmt.setString(2, psw);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    HttpSession session = request.getSession();
                    session.setAttribute("nom", login); 

                    response.sendRedirect("Sla");
                } else  {
                    response.sendRedirect("S5a?t=true");
                }
            }

            con.close();
        } catch (SQLException e) {
            out.println("<!doctype html>");
            out.println("<head><title>servlet Authent Failed</title></head><body><center> ");
            out.println("<h1>" + e.getLocalizedMessage() + "</h1>");
            out.println("</body></html> ");
        }
        

    }

}

