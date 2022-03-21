import java.awt.*;


public class Gestion {
    public static void main (String [] args){
    
    // Position initiale
    APoint p = new APoint (300, 100);
    Image balle;
    
    Toolkit T=Toolkit.getDefaultToolkit();
    balle = T.getImage("basket.png");

    
    // Création d'un tableau de ballons
        Ballon[] tabBallon=new Ballon[4];
        
        // On veut un ballon de basket
        Ballon basket = new Ballon(600, 24.19,balle , p);
    
        // On veut un ballon de hand
        Ballon hand = new Ballon(475, 19.1, balle, p);
    
        // On veut une balle de tennis
        Ballon tennis = new Ballon(58.5, 6.68, balle, p);
    
        // On veut un ballon de volley
        Ballon volley = new Ballon(280, 21, balle, p);
    
    // Remplissage du tableau par les ballons standards créés auparavant
        tabBallon[0]=basket;
        tabBallon[1]=hand;
        tabBallon[2]=tennis;
        tabBallon[3]=volley;
        
    // Création de la fenêtre pour l'IHM
    FenetreSelectionBallon maFrameSelectionBallon = new FenetreSelectionBallon(tabBallon);
    FenetrePlotBallon maFrameAfficherFigure = new FenetrePlotBallon() ;
    
    }
}
