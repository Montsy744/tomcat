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
import dto.Ingredient;


@WebServlet("/ingredient/*")
public class IngredientRestApi extends HttpServlet {

    IngredientDao ingredientDao = new IngredientDao();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();

        String info = request.getPathInfo();
        //code pour un get général
        if(info == null || info.equals("/")){
            String jsonString = objectMapper.writeValueAsString(ingredientDao.findAll());
            out.println(jsonString);
            return;
        }

        //code pour un get avec id
        String[] splits = info.split("/");
        if (splits.length != 2) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        int id = Integer.parseInt(splits[1]);
        Ingredient ingredient = ingredientDao.findById(id);
        if (ingredient==null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        out.print(objectMapper.writeValueAsString(ingredient));
        return;

    }
}
