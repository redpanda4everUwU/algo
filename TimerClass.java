import java.awt.event.*;
import javax.swing.*;

public class TimerClass implements ActionListener {

    // Les attributs de la classe
    public long temps;
    public int interval;

    public TimerClass(int interval){
        this.interval=interval;
        Timer t = new Timer(interval, this); // Création du timer
        temps = 0; // On initialise le temps à 0
        t.start(); // On lance le chrono
    }

// Méthode exécutée à chaque réveil du Timer
    public void actionPerformed(ActionEvent e) {
     temps+=interval; // On incrémente le temps
        System.out.println("Je suis vivant depuis "+temps+" ms");
    }
    public static void main(String[] args) {
        TimerClass chrono = new TimerClass (100);
        while(true);
    }
}