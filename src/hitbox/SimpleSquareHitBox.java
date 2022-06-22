package hitbox;

import rayCasting.CastEvent;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SimpleSquareHitBox extends HitBox2D {
    Point[] bounds = new Point[4];
    Side[] sides = new Side[4];

    Point location;
    int size=10;

    public SimpleSquareHitBox(Point location,int size){
        this.location=location;
        this.size=size;
        setBounds();

    }
    private void setBounds(){
        bounds[0] = new Point(location.x-size,location.y-size);
        bounds[1] = new Point(location.x+size,location.y-size);
        bounds[2] = new Point(location.x+size,location.y+size);
        bounds[3] = new Point(location.x-size,location.y+size);

        for(int i = 0;i<4;i++) {
            sides[i]=new Side(new Point(bounds[i].x, bounds[i].y),new Point(bounds[(i+1)%4].x, bounds[(i+1)%4].y));
        }
    }


    @Override
    public Point getLocation() {
        return location;
    }

    @Override
    public void setLocation(Point location) {
        this.location = location;
        setBounds();
    }

    @Override
    public void setAngle(double angle) {

    }

    @Override
    public Point[] getBounds() {
        return bounds;
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
                "corners=" + Arrays.toString(bounds) +
                ", sides=" + Arrays.toString(sides) +
                '}';
    }
}
