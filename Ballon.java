import java.awt.*;

public class Ballon {

    // Attributs
    private double masse ;
    private double rayon ;
    public APoint position ;
    private Image image;
    
    // Constructeur
    public Ballon (double m, double r, Image i, APoint p){
        this.masse = m ;
        this.rayon = r ;
        this.image = i ;
        this.position = p ;
    }
    
    // Getters
    public double getMasse(){
        return this.masse ;
    }
    
    public double getRayon(){
        return this.rayon ;
    }
    
    public Image getDessin(){
        return this.image ;
    }
    
    public APoint getPosition(){
        return this.position;
    }
    
    // Setter
    public void setPosition(APoint pos){
        position=pos;
    }
    
    // Méthodes
    public void dessine(Graphics g){
        g.drawImage(image,0,0,null);
    }

    public void deplacement(APoint p){
        position.x=p.x;
        position.y=p.y; 
    }
}

