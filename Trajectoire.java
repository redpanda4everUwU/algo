

public class Trajectoire {

    APoint P;
    APoint Pa; 
    Ballon Bal;
    double v0;
    double theta2;
    //Motion Mo; la vitesse initiale et l'angle 


public Trajectoire(Ballon b,double v0, double theta,double temps){
    //while(P.y<=800){
        Bal=b; 
        P=Bal.getPosition();
        theta2=-theta;
        P.x=P.x+v0*Math.cos(theta2)*temps;
        P.y=0.5*9.81*Math.pow(temps, 2)-v0*Math.sin(theta2)*temps+P.y;

        /*Pa=new APoint(0, 0);// on garde en mémoire la position
        Pa.x+=10;
        P.y=-(9.81*(Math.pow(Pa.x, 2))/(2*Math.pow(v0, 2)*Math.pow(Math.cos(theta), 2))-Pa.x*Math.tan(theta)-P.y);
        P.x=b.getPosition().x+10;*/
        //System.out.println(12);
        //theta=Math.atan2(P.y-Pa.y,P.x-Pa.x) ;//recalcul de theta avec la nouvelle et l'ancienne position
    //}
} 



//get données 

//équation



//équations rebond (get theta,vx,vy)

/*afficher une preview de la trajectoire ?
afficher le motion du ballon 
faire une autre classe pour le déplacement ?*/ 
}