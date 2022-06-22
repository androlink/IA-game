package test;

import hitbox.HitBox2D;
import hitbox.SimpleSquareHitBox;
import rayCasting.CastEvent;
import rayCasting.Particle;
import rayCasting.SimpleCastManager;

import java.awt.*;
import java.util.ArrayList;

class CastTest {





    @org.junit.jupiter.api.Test
    public void wallCollideTest(){
        Particle ray = new Particle(new Point(),0,100);
        Point[] wall1 = {new Point(50,-10),new Point(50,10)};
        System.out.println(ray.cast(wall1));
        Point[] wall2 = {new Point(50,10),new Point(50,20)};
        System.out.println(ray.cast(wall2));



    }
    @org.junit.jupiter.api.Test
    public void hitBoxCollideTest(){
        HitBox2D hitBox2D = new SimpleSquareHitBox(new Point(0,0),10);
        Particle ray = new Particle(new Point(),0,100);
        System.out.println(hitBox2D.toString());
        System.out.println(ray.toString());
        System.out.println(ray.cast(hitBox2D).getInitalLocation());


    }




    @org.junit.jupiter.api.Test
    public void hitBoxManagerCollideTest(){
        System.out.println(Math.cos(Math.toRadians(0))+" "+Math.sin(Math.toRadians(0)));
        SimpleSquareHitBox test = new SimpleSquareHitBox(new Point(0,0),990);
        for(int i = 0; i < test.getBounds().length; i++)
            System.out.println(test.getBounds()[i]);

        ArrayList<HitBox2D> hitboxManager = new ArrayList<>();
        hitboxManager.add(test);

        SimpleCastManager manager = new SimpleCastManager();

        for(CastEvent event:manager.watch(hitboxManager)){
            System.out.println("indice: "+event.getIndice()+", location: "+event.getInteractLocation());
        }
    }

}