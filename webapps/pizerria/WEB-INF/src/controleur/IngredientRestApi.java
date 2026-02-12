package controleur;

import java.io.IOException;
import java.io.PrintWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.IngredientDao;


@WebServlet("/ingredients")
public class IngredientRestApi extends HttpServlet {

    IngredientDao ingredientDao = new IngredientDao();
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        response.setContentType("application/json");

        ObjectMapper objectMapper = new ObjectMapper();
        out.println(objectMapper.writeValueAsString(ingredientDao.findAll()));

    }
}
