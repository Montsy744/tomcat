package controleur;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Dao;

@WebServlet("/Gestion")
public class Controleur extends HttpServlet {

    Dao dao = new Dao();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String vue = "index.html";

        switch (action) {
            case "vignette":
                int id = Integer.parseInt(request.getParameter("id")) - 1;
                String elmt = dao.findById(id);
                request.setAttribute("element", elmt);
                vue = "WEB-INF/vue/vignette.jsp";
                break;
            case "liste":
                ArrayList<String> elmts = dao.findAll();
                request.setAttribute("elements", elmts);
                vue = "WEB-INF/vue/list.jsp";
                break;
            default:
                response.sendError(400,"Action non supportée choisissez liste ou vignette" ); return;
        }

        request.getRequestDispatcher(vue).forward(request,response);
    }
}
