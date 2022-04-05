public class Trajectoire {

    APoint P; 
    Ballon Bal;
    //Motion M0; la vitesse initiale et l'angle 


public Trajectoire(Ballon b){
        Bal=b; 
        P=Bal.getPosition();
        // M0=Bal.getMotion(); 
        // recalcul d'angle avec variation de x et y sur la position et la position précedente ? 

        if(P.y<= 0){
            Bal.deplaceY(-10);
        }
} 



//get données 

//équation



//équations rebond (get theta,vx,vy)

/*afficher une preview de la trajectoire ?
afficher le motion du ballon 
faire une autre classe pour le déplacement ?*/ 
}