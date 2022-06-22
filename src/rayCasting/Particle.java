package rayCasting;

import hitbox.HitBox2D;
import hitbox.Side;

import java.awt.*;
import java.awt.geom.Point2D;


/**
 * la particule est un point servant a tester des potentiel collision avec des Objets de type hitBox2D
 */
public class Particle {

    Point initalLocation = new Point();

    double angle = 0;

    int indice = 0;

    double length = 100;

    Point directionLocation;

    public Particle(Point initalLocation){
        this.initalLocation = initalLocation;
    }

    public Particle(Point initalLocation, double angle,double lenght) {
        this.initalLocation = initalLocation;
        this.angle = angle;
        this.length = lenght;
        this.directionLocation= new Point((int)(Math.cos(angle)*lenght),(int)(Math.sin(angle)*lenght));
    }

    public Particle(Point initalLocation, double angle,double lenght, int indice) {
        this(initalLocation,angle,lenght);
        this.indice = indice;
    }


    /**
     * @param hitbox
     * @return - renvoie le CastEvent de l'interaction - null si il n'y a pas d'interaction
     */
    public CastEvent cast( HitBox2D hitbox){
        //System.out.println("indice: "+indice+", from: ["+ initalLocation.x+", "+initalLocation.y+"], to: ["+ directionLocation.x+", "+directionLocation.y+"]");//todo debug


        double bestDistance = length;
        Point bestPt = null;
        Side bestSide=null;

        for(int i = 0;i<hitbox.getSides().length;i++){
            double testDistance;
            Side side = hitbox.getSides()[i];
            Point pt = cast(side.getCorner());


            if(pt!=null) {
                testDistance = Point2D.distance(initalLocation.x, initalLocation.y, pt.x, pt.y);
                if (bestDistance > testDistance) {
                    bestPt=pt;
                    bestSide = side;
                    //System.out.println(indice+" "+bestDistance+">"+testDistance);
                    bestDistance = testDistance;
                }
            }
        }
        CastEvent event = null;
        if(bestDistance < length){
            event=new CastEvent(initalLocation,bestPt,hitbox,bestSide);
        }
        return event;
    }

    /**
     *
     * @param side - contain the 2 points of a "wall"
     * @return - return the interaction point - null if no interaction
     *
     * @see Point
     * @see CastEvent
     */
    public Point cast(Point[] side){

        double x1 = side[0].x;
        double y1 = side[0].y;
        double x2 = side[1].x;
        double y2 = side[1].y;

        double x3 = this.initalLocation.x;
        double y3 = this.initalLocation.y;
        double x4 = this.directionLocation.x;
        double y4 = this.directionLocation.y;

        double den = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        if (den == 0) {
            return null;
        }

        double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / den;
        double u = -((x1 - x2) * (y1 - y3) - (y1 - y2) * (x1 - x3)) / den;

        if (t >= 0 && t <= 1 && u >= 0) {
            Point pt = new Point();
            pt.x=(int)(x1 + t * (x2 - x1));
            pt.y=(int)(y1 + t * (y2 - y1));
            return pt;
        } else {
            return null;
        }
    }
    public void setAngle(double angle){
        this.angle = angle;
        directionLocation.x =(int) (Math.cos(angle)* length)+initalLocation.x;
        directionLocation.y =(int) (Math.sin(angle)* length)+initalLocation.y;
    }

    public void setInitalLocation(Point initalLocation) {
        this.initalLocation = initalLocation;
        directionLocation.x =(int) (Math.cos(angle)* length)+initalLocation.x;
        directionLocation.y =(int) (Math.sin(angle)* length)+initalLocation.y;
    }

    @Override
    public String toString() {
        return "Particle{" +
                "initalLocation=" + initalLocation +
                ", angle=" + angle +
                ", indice=" + indice +
                ", lenght=" + length +
                ", directionLocation=" + directionLocation +
                '}';
    }
}
