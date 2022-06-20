package hitbox;

import java.awt.*;
import java.nio.channels.Pipe;

public class Side {
    Point p1 = new Point();
    Point p2 = new Point();

    public Side(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point[] getCorner(){
        return new Point[]{p1,p2};
    }


}
