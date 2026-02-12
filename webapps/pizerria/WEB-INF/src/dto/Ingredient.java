package dto;

public class Ingredient {
    public int id;
    public String nom;
    public int prix;

    public Ingredient(int id, String nom, int prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    public Ingredient() {}

    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public int getPrix() {
        return prix;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrix(int prix) {
        this.prix = prix;
    }

}
