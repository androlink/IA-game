package graphicTest;

import hitbox.HitBox2D;
import hitbox.Side;
import hitbox.SimpleSquareHitBox;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import rayCasting.CastEvent;
import rayCasting.CastManager;
import rayCasting.Particle;
import rayCasting.SimpleCastManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Random;

public class CastTest {


    public void simpleCastManagerTest(){
        JFrame f = new JFrame("simpleCastManagerTest");
        f.setSize(400,400);
        f.setVisible(true);
        f.setDefaultCloseOperation(3);




        Canvas canvas = new Canvas();
        canvas.setSize(400,400);
        f.add(canvas);


        SimpleCastManager castManager = new SimpleCastManager(new Point(250,250));

        ArrayList<HitBox2D> hitBox2DS = new ArrayList<>();

        hitBox2DS.add(new SimpleSquareHitBox(new Point(250,250),250));
        Random random = new Random();
        for(int i = 0;i<50;i++)hitBox2DS.add(new SimpleSquareHitBox(new Point(random.nextInt(400),random.nextInt(400)),random.nextInt(5,20)));



        canvas.createBufferStrategy(3);

        boolean running = true;

        BufferStrategy bufferStrategy;
        Graphics graphics;
        ArrayList<CastEvent> castEvent;

        while (running) {
            castManager.setLocation(MouseInfo.getPointerInfo().getLocation());
            bufferStrategy = canvas.getBufferStrategy();
            graphics = bufferStrategy.getDrawGraphics();
            graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

            castEvent = castManager.watch(hitBox2DS);
            graphics.setColor(Color.RED);
            for(CastEvent e:castEvent){
                graphics.drawLine(e.getInitalLocation().x,e.getInitalLocation().y,e.getInteractLocation().x,e.getInteractLocation().y);
            }
            /*
            graphics.setColor(Color.RED);
            for(HitBox2D hitBox2D:hitBox2DS) {
                for(Side s:hitBox2D.getSides()){
                    graphics.drawLine(s.getCorner()[0].x,s.getCorner()[0].y,s.getCorner()[1].x,s.getCorner()[1].y);
                }
            }*/
            graphics.setColor(Color.BLUE);
            for(CastEvent e:castEvent){
                graphics.drawOval(e.getInteractLocation().x, e.getInteractLocation().y, 1, 1);
            }
            bufferStrategy.show();
            graphics.dispose();
        }
    }
    public void castTest(){
        JFrame f = new JFrame("simpleCastManagerTest");
        f.setSize(400,400);
        f.setVisible(true);
        f.setDefaultCloseOperation(3);

        Canvas canvas = new Canvas();
        canvas.setSize(400,400);
        f.add(canvas);

        SimpleSquareHitBox squareHitBox = new SimpleSquareHitBox(new Point(200,200),50);





        canvas.createBufferStrategy(3);

        boolean running = true;

        BufferStrategy bufferStrategy;
        Graphics graphics;

        while (running) {

            bufferStrategy = canvas.getBufferStrategy();
            graphics = bufferStrategy.getDrawGraphics();
            graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

            for(int j=0;j<400;j++) {
                for (int i = 0; i < 400; i++) {
                    for(int a = 0; a < 360 ; a++) {
                        Particle particle = new Particle(new Point(i, j), Math.toRadians(a), 1000);
                        CastEvent event = particle.cast(squareHitBox);
                        if (event != null) {
                            graphics.setColor(Color.GREEN);
                            //graphics.drawOval(event.getInitalLocation().x, event.getInitalLocation().y, 1, 1);
                            graphics.setColor(Color.BLUE);
                            graphics.drawOval(event.getInteractLocation().x, event.getInteractLocation().y, 1, 1);
                        }
                    }
                }
            }
            graphics.setColor(Color.RED);
            for(Side s:squareHitBox.getSides()){
                graphics.drawLine(s.getCorner()[0].x,s.getCorner()[0].y,s.getCorner()[1].x,s.getCorner()[1].y);
            }
            System.out.println("drawed");

            bufferStrategy.show();
            graphics.dispose();
        }
    }
    public void sideTest(){
        JFrame f = new JFrame("simpleCastManagerTest");
        f.setSize(400,400);
        f.setVisible(true);
        f.setDefaultCloseOperation(3);

        Canvas canvas = new Canvas();
        canvas.setSize(400,400);
        f.add(canvas);

        Side side = new Side(new Point(150,150),new Point(250,250));





        canvas.createBufferStrategy(3);

        boolean running = true;

        BufferStrategy bufferStrategy;
        Graphics graphics;

        while (running) {

            bufferStrategy = canvas.getBufferStrategy();
            graphics = bufferStrategy.getDrawGraphics();
            graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

            for(int j=0;j<400;j++) {
                for (int i = 0; i < 400; i++) {
                    for(int a = 0; a < 360 ; a++) {
                        Particle particle = new Particle(new Point(i, j), Math.toRadians(a), 1000);
                        Point event = particle.cast(side.getCorner());
                        if (event != null) {
                            graphics.setColor(Color.GREEN);
                            //graphics.drawOval(event.getInitalLocation().x, event.getInitalLocation().y, 1, 1);
                            graphics.setColor(Color.BLUE);
                            graphics.drawOval(event.x, event.y, 1, 1);
                        }
                    }
                }
            }
            graphics.setColor(Color.RED);
            //graphics.drawLine(side.getCorner()[0].x,side.getCorner()[0].y,side.getCorner()[1].x,side.getCorner()[1].y);
            System.out.println("drawed");


            bufferStrategy.show();
            graphics.dispose();
        }
    }


    public static void main(String[] args) {
        new CastTest().simpleCastManagerTest();
        //new CastTest().castTest();
        //new CastTest().sideTest();
    }

}
