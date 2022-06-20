package hitbox;

import java.awt.*;
import java.util.Arrays;

public class SimpleSquareHitBox extends HitBox2D {
    Point[] corners = new Point[4];
    Side[] sides = new Side[4];

    public SimpleSquareHitBox(Point location,int size){
        corners[0] = new Point(location.x-size,location.y-size);
        corners[1] = new Point(location.x+size,location.y-size);
        corners[2] = new Point(location.x+size,location.y+size);
        corners[3] = new Point(location.x-size,location.y+size);

        for(int i = 0;i<4;i++) {
            sides[i]=new Side(new Point(corners[i].x,corners[i].y),new Point(corners[(i+1)%4].x,corners[(i+1)%4].y));
        }
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
    public Side[] getSides() {
        return sides;
    }
    @Override
    public Point[] getSide(int index){
        return sides[index].getCorner();
    }

    @Override
    public String toString() {
        return "SimpleSquareHitBox{" +
                "corners=" + Arrays.toString(corners) +
                ", sides=" + Arrays.toString(sides) +
                '}';
    }
}
