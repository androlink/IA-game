package rayCasting;

import java.awt.*;

public class SimpleSquareHitBox extends HitBox2D{
    Point[] corners = new Point[4];

    SimpleSquareHitBox(Point location,double size){

        for(int i = 0 ;i < 4 ;i ++){
            corners[i] = new Point((int)(Math.cos((Math.PI*i*2/4f)+Math.PI/4)*size)+location.x,(int)(Math.sin((Math.PI*i*2/4)+Math.PI/4)*size)+location.y);
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
}
