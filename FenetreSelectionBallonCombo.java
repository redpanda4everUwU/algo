import java.util.Random ; // Pour les couleurs aléatoires
import javax.swing.* ;
import java.awt.*;
import java.awt.event.*;

public class FenetreSelectionBallonCombo extends JFrame implements ActionListener{
   
   // Les Attributs (pour ne pas qu'ils soient des variables)
   private JComboBox CB ;
   private Ballon[] monTabBallon ;
   private JLabel regles ;
   
   // Constructeur
   public FenetreSelectionBallonCombo(Ballon[] monTabBallon){
	   
	   this.monTabBallon = monTabBallon ;
	   this.setTitle("Selection du ballon");
	   this.setSize(400, 270);
	   this.setLocation(300, 200);
	   this.setLocationRelativeTo(null);
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   this.setResizable(false);
	   
	   // Couleurs funky aléatoires du menu ^^
	   Random aleatoire = new Random();
	   int r = aleatoire.nextInt(255);
	   int g = aleatoire.nextInt(255);
	   int b = aleatoire.nextInt(255); 
	   Color maCouleur = new Color(r,g,b);
	   
	   // Conteneur main
	   JPanel c = new JPanel() ;
	   c.setLayout(null);
	   c.setBounds(10,10,400,270);
	   c.setBackground(maCouleur);
	   this.add(c);
	   
	   // Texte choix ballon
	   JLabel E = new JLabel("Sélectionner le ballon de votre choix :");
	   E.setSize(360,30);
	   E.setLocation(90,25); 
	   c.add(E);

	   // Textes règle
	   regles = new JLabel("Votre objectif : marquez le plus de panier !!");
	   regles.setSize(400,40);
	   regles.setLocation(70,145);
	   c.add(regles);

	   regles = new JLabel("Clickez sur le ballon et gérez le vecteur avec la souris.");
	   regles.setSize(400,40);
	   regles.setLocation(30,160);
	   c.add(regles);

	   regles = new JLabel("Bonne chance <3");
	   regles.setSize(400,40);
	   regles.setLocation(135,175);
	   c.add(regles);
	   
	   
	   // Choix proposition ComboBox
	   String types[]={"Basket","Hand","Tennis","Volley"};        
	   CB = new JComboBox(types); 
	   CB.setBounds(110, 70, 150, 60);
	   c.add(CB);
	   CB.addActionListener(this);
	   CB.setEditable(false); 

	   this.setVisible(true);
	   
   }
   
   // Méthodes dont événements 
   public void actionPerformed(ActionEvent e) {
		   System.out.println(this.monTabBallon);
		   int choix = CB.getSelectedIndex();
		   FenetrePlotBallon maFenetrePlot = new FenetrePlotBallon(monTabBallon[choix]);
		   maFenetrePlot.lancement();
	   }
   }
   
