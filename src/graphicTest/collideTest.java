package graphicTest;

import hitbox.CollisionEvent;
import hitbox.SimpleRegularPolygonHitBox;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class collideTest {


    public void simpleCollideTest(){
        JFrame f = new JFrame("simpleCastManagerTest");
        f.setSize(400, 400);
        f.setVisible(true);
        f.setDefaultCloseOperation(3);


        Canvas canvas = new Canvas();
        canvas.setSize(400, 400);
        f.add(canvas);

        canvas.createBufferStrategy(3);

        boolean running = true;

        BufferStrategy bufferStrategy;
        Graphics graphics;

        SimpleRegularPolygonHitBox hitBox1 = new SimpleRegularPolygonHitBox(new Point(100,200),2,100);
        SimpleRegularPolygonHitBox hitBox2 = new SimpleRegularPolygonHitBox(new Point(200,200),2,100);
        hitBox2.setAngle(Math.PI/2);





        while (true) {


            bufferStrategy = canvas.getBufferStrategy();
            graphics = bufferStrategy.getDrawGraphics();
            graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());


            hitBox1.setLocation(MouseInfo.getPointerInfo().getLocation());

            graphics.setColor(Color.WHITE);
            hitBox1.draw(graphics);
            hitBox2.draw(graphics);



            ArrayList<CollisionEvent> events = hitBox1.collide(hitBox2);
            graphics.setColor(Color.RED);
            for(CollisionEvent e : events){
                graphics.drawOval(e.getLocationEvent().x,e.getLocationEvent().y,1,1);
                System.out.println(Math.toDegrees(e.getAngle()));
            }
            /*
            events = hitBox2.collide(hitBox1);
            graphics.setColor(Color.RED);
            for(CollisionEvent e : events){
                graphics.drawOval(e.getLocationEvent().x,e.getLocationEvent().y,1,1);

            }*/

            bufferStrategy.show();
            graphics.dispose();
        }
    }


    public static void main(String[] args) {
        new collideTest().simpleCollideTest();

    }
}
