package controleur;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DS;
import model.Joueur;
import model.JoueurDAO;
import model.PartieDAO;

@WebServlet("/Control")
public class controler extends HttpServlet {
    PartieDAO daoPartie = new PartieDAO(new DS());
    JoueurDAO daoJoueur = new JoueurDAO(new DS());

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String vue;

        switch (action) {

            case "voir":
                int id = Integer.parseInt(req.getParameter("id"));

                int jno1 = daoPartie.findById(id).getJno1();
                int jno2 = daoPartie.findById(id).getJno2();

                Joueur j1 = daoJoueur.findById(jno1);
                Joueur j2 = daoJoueur.findById(jno2);

                req.setAttribute("joueur1", j1);
                req.setAttribute("joueur2", j2);
                vue = "WEB-INF/vue/voir.jsp";
                break;


            case "modifier":
                vue = "WEB-INF/vue/modiff.jsp";
                break;

                
            default :
                resp.sendError(400,"Action non supportée choisissez liste ou vignette" ); return;
        }
        req.getRequestDispatcher(vue).forward(req,resp);
    }
}