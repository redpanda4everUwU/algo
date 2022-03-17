import java.awt.*;

public class Gestion {
    public static void main (String [] args){
    
    // Position initiale
    APoint p = new APoint (0, 150);
    
    // Création d'un tableau de ballons
        Ballon[] tabBallon=new Ballon[4];
        
        // On veut un ballon de basket
        Ballon basket = new Ballon(600, 24.19, Color.ORANGE, p);
    
        // On veut un ballon de hand
        Ballon hand = new Ballon(475, 19.1, Color.BLUE, p);
    
        // On veut une balle de tennis
        Ballon tennis = new Ballon(58.5, 6.68, Color.YELLOW, p);
    
        // On veut un ballon de volley
        Ballon volley = new Ballon(280, 21, Color.GREEN, p);
    
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
