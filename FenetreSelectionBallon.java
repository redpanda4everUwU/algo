import javax.swing.* ;
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.* ;

public class FenetreSelectionBallon extends JFrame implements ActionListener{
    
    // Les Attributs (pour ne pas qu'ils soient des variables)
    private JTextField T1 ;
    private JTextField T2 ;
    private JButton B1 ;
    private JButton B2 ;
    private Ballon[] monTabBallon ;
    private FenetrePlotBallon maFenetrePlot ;
    
    // Constructeur
    public FenetreSelectionBallon(Ballon[] monTabBallon){
        
        this.monTabBallon = monTabBallon ;
        this.setTitle("Selection du ballon");
        this.setSize(400, 400);
        this.setLocation(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        // Conteneur main
        JPanel c3 = new JPanel() ;
        c3.setLayout(null);
        c3.setBounds(10,10,380,380);
        c3.setBackground(Color.gray);
        this.add(c3);
        
        // Conteneur 1
        JPanel c1 = new JPanel() ;
        c1.setLayout(null);
        c1.setBounds(10,10,360,150);
        c1.setBackground(Color.cyan);
        c3.add(c1);
        
        // Conteneur 2
        JPanel c2 = new JPanel() ;
        c2.setLayout(null);
        c2.setBounds(10,180,360,150) ;
        c2.setBackground(Color.blue);    
        c3.add(c2);
        
        // Texte 1
        JLabel E1 = new JLabel("Entrez un numero de ballon entre 1 et 5 : ");
        E1.setSize(360,30);
        E1.setLocation(10,25);
        c1.add(E1);
        
        // Textes à éditer
        T1 = new JTextField();
        T1.setBounds(105,70,150,60);
        c1.add(T1);
        T1.getText();
        
        T2 = new JTextField();
        T2.setBounds(10,80,340,60);
        c2.add(T2);
        
        // Bouton 1
        B1 = new JButton("Afficher");
        B1.setBounds(10,20,150,40);
        B1.setBackground(Color.green);
        c2.add(B1);    
        B1.addActionListener(this);
        
        // Bouton 2
        B2 = new JButton("Effacer");
        B2.setBounds(200,20,150,40);
        B2.setBackground(Color.red);    
        c2.add(B2);    
        B2.addActionListener(this);
        
        // Deuxième fenêtre, question 5.3.1.3
        maFenetrePlot = new FenetrePlotBallon();
        this.setVisible(true);
        
        this.setVisible(true);    // Pour rendre la fenêtre visible, on le met à la fin pour que tout s'affiche d'un coup ^^
    }
    
    // Méthodes dont événements
    public void actionPerformed(ActionEvent e) {
        System.out.println(this.monTabBallon);
        if(e.getSource()==B2){
            
        System.out.println("Click sur Effacer");
        T2.setText("");
        }
        
        if (e.getSource()==B1){
            System.out.println("Click sur Afficher");
            int choix = Integer.parseInt(T1.getText());
            if (choix > monTabBallon.length || choix <1){
                JOptionPane.showMessageDialog(this, "Veuillez rentrer un nombre entre 1 et "+monTabBallon.length+" !");
            }else{
        System.out.println(monTabBallon[choix-1]);
        T2.setText(monTabBallon[choix-1].toString());
        maFenetrePlot.choixBallon(monTabBallon[choix-1]);
        maFenetrePlot.setVisible(true);
            }
        }
    }
}    