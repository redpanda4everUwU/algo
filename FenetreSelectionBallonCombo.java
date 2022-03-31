 import java.util.Random ; // Pour les couleurs aléatoires
 import javax.swing.* ;
 import java.awt.*;
 import java.awt.event.*; 
 import javax.swing.* ;

public class FenetreSelectionBallonCombo extends JFrame implements ActionListener{
	
	// Les Attributs (pour ne pas qu'ils soient des variables)
	private JComboBox CB ;
	private Ballon[] monTabBallon ;
	private FenetrePlotBallon maFenetrePlot ; 
	
	// Constructeur
	public FenetreSelectionBallonCombo(Ballon[] monTabBallon){
		
		this.monTabBallon = monTabBallon ;
		this.setTitle("Selection du ballon");
		this.setSize(400, 200);
		this.setLocation(300, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Couleurs funky aléatoires du menu ^^
		Random aleatoire = new Random();
		int r = aleatoire.nextInt(255);
		int g = aleatoire.nextInt(255);
		int b = aleatoire.nextInt(255); 
		Color maCouleur = new Color(r,g,b);
		
		// Conteneur main
		JPanel c = new JPanel() ;
		c.setLayout(null);
		c.setBounds(10,10,380,280);
		c.setBackground(maCouleur);
		this.add(c);
		
		// Texte 1 
		JLabel E = new JLabel("Sélectionner le ballon de votre choix");
		E.setSize(360,30);
		E.setLocation(90,25);
		c.add(E);
		
		// Choix proposition ComboBox
		String types[]={"Basket","Hand","Tennis","Volley"};        
        CB = new JComboBox(types); 
        CB.setBounds(110, 70, 150, 60);
		c.add(CB);
		CB.addActionListener(this);
		CB.setEditable(true); 
		
		// Deuxième fenêtre
		//maFenetrePlot = new FenetrePlotBallon();
		this.setVisible(true);
		
	}
	
	// Méthodes dont événements 
	public void actionPerformed(ActionEvent e) {
			System.out.println(this.monTabBallon);
			int choix = CB.getSelectedIndex();
			System.out.println(CB.getSelectedIndex());
			//maFenetrePlot.choixBallon(monTabBallon[choix]);
			FenetrePlotBallon maFenetrePlot = new FenetrePlotBallon(monTabBallon[choix]);
			//maFenetrePlot.setVisible(true);
			maFenetrePlot.lancement();
		}
	}
	
