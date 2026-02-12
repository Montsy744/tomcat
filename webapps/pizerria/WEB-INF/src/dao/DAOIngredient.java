package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.Ingredient;

public interface DAOIngredient {
    public ArrayList<Ingredient> findAll();
    public Ingredient findById(int id) throws SQLException;
    public boolean save(Ingredient i) throws SQLException;
}
