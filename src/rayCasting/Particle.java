package rayCasting;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;


/**
 * la particule est un point servant a tester des potentiel collision avec des Objets de type hitBox2D
 */
public class Particle {

    Point initalLocation;

    double direction=0;

    int indice=0;

    Point DirectionLocation;

    public Particle(Point initalLocation){
        this.initalLocation = initalLocation;
    }

    public Particle(Point initalLocation, double direction) {
        this.initalLocation = initalLocation;
        this.direction = direction;
    }

    public Particle(Point initalLocation, double direction, int indice) {
        this.initalLocation = initalLocation;
        this.direction = direction;
        this.indice = indice;
    }

    public Particle(Point initalLocation, Point directionLocation, int indice) {
        this(initalLocation,Math.atan2(directionLocation.y-initalLocation.y,directionLocation.x-initalLocation.x),indice);
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
     * @return _event renvoie le CastEvent de l'interaction "il peut être null si il n'y a pas d'interaction"
     */
    public CastEvent cast( HitBox2D hitbox){
        //todo faire le cast de la particule
        CastEvent event=null;
        Point interactLocation=null;



        event = new CastEvent(initalLocation,interactLocation,indice,hitbox);


        return event;
    }





}
