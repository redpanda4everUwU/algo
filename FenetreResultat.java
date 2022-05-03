import javax.swing.* ;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class FenetreResultat extends JFrame implements ActionListener {

   // Attributs (pour ne pas qu'ils soient des variables)
   private JLabel message ;
   private JPanel nombre ;
   private int score ;
   private JLabel pointsmarques ;
   private JLabel texte ;
   private JButton menu ;
   private Ballon[] monTabBallon ;
   LinkedList <APoint> Panneau;
   LinkedList <APoint> Poteau;
   LinkedList <APoint> Panier;
   // Constructeur
   public FenetreResultat(int score, Ballon[]unTabBallon,LinkedList<APoint> panneau, LinkedList<APoint> poteau, LinkedList <APoint>panier){

        Panneau=panneau;
        Poteau=poteau;
        Panier=panier;    

       this.score = score ;
       this.monTabBallon=unTabBallon;
      
       // La Fenêtre
       this.setTitle("Fenêtre du résultat");
       this.setSize(400, 300);
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setResizable(false);

       // Petit conteneur main car c'est plus joli
       JPanel m = new JPanel() ;
       m.setLayout(null);
       m.setBounds(10,10,380,280);
       m.setBackground(Color.gray);
       this.add(m);

       // Texte 1
       message = new JLabel("Oh non vous avez perdu... Votre score est de : ") ;
       message.setBounds(60, 10, 300, 50);
       m.add(message);

       // Texte 2
       texte = new JLabel("Pour rejouer, clicker ici et bonne chance ^^") ;
       texte.setBounds(80, 115, 300, 50);
       m.add(texte);

       // Panel pour mettre en avant les points marqués
       nombre = new JPanel(); 
       nombre.setBounds(150, 60, 100, 50);
       nombre.setBackground(Color.cyan);
       m.add(nombre);

       // Affichage du score
       System.out.println("Score : " + score);
       pointsmarques = new JLabel(Integer.toString(score)) ;
       pointsmarques.setBounds(0, 50, 100, 50);
       nombre.add(pointsmarques);

       // Bouton pour retourner au menu
       menu = new JButton("Menu");
       menu.setBounds(120, 165, 160, 70);
       menu.setBackground(Color.green);
       m.add(menu);
       menu.addActionListener(this);
    
       this.setVisible(true);
      
   }
  
   // Méthodes dont événements
   public void actionPerformed(ActionEvent e) {
       System.out.println(this.score);
       
       if (e.getSource()==menu){
           System.out.println("Click sur Menu");
           Gestion.fermer(this);
           FenetreSelectionBallonCombo monMenu = new FenetreSelectionBallonCombo(monTabBallon,Panneau,Poteau,Panier);
           monMenu.setVisible(true);
           
       }
   }
}
