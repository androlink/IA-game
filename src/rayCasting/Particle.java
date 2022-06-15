package rayCasting;

import java.awt.*;
import java.awt.geom.Point2D;


/**
 * la particule est un point servant a tester des potentiel collision avec des Objets de type hitBox2D
 */
public class Particle {

    Point initalLocation = new Point();

    double angle =0;

    int indice=0;

    double lenght=0;

    Point directionLocation;

    public Particle(Point initalLocation){
        this.initalLocation = initalLocation;
    }

    public Particle(Point initalLocation, double angle,double lenght) {
        this.initalLocation = initalLocation;
        this.angle = angle;
        this.lenght = lenght;
        this.directionLocation= new Point((int)(Math.cos(angle)*lenght),(int)(Math.sin(angle)*lenght));
    }

    public Particle(Point initalLocation, double angle,double lenght, int indice) {
        this(initalLocation,angle,lenght);
        this.indice = indice;
    }
    /*
    public Point watch(ArrayList<HitBox2D> hitboxs){
        Point interactLocation=null;
        Point closestInteraction=null;


        for(HitBox2D hitbox:hitboxs){
            interactLocation=cast(hitbox);
            if(interactLocation!=null){
                if(closestInteraction==null)closestInteraction=interactLocation;
                //else if(Point2D.distance(closestInteraction.x,closestInteraction.y));


            }


        }



        return closestInteraction;
    }*/

    /**
     * @param hitbox
     * @return - renvoie le CastEvent de l'interaction - null si il n'y a pas d'interaction
     */
    public CastEvent cast( HitBox2D hitbox){
        //System.out.println("indice: "+indice+", from: ["+ initalLocation.x+", "+initalLocation.y+"], to: ["+ directionLocation.x+", "+directionLocation.y+"]");//todo debug


        double bestDistance=Double.POSITIVE_INFINITY;
        for(int i = 0;i<hitbox.getCorners().length;i++){
            double testDistance;//fixme bug sur cette variable

            if(i==hitbox.getCorners().length-1){
                testDistance = cast(new Point[]{new Point(hitbox.getCorners()[i]),new Point(hitbox.getCorners()[0])});
            }else{
                testDistance = cast(new Point[]{new Point(hitbox.getCorners()[i]),new Point(hitbox.getCorners()[i+1])});
            }
            if(bestDistance>testDistance){
                //System.out.println(indice+" "+bestDistance+">"+testDistance);
                bestDistance=testDistance;
            }
        }
        CastEvent event = null;
        if(bestDistance<lenght){
            event=new CastEvent(initalLocation,new Point((int)(Math.cos(angle)*bestDistance),(int)(Math.sin(angle)*bestDistance)),indice,hitbox);
        }
        return event;
    }

    /**
     *
     * @param side - contain the 2 points of a "wall"
     * @return - return the distance of interaction positve infinity if no interaction
     *
     * @see CastEvent
     */
    public double cast(Point[] side){
        double distance;

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
            return Double.POSITIVE_INFINITY;
        }

        double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / den;
        double u = -((x1 - x2) * (y1 - y3) - (y1 - y2) * (x1 - x3)) / den;

        if (t > 0 && t < 1 && u > 0) {
            distance = Point2D.distance(x3,y3,x1 + t * (x2 - x1),y1 + t * (y2 - y1));
        } else {
            return Double.POSITIVE_INFINITY;
        }
        return distance;
    }


    @Override
    public String toString() {
        return "Particle{" +
                "initalLocation=" + initalLocation +
                ", angle=" + angle +
                ", indice=" + indice +
                ", lenght=" + lenght +
                ", directionLocation=" + directionLocation +
                '}';
    }
}
