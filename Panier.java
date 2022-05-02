import java.util.LinkedList;

public class Panier {

    // Attributs
    int score=0 ;
    public LinkedList<APoint> Poteau ;
    public LinkedList<APoint> Panneau;
    public LinkedList<APoint> Panier;

    public Panier(){
        Poteau = null;
        Panneau = null;
        Panier = null;
        for (int j=919;j>502;j--){ // Poteau du panier
            int i1=1758;
            Poteau.add(new APoint(i1,j));
        }

        for (int j=502;j>313;j--){ // Hauteur du panneu
            int i2=1645;
            Panneau.add(new APoint(i2,j));
        }
        for (int i=1558;i<1565;i++){ // Bord opposé du panier 
            int j2=1645;
            Panier.add(new APoint(i,j2));
        }

    }
    
    // Méthodes dont getter
    public void getTrajectoire(){
    }

    /*public boolean EstDedans(ballon b){
        res = false;
        if ()
    } */

    public int compteur (boolean dedans){
        
        if (dedans==true){
            score++;
        }
        return score;
    }
}