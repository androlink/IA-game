package rayCasting;

import java.awt.*;

public abstract class HitBox2D {
    Point[] corners;

    public HitBox2D(Point[] corners){
        this.corners = corners;
    }

    /**
     * @param location
     * @return  true si le point se trouve dans la hitbox
     */
    public abstract boolean contain(Point location);

}
