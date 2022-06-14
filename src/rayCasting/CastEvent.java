package rayCasting;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;


/**
 * CastEvent stock l'interaction d'une particule avec une HitBox2D
 * @see Particle
 * @see CastManager
 * @see HitBox2D
 */
public class CastEvent {

    /**
     * indice de la particule d'interaction
     */
    int indice;

    Point initalLocation;

    Point interactLocation;

    double direction;

    double distance;

    HitBox2D hitBox2D;


    public CastEvent(Point initalLocation, Point interactLocation,int indice,HitBox2D hitBox2D) {
        this.initalLocation = initalLocation;
        this.interactLocation = interactLocation;
        this.direction = Math.atan2(interactLocation.y-initalLocation.y,interactLocation.x-initalLocation.x);
        this.distance = Point2D.distance(initalLocation.x,initalLocation.y,interactLocation.x,interactLocation.y);
        this.indice=indice;
        this.hitBox2D=hitBox2D;
    }

    public CastEvent(Point initalLocation, Point interactLocation, HitBox2D hitBox2D) {
        this(initalLocation,interactLocation,0,hitBox2D);
    }

    public HitBox2D getInteractBox2D() {
        return hitBox2D;
    }

    public int getIndice() {
        return indice;
    }

    public Point getInitalLocation() {
        return initalLocation;
    }

    public Point getInteractLocation() {
        return interactLocation;
    }

    public double getDirection() {
        return direction;
    }

    public double getDistance() {
        return distance;
    }
}
