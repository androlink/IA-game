package rayCasting;

import hitbox.HitBox2D;
import hitbox.Side;

import java.awt.*;
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

    Side side;

    public CastEvent(Point initalLocation, Point interactLocation,int indice,HitBox2D hitBox2D,Side side) {
        this.initalLocation = initalLocation;
        this.interactLocation = interactLocation;
        this.direction = Math.atan2(interactLocation.y-initalLocation.y,interactLocation.x-initalLocation.x);
        this.distance = Point2D.distance(initalLocation.x,initalLocation.y,interactLocation.x,interactLocation.y);
        this.indice=indice;
        this.hitBox2D=hitBox2D;
        this.side=side;
    }

    public CastEvent(Point initalLocation, Point interactLocation, HitBox2D hitBox2D,Side side) {
        this(initalLocation,interactLocation,0,hitBox2D,side);
    }
    /*
    public CastEvent(Point initalLocation,double direction, double distance,int indice, HitBox2D hitBox2D){//FIXME bug au niveau du calcul de position du point d'interaction
        this.initalLocation = initalLocation;
        this.distance = distance;
        this.direction = direction;
        this.interactLocation = new Point(initalLocation.x+(int)(Math.cos(direction)*distance),initalLocation.x+(int)(Math.sin(direction)*distance));
        this.indice=indice;
        this.hitBox2D=hitBox2D;
    }*/

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

    public HitBox2D getHitBox2D() {
        return hitBox2D;
    }

    public Side getSide() {
        return side;
    }
}
