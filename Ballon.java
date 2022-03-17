import java.util.* ;
import java.awt.*;

public class Ballon {

    // Attributs
    
    private double masse ;
    private double rayon ;
    private Color couleur ;
    private APoint position ;
    
    // Constructeur

    public Ballon (double m, double r, Color c, APoint p){
        this.masse = m ;
        this.rayon = r ;
        this.couleur = c ;
        this.position = p ;
    }
    
    // Getter
    
    public double getMasse(){
        return this.masse ;
    }
    
    public double getRayon(){
        return this.rayon ;
    }
    
    public Color getCouleur(){
        return this.couleur ;
    }
    
    // Méthodes
    
    public void dessine (Graphics g){
        g.setColor(this.couleur);
        g.fillOval((int) (this.position.x - this.rayon), (int) (this.position.y - this.rayon), (int) (2*this.rayon), (int) (2*this.rayon));
    }
}

