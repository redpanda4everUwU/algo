import java.awt.*;

public class Gestion {
    public static void main (String [] args){
    
    // Position initiale
    APoint p = new APoint (900, 500);

    // Images
    Image ba;
    Image ha;
    Image te;
    Image vo;

    Toolkit T=Toolkit.getDefaultToolkit();
    // Mettre le chemin d'accès des images avec un \\ à chaque dossier !
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
    FenetreSelectionBallonCombo maFrameSelectionBallon = new FenetreSelectionBallonCombo(tabBallon);
    
    }
}
