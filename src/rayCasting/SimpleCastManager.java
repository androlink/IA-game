package rayCasting;

import hitbox.HitBox2D;

import java.awt.*;
import java.util.ArrayList;

public class SimpleCastManager extends CastManager{

    Particle[] rays = new Particle[360];

    Point location = new Point();
    double lenght=100;

    public SimpleCastManager(){
        initRay();
    }
    public SimpleCastManager(Point location){
        this.location = location;
        initRay();
    }
    public SimpleCastManager(Point location,double lenght){
        this.lenght=lenght;
        this.location = location;
        initRay();
    }
    private void initRay(){
        for(int i = 0 ; i<rays.length;i++){
            rays[i]=new Particle(location,Math.toRadians(i),lenght,i);
        }
    }


    @Override
    public ArrayList<CastEvent> watch(ArrayList<HitBox2D> hitboxs) {
        ArrayList<CastEvent> events = new ArrayList<>();

        for(int i = 0 ; i<rays.length;i++) {
            //System.out.println(i);//todo debug
            Particle ray = rays[i];
            ray.setInitalLocation(location);

            CastEvent bestCast = null;

            for (HitBox2D hitBox2D : hitboxs) {
                CastEvent testCast = ray.cast(hitBox2D);
                if(testCast!=null){
                    if(bestCast==null) bestCast=testCast;
                    if(bestCast.distance>testCast.distance)bestCast=testCast;
                }
            }
            if(bestCast!=null){
                //System.out.println("hit");//todo debug
                events.add(bestCast);
            }else{
                //System.out.println("miss");//todo debug
            }


        }
        return events;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
