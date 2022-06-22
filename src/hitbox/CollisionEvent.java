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

        angle=Math.atan2(testedHitBox2D.getLocation().y-hitBox2D.getLocation().y,testedHitBox2D.getLocation().x-hitBox2D.getLocation().x);

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
