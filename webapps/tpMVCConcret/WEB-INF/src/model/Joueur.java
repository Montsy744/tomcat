package model;

import java.io.Serializable;

public class Joueur implements Serializable{

    private int id;
    private String nom;
    private String email;
    private String psw;
    private int elo;

    public Joueur(int id, String nom, String email, String psw, int elo) {
        this.elo = elo;
        this.email = email;
        this.id = id;
        this.nom = nom;
        this.psw = psw;
    }

    public int getId() {
        return id;
    }
    public int getElo() {
        return elo;
    }
    public String getEmail() {
        return email;
    }
    public String getNom() {
        return nom;
    }
    public String getPsw() {
        return psw;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setElo(int elo) {
        this.elo = elo;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPsw(String psw) {
        this.psw = psw;
    }

    @Override
    public String toString() {
        return "Joueur :" + this.getNom() + " | " + this.getEmail() + " | " + this.getId() + " | " + this.getElo();
    }
}
