import javax.swing.* ;
 import java.awt.*;

public class FenetrePlotBallon extends JFrame{
    
    private Ballon monBallon ;

    public FenetrePlotBallon() {
        this.setTitle("Ballon");
        this.setSize(800, 800);
        this.setLocation(800, 200);
        this.setResizable(false) ;
        this.setVisible(false);
    }
    
    public void choixBallon (Ballon unBallon){
        monBallon = unBallon ;
        repaint();
    }
    
    // Effacer ballon
    public void effacerBallon(Ballon unBallon){
        monBallon = null ;
        repaint();
    }
    
    // Dessiner ballon
    public void paint(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        if (monBallon!=null)
            monBallon.dessine(g);
        }
}    
