import java.util.LinkedList;

public class Panier {

    // Attributs
    
    public LinkedList<APoint> hitbox ;

    public Panier(){
        hitbox = null;
        for (int j=161;j<593;j++){
            int i=155;
            hitbox.add(new APoint(i,j));
        }
        for (int i=155;i<251;i++){
            int j=593;
            hitbox.add(new APoint(i,j));
        }
        for (int j=593;j<761;j++){
            int i=251;
            hitbox.add(new APoint(i,j));
        }
    }
    
    // Méthodes
    
    public void getTrajectoire(){
        
    }
}
