import javax.swing.* ;
import java.awt.*;
import java.awt.event.* ;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;


public class FenetrePlotBallon extends JFrame implements ActionListener, MouseListener, MouseMotionListener{
	
    // Attributs
	private Ballon monBallon;
	public Image background;
    private Timer monChrono;
    private double temps;
    private JButton monBallonEnPositionInitial;
    private APoint pos;
    public APoint P;
    private double v0;
    private double theta;
    private boolean lancer;
    private int score;
    private int nbTir;
    private int nbEssais;
    public Ballon[] monTabBallon;

    // Constructeur
	public FenetrePlotBallon(Ballon b, Ballon[]unTabBallon) {
		monBallon = b;
        temps = 0;
        v0=0;
        score=0;
        lancer=false;
        nbEssais=3; // Nombre d'essais disponibles
        nbTir=0;
        monTabBallon=unTabBallon;
        
		this.setTitle("Ballon");
		this.setSize(1920, 1080);
		this.setLocation(0, 0);
		this.setResizable(false);
        this.addMouseListener(this);
		

		Toolkit T = Toolkit.getDefaultToolkit();
		background = T.getImage("basket_ball_game_background.jpg");
		
		JPanel disJPanel = new JPanel();
		disJPanel.setLayout(null);
		disJPanel.setBounds(0,0,1920,1080);
        
        // Bouton pour pouvoir cliquer sur le ballon : on veut que le bouton ne soit pas visible mais qu'on puisse intéragir avec
        monBallonEnPositionInitial=new JButton();
        monBallonEnPositionInitial.setBounds((int)b.getPosition().x, (int)b.getPosition().y, (int)b.getRayon()*2, (int)b.getRayon()*2);
        monBallonEnPositionInitial.setVisible(true);
        
        // Bouton "invisible"
        monBallonEnPositionInitial.setOpaque(true);
        monBallonEnPositionInitial.setContentAreaFilled(false);
        monBallonEnPositionInitial.setBorderPainted(false);

        // Add Listeners
        monBallonEnPositionInitial.addMouseListener(this);
        monBallonEnPositionInitial.addMouseMotionListener(this);

        // Ajout au conteneur principal
        disJPanel.add(monBallonEnPositionInitial);
        
		// Création du chronomètre
        monChrono = new Timer(75,this);

        //Ajout du conteneur main à la fenêtre
		this.add(disJPanel);
		disJPanel.setVisible(true);
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
        //Graphics2D g2 = (Graphics2D) g;
        BufferedImage imagePreparation = new BufferedImage(1920, 1080, BufferedImage.TYPE_INT_RGB);

        Graphics2D  imagePreparationGraphics = (Graphics2D) imagePreparation.getGraphics();

        AffineTransform reset = imagePreparationGraphics.getTransform();
        imagePreparationGraphics.drawImage(background, 0,0, null);

        
		if (monBallon!=null){
           imagePreparationGraphics.drawImage(monBallon.getDessin(), (int)monBallon.getPosition().x+getInsets().left, (int)monBallon.getPosition().y+getInsets().top, null);
         
		}
        imagePreparationGraphics.setTransform(reset);
        g.drawImage(imagePreparation, 0, 0, this);
        

            APoint [] previsualisation = new APoint [10];
            for(int i=0; i<10; i++){
                previsualisation[i]=.x=P.x+v0*Math.cos(theta)*temps;
                previsualisation[i].y=0.5*9.81*Math.pow(temps, 2)-v0*Math.sin(theta)*temps+P.y;
                
               // g.fillOval((int)previsualisation[i].x, (int)previsualisation[i].y, 100, 100);
            }
	}

    // Lancement du chronomètre
    public void lancement(){
        monChrono.start();
    }

    public void Trajectoire(Ballon b, double v0, double theta, double temps){
        P=b.getPosition();

        P.x=P.x+v0*Math.cos(theta)*temps;
        P.y=0.5*9.81*Math.pow(temps, 2)-v0*Math.sin(theta)*temps+P.y;
    } 

    // Timer avec déplacement qui fonctionne
	public void actionPerformed(ActionEvent e){
        temps += 1; 
        if (lancer==true){
            // A partir du moment où le ballon est lancé on calcule la position du ballon et on déplace le ballon à la position correspondante
            Trajectoire(monBallon, v0, theta, temps);
            monBallon.deplacement(P);

            System.out.println(temps);
            System.out.println(monBallon.getPosition());

            // Quand le ballon touche le sol
            if(monBallon.getPosition().y>800){
                lancer=false;
                nbTir++;

                // Si le joueur a effectué tous ses lancers, le jeu est fini, on affiche la fenêtre des résultats
                if(nbTir>=nbEssais){
                    Gestion.fermer(this);
                    FenetreResultat maFrameResultat = new FenetreResultat(score, monTabBallon);
                    monBallon.setPosition(new APoint(900, 500));
                } else { // Sinon on remets la balle au centre pour effectuer un nouveau lancer
                    monBallon.setPosition(new APoint(900, 500));
                }
            }
        }
        repaint();        
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        if(e.getSource()==monBallonEnPositionInitial){
            APoint p = new APoint(e.getPoint().getX(), e.getPoint().getY());
            v0 = pos.distance(p)*0.10;
            theta=-Math.atan2(p.y-pos.y,p.x-pos.x); 
            System.out.println(v0 +"et" +theta);
        }
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
        if(e.getSource()==monBallonEnPositionInitial){
            pos = new APoint(e.getPoint().getX(), e.getPoint().getY());
        }
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        //lancement du ballon
        //On lance à t=0
        temps=0;
        lancer=true;
        System.out.println(monBallon.getPosition());
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