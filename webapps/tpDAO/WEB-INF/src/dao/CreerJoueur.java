package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Creat-Joueur")
public class CreerJoueur extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int jno = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String mail = request.getParameter("email");
        String psw = request.getParameter("psw");
        int elo = Integer.parseInt(request.getParameter("elo"));

        JoueurDAO jDao = new JoueurDAO(new DS());
        Joueur j = new Joueur(jno, nom, mail, psw, elo);

        jDao.creat(j);
        

        response.sendRedirect("formulaireAjout.jsp");
    }
}
