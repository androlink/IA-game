package rayCasting;

import java.awt.*;
import java.util.Arrays;

public class SimpleSquareHitBox extends HitBox2D{
    Point[] corners = new Point[4];

    SimpleSquareHitBox(Point location,int size){
        corners[0] = new Point(location.x-size,location.y-size);
        corners[1] = new Point(location.x+size,location.y-size);
        corners[2] = new Point(location.x+size,location.y+size);
        corners[3] = new Point(location.x-size,location.y+size);
    }




    @Override
    public boolean contain(Point location) {
        return false;
    }

    @Override
    public Point[] getCorners() {
        return corners;
    }

    @Override
    public String toString() {
        return "SimpleSquareHitBox{" +
                "corners=" + Arrays.toString(corners) +
                '}';
    }
}
