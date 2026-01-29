package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Partie implements Serializable {
    private int no;
    private int jno1;
    private int jno2;
    private LocalDate date;
    private String statut;
    private int temps;
    private int gagnant;

    public Partie(int no, int jno1, int jno2, LocalDate date, String statut, int temps, int gagnant) {
        this.no = no;
        this.jno1 = jno1;
        this.jno2 = jno2;
        this.date = date;
        this.statut = statut;
        this.temps = temps;
        this.gagnant = gagnant;
    }

    public LocalDate getDate() {
        return date;
    }
    public int getJno1() {
        return jno1;
    }
    public int getJno2() {
        return jno2;
    }
    public int getGagnant() {
        return gagnant;
    }
    public String getStatut() {
        return statut;
    }
    public int getTemps() {
        return temps;
    }
    public int getNo() {
        return no;
    }
}
