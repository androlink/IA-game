package rayCasting;

import java.awt.*;
import java.util.ArrayList;

class Test {





    @org.junit.jupiter.api.Test
    public void wallCollideTest(){
        Particle ray = new Particle(new Point(),0,100);
        Point[] wall1 = {new Point(40,-10),new Point(60,10)};
        System.out.println(ray.cast(wall1));
        Point[] wall2 = {new Point(40,10),new Point(60,20)};
        System.out.println(ray.cast(wall2));



    }
    @org.junit.jupiter.api.Test
    public void hitBoxCollideTest(){
        HitBox2D hitBox2D = new SimpleSquareHitBox(new Point(0,100),10);
        Particle ray = new Particle(new Point(),0,1000);

        System.out.println(ray.cast(hitBox2D));


    }




    @org.junit.jupiter.api.Test
    public void hitBoxManagerCollideTest(){
        SimpleSquareHitBox test = new SimpleSquareHitBox(new Point(100,100),20);
        for(int i = 0 ; i < test.getCorners().length;i++)
            System.out.println(test.getCorners()[i]);

        ArrayList<HitBox2D> hitboxManager = new ArrayList<>();
        hitboxManager.add(test);

        SimpleCastManager manager = new SimpleCastManager();

        for(CastEvent event:manager.watch(hitboxManager)){
            System.out.println("indice: "+event.getIndice()+", location: "+event.interactLocation);
        }
    }






}