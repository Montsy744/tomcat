package controler;

import java.io.IOException;
import java.util.ArrayList;

import dao.DS;
import dao.Produit;
import dao.ProduitDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Gestion")
public class Controleur extends HttpServlet {
    
    ArrayList<Produit> Panier = new ArrayList<Produit>();
    
    ProduitDao dao = new ProduitDao(new DS());

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String vue = "WEB-INF/vue/caddie.jsp";
        ArrayList<Produit> elmt = dao.findAll();

        HttpSession session = request.getSession();
        
        switch (action) {
            case "caddie":
                session.setAttribute("element", elmt);
                break;

            case "caddieVide":
                session.setAttribute("element", elmt);
                int i = 0;
                while(!Panier.isEmpty()) {
                    Panier.remove(i);
                    i++;
                };
                break;
                

            case "caddieRempli":
                session.setAttribute("element", elmt);
                int id =Integer.parseInt(request.getParameter("id"));
                Produit p = dao.findById(id);
                Panier.add(p);
                break;

            default:
                response.sendError(400,"Action non supportée choisissez la bonne action" ); return;
        }
        session.setAttribute("panier", Panier);
        request.getRequestDispatcher(vue).forward(request,response);
    }
}
