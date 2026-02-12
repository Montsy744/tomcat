package dao;

import java.util.ArrayList;

import dto.Ingredient;

public class IngredientDao {

    ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

    public IngredientDao() {
        this.ingredients.add(new Ingredient(1, "jambon", 0.0));
        this.ingredients.add(new Ingredient(2, "tomates", 10.50));
    }

    public ArrayList<Ingredient> findAll() {
        return this.ingredients;
    }

    public Ingredient findById(int id) {
        for(int i=0; i<this.ingredients.size(); i++) {
            if(this.ingredients.get(i).getId() == id) {
                return this.ingredients.get(i);
            }
        }
        return null;
    }

    public void save(Ingredient i) {
        this.ingredients.add(i);
    }
}