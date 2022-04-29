import javax.swing.* ;
import java.awt.*;
import java.awt.event.*;

public class FenetreResultat extends JFrame implements ActionListener {

    // Les Attributs (pour ne pas qu'ils soient des variables)
   
   private JLabel message ;
   private JPanel nombre ;
   private int score ;
   private JLabel texte ;
   private JButton menu ;
   private Ballon[] monTabBallon ;
  
   // Constructeur
   public FenetreResultat(int score, Ballon[]unTabBallon){

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

       // Affichage du score mais je suis en train de chercher
       nombre = new JPanel(); // Mettre le numéro du score dedans 
       nombre.setBounds(150, 60, 100, 50);
       nombre.setBackground(Color.cyan);
       m.add(nombre);

       // Bouton de retour au menu
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
           FenetreSelectionBallonCombo monMenu = new FenetreSelectionBallonCombo(monTabBallon);
           monMenu.setVisible(true);
           
       }
   }
}
