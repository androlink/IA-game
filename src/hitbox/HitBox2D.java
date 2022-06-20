package hitbox;

import java.awt.*;

public abstract class HitBox2D {


    /**
     * @param location
     * @return  true si le point se trouve dans la hitbox
     */
    public abstract boolean contain(Point location);

    public abstract Point[] getCorners();

    public abstract Side[] getSides();

    public abstract Point[] getSide(int index);


}
