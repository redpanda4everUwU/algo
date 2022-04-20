import javax.swing.* ;
import java.awt.*;
import java.awt.event.*;

public class FenetreResultat extends JFrame implements ActionListener {
     // Les Attributs (pour ne pas qu'ils soient des variables)
   private JPanel m ;
   private JLabel message ;
   private JPanel nombre ;
   private int score ;
   private JLabel texte ;
   private JButton menu ;
   private FenetreSelectionBallonCombo leMenu ;
  
   // Constructeur
   public FenetreResultat(int score){

       this.score = score ;
      
       // La Fenêtre
       this.setTitle("Fenêtre du résultat");
       this.setSize(400, 400);
       this.setLocationRelativeTo(null);
       //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       // Petit conteneur main car c'est plus joli
       m = new JPanel() ;
       m.setLayout(null);
       m.setBounds(10,10,380,380);
       m.setBackground(Color.gray);
       this.add(m);

       // Texte 1
       message = new JLabel("Oh non vous avez perdu... Votre score est de : ") ;
       message.setBounds(40, 10, 300, 50);
       add(message);

       // Texte 2
       texte = new JLabel("Pour rejouer, clicker ici et bonne chance ^^") ;
       texte.setBounds(40, 300, 300, 50);
       add(texte);

       // Affichage du score mais je suis en train de chercher
       // nombre = new JPanel(score);
       // nombre.setBounds(150, 150, 100, 100);
       // add(nombre);

       // Bouton de retour au menu
       menu = new JButton("Menu");
       menu.setBounds(150, 225, 100,  100);
       menu.setBackground(Color.green);
       add(menu);
       menu.addActionListener(this);

       // Fenêtre de Menu
       // leMenu = new FenetreSelectionBallonCombo();

       this.setVisible(true);

      
   }
  
   // Méthodes dont événements
   public void actionPerformed(ActionEvent e) {
       System.out.println(this.score);
       if (e.getSource()==menu){
           System.out.println("Click sur Menu");
           leMenu.setVisible(true);
       }
   }
}
