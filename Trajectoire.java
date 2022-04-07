

public class Trajectoire {

    APoint P; 
    Ballon Bal;

    //Motion Mo; la vitesse initiale et l'angle 


public Trajectoire(Ballon b){
        Bal=b; 
        P=Bal.getPosition();
        // Mvec variation de x et Mo=Bal.getMotion(); 
        // recalcul d'angle ay sur la position et la position précedente ? 

        //P.x=V0*cos(Motion.theta)*monTimer.getTimer();
        //P.y=-V0*9.81*.0.5*Math.pow(monTimer.getTimer(),2)+V0*sin(Motion.theta)*monTimer.getTimer();
        //delta bal.getPosition par rapport à P (ancienne et nouvelles coordonnées pour obtenir theta)
        //Math.atan2(y, x) à étudier
} 



//get données 

//équation



//équations rebond (get theta,vx,vy)

/*afficher une preview de la trajectoire ?
afficher le motion du ballon 
faire une autre classe pour le déplacement ?*/ 
}