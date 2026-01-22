package dao;

import java.io.Serializable;

public class Joueur implements Serializable{

    private String nom;
    private String email;
    private String psw;
    private int elo;

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
        return "Joueur :" + this.getNom() + " | " + this.getEmail() + " | " + this.getElo();
    }
}
