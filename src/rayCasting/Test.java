package rayCasting;


import java.awt.*;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
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
