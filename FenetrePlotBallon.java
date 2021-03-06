import javax.swing.* ;
import java.awt.*;
import java.awt.event.* ;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.awt.geom.AffineTransform;

public class FenetrePlotBallon extends JFrame implements ActionListener, MouseListener, MouseMotionListener{
	
    // Attributs
	private Ballon monBallon;
	public Image background;
    private Timer monChrono;
    private double temps;
    private JPanel monBallonEnPositionInitial;
    private APoint pos;
    public APoint P;
    private double v0;
    private double theta;
    private boolean lancer;
    private int score;
    private int nbTir;
    private int nbEssais;
    public Ballon[] monTabBallon;
    LinkedList <APoint> Panneau;
    LinkedList <APoint> Poteau;
    LinkedList <APoint> Panier;


    // Constructeur
	public FenetrePlotBallon(Ballon b, Ballon[]unTabBallon, LinkedList<APoint> panneau, LinkedList<APoint> poteau, LinkedList <APoint>panier) {
		monBallon = b;
        temps = 0;
        v0=0;
        score=0;
        lancer=false;
        nbEssais=3; // Nombre d'essais disponibles
        nbTir=0;
        monTabBallon=unTabBallon;
        Panneau=panneau;
        Poteau=poteau;
        Panier=panier;
        
        monBallon.setPosition(new APoint(900, 500));

        
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

        monBallonEnPositionInitial=new JPanel();
        monBallonEnPositionInitial.setBounds((int)b.getPosition().x, (int)b.getPosition().y, (int)b.getRayon()*2, (int)b.getRayon()*2);
        monBallonEnPositionInitial.setVisible(true);
    
        // Bouton "invisible" 
        monBallonEnPositionInitial.setOpaque(true);
  
        // Add Listeners
        monBallonEnPositionInitial.addMouseListener(this);
        monBallonEnPositionInitial.addMouseMotionListener(this);

        // Ajout au conteneur principal
        disJPanel.add(monBallonEnPositionInitial);
        
		// Création du chronomètre
        monChrono = new Timer(10,this);

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
        
	}

    // Lancement du chronomètre
    public void lancement(){
        monChrono.start();
    }


    //Calcul de la trajectoire
    public void Trajectoire(Ballon b, double v0, double theta, double temps){
        
        P=b.getPosition();
        
        APoint Pold=P;
        theta=getRebond(P,Pold,theta);
        

        P.x=P.x+v0*Math.cos(theta)*temps;
        P.y=0.5*9.81*Math.pow(temps, 2)-v0*Math.sin(theta)*temps+P.y;
        monBallon.deplacement(P);
        if(EstDedans(b)) score++;
        repaint();
       
    } 


    //détection des rebonds avec le panier et les poteaux
    public double getRebond(APoint Pos,APoint oldP, double theta){
       

        double tBal=monBallon.getRayon()*2;
        
        for(APoint Pt: Panier){
            if(Pos.distance(Pt)<= tBal){
                
                theta=+Math.PI/2;
                return theta;
                
                }
        }

        for(APoint Pt: Poteau){
            if(Pos.distance(Pt)<= tBal){
                
               
                theta=+Math.PI;

                return theta;
                }
            }

        for(APoint Pt: Panneau){
            if(Pos.distance(Pt)<= tBal){
                
                theta=+Math.PI;
                    return theta;
            }
        }
        
        return theta;
    }

    //Tester si le panier est marqué
    public boolean EstDedans(Ballon b){
        boolean res = false;
        if ( ( (b.position.x + b.getRayon())>=1565) && ((b.position.x + b.getRayon())<=1645) &&  ( (b.position.y + b.getRayon())>= 450)&&( (b.position.y + b.getRayon())<= 510)  ){

            lancer=false;
            res = true;
            
            monBallon.setPosition(new APoint(900, 500));
            
        }
        return res;
    }

    // Timer
	public void actionPerformed(ActionEvent e){
        temps +=0.25;
         
        
        if (lancer==true){
            // A partir du moment où le ballon est lancé on calcule la position du ballon et on déplace le ballon à la position correspondante
            Trajectoire(monBallon, v0, theta, temps);
            
            // Quand le ballon touche le sol
            if(monBallon.getPosition().y>800){
                lancer=false;
                nbTir++;
                monBallon.setPosition(new APoint(900, 500));

                // Si le joueur a effectué tous ses lancers, le jeu est fini, on affiche la fenêtre des résultats
                if(nbTir>=nbEssais){
                    Gestion.fermer(this);
                    FenetreResultat maFrameResultat = new FenetreResultat(score, monTabBallon,Panneau,Poteau,Panier);
                }
            }
        }
        repaint();        
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        if(e.getSource()==monBallonEnPositionInitial){
            APoint p = new APoint(e.getPoint().getX(), e.getPoint().getY());
            v0 = pos.distance(p)*0.05;
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
        temps=0; //On lance à t=0
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