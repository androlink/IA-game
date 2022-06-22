package hitbox;

import java.awt.*;

public class CollisionEvent {

    Point locationEvent;
    HitBox2D hitBox2D;
    HitBox2D testedHitBox2D;
    Side side;
    Side testedSide;
    double angle;

    public CollisionEvent(Point locationEvent, HitBox2D hitBox2D, HitBox2D testedHitBox2D, Side side, Side testedSide) {
        this.locationEvent = locationEvent;
        this.hitBox2D = hitBox2D;
        this.testedHitBox2D = testedHitBox2D;
        this.side = side;
        this.testedSide = testedSide;
        double _angle1=Math.atan2(side.getCorner()[1].y-side.getCorner()[0].y,side.getCorner()[1].x-side.getCorner()[0].x);
        double _angle2=Math.atan2(testedSide.getCorner()[1].y-testedSide.getCorner()[0].y,testedSide.getCorner()[1].x-testedSide.getCorner()[0].x);
        angle=(_angle1-_angle2);
    }

    public Point getLocationEvent() {
        return locationEvent;
    }

    public HitBox2D getHitBox2D() {
        return hitBox2D;
    }

    public HitBox2D getTestedHitBox2D() {
        return testedHitBox2D;
    }

    public Side getSide() {
        return side;
    }

    public Side getTestedSide() {
        return testedSide;
    }

    public double getAngle() {
        return angle;
    }

    @Override
    public String toString() {
        return "CollisionEvent{" +
                "locationEvent=" + locationEvent +
                ", hitBox2D=" + hitBox2D +
                ", testedHitBox2D=" + testedHitBox2D +
                ", side=" + side +
                ", testedSide=" + testedSide +
                ", angle=" + angle +
                '}';
    }
}
