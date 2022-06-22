package hitbox;

import java.awt.*;
import java.util.Arrays;

public class SimpleRegularPolygonHitBox extends HitBox2D{
    Point[] bounds;
    Side[] sides;

    Point location;
    double angle=0;
    int nbOfSides;
    int size;

    public SimpleRegularPolygonHitBox(Point location,int nbOfSides,int size){

        bounds=new Point[nbOfSides];
        sides=new Side[nbOfSides];
        this.location=location;
        this.nbOfSides=nbOfSides;
        this.size=size;
        setBounds();
    }
    private void setBounds(){
        double angle = Math.PI*2/nbOfSides;
        double a=0;


        for(int i = 0;i<nbOfSides;a+=angle, i++){
            bounds[i]=new Point((int)(location.x+Math.cos(a+this.angle)*size),(int)(location.y+Math.sin(a+this.angle)*size));
        }

        for(int i = 0;i<nbOfSides;i++) {
            sides[i]=new Side(new Point(bounds[i].x, bounds[i].y),new Point(bounds[(i+1)%nbOfSides].x, bounds[(i+1)%nbOfSides].y));
        }
    }

    public void setAngle(double angle) {
        this.angle = angle%(Math.PI*2);
        setBounds();
    }

    public void setLocation(Point location) {
        this.location = location;
        setBounds();
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
    public Point[] getSide(int index) {
        return new Point[0];
    }

    @Override
    public String toString() {
        return "SimpleRegularPolygonHitBox{" +
                "bounds=" + Arrays.toString(bounds) +
                ", sides=" + Arrays.toString(sides) +
                ", location=" + location +
                ", angle=" + angle +
                ", nbOfSides=" + nbOfSides +
                ", size=" + size +
                '}';
    }
}
