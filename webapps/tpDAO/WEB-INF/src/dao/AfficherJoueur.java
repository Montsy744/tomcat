package dao;


public class AfficherJoueur {
    public static void main(String[] args) {
        
        JoueurDAO jDao = new JoueurDAO(new DS());
        Joueur j = jDao.findById(Integer.parseInt(args[0]));

        System.out.println(j);
    
    }
}
