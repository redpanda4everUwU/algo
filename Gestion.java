import java.awt.*;
import java.util.LinkedList;

import javax.swing.JFrame;

public class Gestion {
    public static void main (String [] args){
    
    // Position initiale
    APoint p = new APoint (900, 500);

    // Images
    Image ba;
    Image ha;
    Image te;
    Image vo;

    // Panier
    LinkedList <APoint> Poteau= new LinkedList <APoint>();
    LinkedList <APoint> Panneau= new LinkedList <APoint>();
    LinkedList <APoint> Panier= new LinkedList <APoint>();

    
    for (int j=919;j>502;j--){ // Poteau du panier
        int i1=1758;
        Poteau.add(new APoint(i1,j));
    }

    for (int j=502;j>313;j--){ // Hauteur du panneu
        int i2=1645;
        Panneau.add(new APoint(i2,j));
    }
    for (int i=1558;i<1565;i++){ // Bord opposé du panier 
        int j2=1645;
        Panier.add(new APoint(i,j2));
    }

    Toolkit T=Toolkit.getDefaultToolkit();
    ba = T.getImage("BasketBall.png");
    ha = T.getImage("HandBall.png");
    te = T.getImage("Tennis.png");
    vo = T.getImage("Volley.png");

    
    // Création d'un tableau de ballons
    Ballon[] tabBallon=new Ballon[4];
        
        // On veut un ballon de basket
        Ballon basket = new Ballon(600, 40, ba, p);
    
        // On veut un ballon de hand
        Ballon hand = new Ballon(475, 25, ha, p);
    
        // On veut une balle de tennis
        Ballon tennis = new Ballon(58.5, 8, te, p);
    
        // On veut un ballon de volley
        Ballon volley = new Ballon(280, 50, vo, p);
    
    // Remplissage du tableau par les ballons standards créés auparavant
        tabBallon[0]=basket;
        tabBallon[1]=hand;
        tabBallon[2]=tennis;
        tabBallon[3]=volley;
        
    // Création de la fenêtre pour l'IHM
    FenetreSelectionBallonCombo maFrameSelectionBallon = new FenetreSelectionBallonCombo(tabBallon,Panneau,Panier,Poteau );
    
    }

    // Méthode pour fermer une fenêtre ^^
    public static void fermer(JFrame Fenetre){
        Fenetre.setVisible(false);
        Fenetre.dispose();
    }
}
