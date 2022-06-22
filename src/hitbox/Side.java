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


    public Point getIntersection(Side otherSide){

        double x1 = otherSide.getCorner()[0].x;
        double y1 = otherSide.getCorner()[0].y;
        double x2 = otherSide.getCorner()[1].x;
        double y2 = otherSide.getCorner()[1].y;

        double x3 = getCorner()[0].x;
        double y3 = getCorner()[0].y;
        double x4 = getCorner()[1].x;
        double y4 = getCorner()[1].y;

        double den = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        if (den == 0) {
            return null;
        }

        double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / den;
        double u = -((x1 - x2) * (y1 - y3) - (y1 - y2) * (x1 - x3)) / den;

        if (t > 0 && t < 1 && u > 0 && u < 1) {
            Point pt = new Point();
            pt.x=(int)(x1 + t * (x2 - x1));
            pt.y=(int)(y1 + t * (y2 - y1));
            return pt;
        } else {
            return null;
        }


    }

    @Override
    public String toString() {
        return "Side{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }
}
