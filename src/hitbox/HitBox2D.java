package hitbox;

import rayCasting.CastEvent;

import java.awt.*;
import java.util.ArrayList;

public abstract class HitBox2D {



    public abstract Point[] getBounds();

    public abstract Side[] getSides();

    public abstract Point[] getSide(int index);

    public abstract void setLocation(Point location);
    public abstract void setAngle(double angle);

    public ArrayList<CollisionEvent> collide(HitBox2D testedBox) {
        ArrayList<CollisionEvent> collisionEvents = new ArrayList<>();

        for(Side mySide:getSides()){
            for(Side otherSide: testedBox.getSides()){
                Point pt = mySide.getIntersection(otherSide);
                if(pt!=null)collisionEvents.add(new CollisionEvent(pt,this,testedBox,mySide,otherSide));
            }
        }
        return collisionEvents;
    }


    public boolean contain(Point location) {
        return false;
    }
    public void draw(Graphics g){
        for(Side s:getSides()){
            g.drawLine(s.getCorner()[0].x,s.getCorner()[0].y,s.getCorner()[1].x,s.getCorner()[1].y);
        }
    }
}
