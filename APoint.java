    public class APoint {
    // Attributs
        
    public double x;
    public double y;
        
    // Constructeur
       
    public APoint(double ax, double ay){
        x = ax;
        y = ay;
    }
        
    // Méthodes  
             //sjshs
    public double distance( APoint otherPoint ) {
        double dx = x - otherPoint.x;
        double dy = y - otherPoint.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
        
    public String toString() {
        String res ="";
        res="[x=" + x + ",y=" + y + "]";
        return res;  
    }    
    
}
