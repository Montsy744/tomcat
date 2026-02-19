import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/Question_Magique")
public class mpOublier extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String url = "jdbc:postgresql://psqlserv/but2";
        String nom = "hugostraseeleetu";
        String pwd = "moi";

        String login = request.getParameter("login");
        String rep = request.getParameter("reponse");

        out.println("<!DOCTYPE html>");
        out.println("<html lang='fr'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Mot de passe oublié</title>");
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out.println("</head>");
        out.println("<body class='bg-light'>");

        if (login == null) {

            out.println("<main class='container mt-5'>");
            out.println("<div class='row justify-content-center'>");
            out.println("<div class='col-md-6'>");
            out.println("<div class='card p-4 shadow'>");

            out.println("<h3 class='mb-3 text-center'>Mot de passe oublié ?</h3>");
            out.println("<form action='Question_Magique'>");
            out.println("<div class='mb-3'>");
            out.println("<input class='form-control' name='login' placeholder='Login' type='text'>");
            out.println("</div>");
            out.println("<button class='btn btn-primary w-100'>Continuer</button>");
            out.println("</form>");

            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</main>");

            out.println("</body></html>");

        } else {

            try (Connection con = DriverManager.getConnection(url, nom, pwd);
                 PreparedStatement pstmt = con.prepareStatement(
                     "SELECT question,reponse FROM personne WHERE pseudo = ?;")
            ) {

                pstmt.setString(1, login);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {

                        String question = rs.getString("question");
                        String reponse = rs.getString("reponse");

                        if (rep == null) {

                            out.println("<main class='container mt-5'>");
                            out.println("<div class='row justify-content-center'>");
                            out.println("<div class='col-md-6'>");
                            out.println("<div class='card p-4 shadow'>");

                            out.println("<h4 class='mb-3 text-center'>" + question + "</h4>");
                            out.println("<form action='Question_Magique'>");
                            out.println("<input type='hidden' name='login' value='" + login + "'>");
                            out.println("<div class='mb-3'>");
                            out.println("<input class='form-control' name='reponse' placeholder='Votre réponse' type='text'>");
                            out.println("</div>");
                            out.println("<button class='btn btn-primary w-100'>Continuer</button>");
                            out.println("</form>");

                            out.println("</div>");
                            out.println("</div>");
                            out.println("</div>");
                            out.println("</main>");

                            out.println("</body></html>");

                        } else {

                            if (rep.equals(reponse)) {

                                HttpSession session = request.getSession();
                                session.setAttribute("token", "CONNECTE");
                                session.setAttribute("userLogin", login);

                                response.sendRedirect("Statut");

                            } else {

                                rep = null;
                                response.sendRedirect("Question_Magique");
                            }
                        }
                    }
                }

            } catch (SQLException e) {
                out.println("<!doctype html>");
                out.println("<head><title>servlet Authent Failed</title></head><body><center> ");
                out.println("<h1>" + e.getLocalizedMessage() + "</h1>");
                out.println("</body></html> ");
            }
        }
    }
}
