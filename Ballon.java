import javax.swing.*;
import java.awt.*;


public class Ballon {

    // Attributs
    
    private double masse ;
    private double rayon ;
    private APoint position ;
    private Image image;
    // Constructeur

    public Ballon (double m, double r, Image i, APoint p){
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
    
    public void dessine(Graphics g){
        g.drawImage(image,960,850,null);
       // System.out.println(g.drawImage(image,960,850,null));
        //g.fillOval((int) (this.position.x - this.rayon), (int) (this.position.y - this.rayon), (int) (2*this.rayon), (int) (2*this.rayon));

    }

    public void deplaceY(int deltaY){
        position.y+=deltaY;
    }

}

