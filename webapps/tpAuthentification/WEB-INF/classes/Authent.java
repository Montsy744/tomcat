import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

/*
Ecrire une page login.html contenant un formulaire de saisie du login et du mot de passe d’un
utilisateur et qui appelle une servlet Authent.java qui vérifie dans la base de données si cette
personne existe ou non et range un token dans la session de l’utilisateur quand il est connu
 */

@WebServlet("/Authent")
public class Authent extends HttpServlet {

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
            "SELECT * FROM personne WHERE username = ? AND password = ?;")
        ) {
            pstmt.setString(1, login);
            pstmt.setString(2, psw);

            System.out.println(pstmt);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    HttpSession session = request.getSession();
                    session.setAttribute("token", "CONNECTE");
                    session.setAttribute("userLogin", login);

                }
            }

            con.close();
        } catch (SQLException e) {

            out.println("<!doctype html>");
            out.println("<head><title>servlet Authent Failed</title></head><body><center> ");
            out.println("<h1>" + e.getLocalizedMessage() + "</h1>");
            out.println("</body></html> ");
        }
        // redirection vers Status.java
        response.sendRedirect("Statut");

    }

}
