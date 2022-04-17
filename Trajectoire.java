

public class Trajectoire {

    APoint P;
    APoint Pa; 
    Ballon Bal;
    double v0;
    double theta;
    //Motion Mo; la vitesse initiale et l'angle 


public Trajectoire(Ballon b,double v0, double theta,int temps){
    while(P.y<=800){
    Bal=b; 
        P=Bal.getPosition();
        Pa=P;// on garde en mémoire la position
 
        P.x=v0*Math.cos(theta)*temps;
        P.y=-v0*9.81*0.5*Math.pow(temps,2)+v0*Math.sin(theta)*temps;
        System.out.println(12);
        theta=Math.atan2(P.y-Pa.y,P.x-Pa.x) ;//recalcul de theta avec la nouvelle et l'ancienne position
    }
} 



//get données 

//équation



//équations rebond (get theta,vx,vy)

/*afficher une preview de la trajectoire ?
afficher le motion du ballon 
faire une autre classe pour le déplacement ?*/ 
}