package rayCasting;

import java.awt.*;
import java.util.ArrayList;

public class SimpleCastManager extends CastManager{

    Particle[] rays = new Particle[360];

    Point location = new Point();

    SimpleCastManager(){
        for(int i = 0 ; i<rays.length;i++){
            rays[i]=new Particle(location,Math.toRadians(i),1000,i);
        }
    }







    @Override
    public ArrayList<CastEvent> watch(ArrayList<HitBox2D> hitboxs) {
        ArrayList<CastEvent> events = new ArrayList<>();

        for(int i = 0 ; i<rays.length;i++) {
            //System.out.println(i);//todo debug

            Particle ray = rays[i];

            CastEvent bestCast = null;

            for (HitBox2D hitBox2D : hitboxs) {
                CastEvent testCast = ray.cast(hitBox2D);
                if(testCast!=null){
                    if(bestCast==null) bestCast=testCast;
                    if(bestCast.distance>testCast.distance)bestCast=testCast;
                }
            }
            if(bestCast!=null){
                System.out.println("hit");//todo debug
                events.add(bestCast);
            }else{
                //System.out.println("miss");//todo debug
            }


        }
        return events;
    }
}
