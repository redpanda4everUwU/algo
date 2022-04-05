import javax.swing.* ;
import java.awt.*;
import java.awt.event.* ;

public class FenetrePlotBallon extends JFrame implements ActionListener, MouseListener, MouseMotionListener{
	
    // Les attributs
	private Ballon monBallon ;
	public Image background;
    private Timer monChrono;
    private int temps;
    private JButton monBallonEnPositionInitial;

	public FenetrePlotBallon(Ballon b) {
		monBallon = b;
        temps = 0 ;
		this.setTitle("Ballon");
		this.setSize(1920, 1080);
		this.setLocation(0, 0);
		this.setResizable(false) ;
		

		Toolkit T = Toolkit.getDefaultToolkit();
		background = T.getImage("basket_ball_game_background.jpg");
		
		JPanel test = new JPanel();
		test.setLayout(null);
		test.setBounds(0,0,1920,1080);
        
        // Bouton pour pouvoir cliquer sur le ballon, on veut que le bouton ne soit pas visible mais qu'on puisse intéragir avec
        monBallonEnPositionInitial=new JButton();
        //en théorie juste mais les rayons ne correspondent pas à l'image
        monBallonEnPositionInitial.setBounds((int)b.getPosition().x, (int)b.getPosition().y, (int)b.getRayon()*2, (int)b.getRayon()*2);
        monBallonEnPositionInitial.setVisible(true);
        monBallonEnPositionInitial.addMouseListener(this);
        monBallonEnPositionInitial.addMouseMotionListener(this);
        test.add(monBallonEnPositionInitial);

		// Déclaration et création du chronomètre
        monChrono = new Timer(50,this);
        // Lancement du chronomètre
        monChrono.start();

		this.add(test);
		test.setVisible(true);
		this.setVisible(true);
		repaint();
		
	}
	
	
	// Effacer ballon
	public void effacerBallon(Ballon unBallon){
		monBallon = null ;
		repaint();
	}
	
	// Dessiner ballon
	public void paint(Graphics g) {
        g.drawImage(background, 0,0, null);
        //repaint();
        
		if (monBallon!=null){
            g.drawImage(monBallon.getDessin(), (int)monBallon.getPosition().x, (int)monBallon.getPosition().y, null);
           //monBallon.dessine(g);
           //repaint(); 
		}
       // repaint(); 
	}

    // Lancement du ballon
    public void lancement(){
        monChrono.start();
    }
	
    // Timer avec déplacement qui fonctionne
	public void actionPerformed(ActionEvent e){
        temps += 50; // Pb, ne s'arrête pas quand je ferme la fenêtre secondaire !
        System.out.println("Mouvement en cours depuis "+temps+ "ms");
        // this.setTitle("IHM Courbe - Graphisme / temps : "+temps); Je sais pas à quoi ça sert 
        if (monBallon!=null)
            //monBallon.deplaceY(10);
        repaint();
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
	
}	
/*
import javax.swing.* ;
import java.awt.*;
 

public class FenetrePlotBallon extends JFrame implements ActionListener{
    
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
    
    // Afficher la fenêtre de jeu : dessiner ballon + background
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        if (monBallon!=null)
            monBallon.dessine(g);
        
        }
    
    
}    
*/