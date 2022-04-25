import javax.swing.* ;
import java.awt.*;
import java.awt.event.* ;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;


public class FenetrePlotBallon extends JFrame implements ActionListener, MouseListener, MouseMotionListener{
	
    // Les attributs
	private Ballon monBallon ;
	public Image background;
    private Timer monChrono;
    private double temps;
    private JButton monBallonEnPositionInitial;
    private APoint pos;
    public APoint P;
    private double v0;
    private double theta;
    private boolean lancer;

	public FenetrePlotBallon(Ballon b) {
		monBallon = b;
        temps = 0;
        v0=0;
        lancer=false;
		this.setTitle("Ballon");
		this.setSize(1920, 1080);
		this.setLocation(0, 0);
		this.setResizable(false);
		

		Toolkit T = Toolkit.getDefaultToolkit();
		background = T.getImage("basket_ball_game_background.jpg");
		
		JPanel disJPanel = new JPanel();
		disJPanel.setLayout(null);
		disJPanel.setBounds(0,0,1920,1080);
        
        // Bouton pour pouvoir cliquer sur le ballon, on veut que le bouton ne soit pas visible mais qu'on puisse intéragir avec
        monBallonEnPositionInitial=new JButton();
        monBallonEnPositionInitial.setBounds((int)b.getPosition().x, (int)b.getPosition().y, (int)b.getRayon()*2, (int)b.getRayon()*2);
        monBallonEnPositionInitial.setVisible(true);
        monBallonEnPositionInitial.setOpaque(false);
        monBallonEnPositionInitial.setContentAreaFilled(false);
        monBallonEnPositionInitial.setBorderPainted(false);
        monBallonEnPositionInitial.addMouseListener(this);
        monBallonEnPositionInitial.addMouseMotionListener(this);
        disJPanel.add(monBallonEnPositionInitial);

        this.addMouseListener(this);
        
		// Déclaration et création du chronomètre
        monChrono = new Timer(75,this);

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
        Graphics2D g2 = (Graphics2D) g;
        BufferedImage imagePreparation = new BufferedImage(1920, 1080, BufferedImage.TYPE_INT_RGB);

        Graphics2D  imagePreparationGraphics = (Graphics2D) imagePreparation.getGraphics();

        AffineTransform reset = imagePreparationGraphics.getTransform();
        imagePreparationGraphics.drawImage(background, 0,0, null);

       // g.drawImage(background, 0,0, null);
        
		if (monBallon!=null){
           imagePreparationGraphics.drawImage(monBallon.getDessin(), (int)monBallon.getPosition().x+getInsets().left, (int)monBallon.getPosition().y+getInsets().top, null); 
		}
        imagePreparationGraphics.setTransform(reset);
        g.drawImage(imagePreparation, 0, 0, this);

        /*if(enclenche){
            for(int i=0; i<10; i++){
                Traj.P.x=Traj.P.x+v0*Math.cos(theta)*(temps+i);
                Traj.P.y=0.5*9.81*Math.pow((temps+i), 2)-v0*Math.sin(theta)*(temps+i)+Traj.P.y;
                g.fillOval((int)Traj.P.x, (int)Traj.P.y, 10, 10);
            }
        }*/
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
        temps += 0.5; // Pb, ne s'arrête pas quand je ferme la fenêtre secondaire !
        if (lancer==true){
            //à partir du moment où le ballon est lancé on calcule la position du ballon et on déplace le ballon à la position correspondante
            Trajectoire(monBallon, v0, theta, temps);
            monBallon.deplacement(P);
            System.out.println(temps);
            System.out.println(monBallon.getPosition());
            if(monBallon.getPosition().y>800){
                lancer=false;
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
            //Traj=new Trajectoire(monBallon,v0,theta,temps);
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