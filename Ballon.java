
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
        g.setColor(Color.BLUE);
        g.drawImage(this.image,0,0,null);
        System.out.println(g.drawImage(this.image,0,0,null));
        g.fillOval((int) (this.position.x - this.rayon), (int) (this.position.y - this.rayon), (int) (2*this.rayon), (int) (2*this.rayon));

    }
}

