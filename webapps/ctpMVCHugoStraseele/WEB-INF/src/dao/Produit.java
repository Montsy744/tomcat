package dao;

public class Produit {
    int id;
    String libelle;
    int prix;

    public Produit(int id, String l, int p) {
        this.id = id;
        this.libelle = l;
        this.prix = p;
    }

    public int getId() {
        return id;
    }
    public String getLibelle() {
        return libelle;
    }
    public int getPrix() {
        return prix;
    }
}
