
import java.awt.*;


public class Ballon {

    // Attributs
    
    private double masse ;
    private double rayon ;
    private APoint position ;
    private Image image;
    // Constructeur

    public Ballon (double m, double r,Image i, APoint p){
        this.masse = m ;
        this.rayon = r ;
        this.image = i ;
        this.position = p ;
    }
    
    // Getter
    
    public double getMasse(){
        return this.masse ;
    }
    
    public double getRayon(){
        return this.rayon ;
    }
    
    public Image getDessin(){
        return this.image ;
    }
    
    // Méthodes
    
    public void dessine (Graphics g){
        g.drawImage(this.image,700,400,null);

    }
}

