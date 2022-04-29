import java.util.LinkedList;

public class Panier {

    // Attributs
    
    public LinkedList<APoint> hitbox ;

    public Panier(){
        hitbox = null;
        for (int j=919;j>502;j--){ //poto du panier
            int i1=1758;
            hitbox.add(new APoint(i1,j));
        }
        for (int i=1758;i>1645;i--){ // bas du panneau
            int j1=502;
            hitbox.add(new APoint(i,j1));
        }
        for (int j=502;j>313;j--){ // hauteur du panneu
            int i2=1645;
            hitbox.add(new APoint(i2,j));
        }
        for (int i=1558;i>1565;i--){ // bord opposé du panier 
            int j2=1645;
            hitbox.add(new APoint(i,j2));
        }

    }

    // MERCI DE VITE METTRE UN BOOLEAN SVP POUR LA METHODE compteur
    
    // Méthodes
    
    public void getTrajectoire(){
        
    }

    /*public boolean EstDedans(ballon b){
        res = false;
        if ()
    } */

    public int compteur (boolean dedans){
        int score=0 ;
        if (dedans==true){
            score++;
        }
        return score;
    }
}