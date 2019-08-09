package Test;

import org.junit.Assert;
import org.junit.Test;
import pool.Ball;
import pool.Table;

public class BallTests {
    @Test
    public void collisionLow(){
        Table t = new Table(1000, 600, -1);

        Ball b1 = new Ball(1,0.17,50,100,400);
        Ball b2 = new Ball(2,0.16,50,200,350);

        b1.setSpeed(10,0);
        b2.setSpeed(0,0);

        //Ball b3 = new Ball(3,0.16,50,700,250);
        //Ball b4 = new Ball(4,0.16,50,700,500);

        t.addBall(b1);
        t.addBall(b2);
        //t.addBall(b3);
        //t.addBall(b4);

        //After two ticks the balls should have collided
        t.timeTick();
        t.timeTick();

        Assert.assertTrue(b1.getySpeed() > 0);
        Assert.assertTrue(b2.getySpeed() < 0);
    }

    @Test
    public void collisionTopLeftDiagonal(){
        Table t = new Table(1000, 600, -1);

        Ball b1 = new Ball(1,0.17,50,100,100);
        Ball b2 = new Ball(2,0.16,50,170,170);

        b1.setSpeed(10,10);
        b2.setSpeed(0,0);

        t.addBall(b1);
        t.addBall(b2);

        //After three ticks the balls have collided
        t.timeTick();
        t.timeTick();
        t.timeTick();

        Assert.assertTrue(b1.getxSpeed() > 0);
        Assert.assertTrue(b1.getySpeed() > 0);

        Assert.assertTrue(b2.getxSpeed() > 0);
        Assert.assertTrue(b2.getySpeed() > 0);
    }

    @Test
    public void collisionLeft(){
        Table t = new Table(1000, 600, -1);

        Ball b1 = new Ball(1,0.16,50,100,100);
        Ball b2 = new Ball(2,0.16,50,210,100);

        b1.setSpeed(10,0);
        b2.setSpeed(0,0);

        t.addBall(b1);
        t.addBall(b2);

        //After two ticks the balls should have collided
        t.timeTick();
        double oldSpeed = b1.getxSpeed();
        t.timeTick();
        t.timeTick();
        t.timeTick();

        Assert.assertTrue(b1.getxSpeed() < oldSpeed);

        Assert.assertTrue(b2.getxSpeed() > oldSpeed-1); //If the ball we hit is much slower then what we hit with something is wrong
        //Assert.assertTrue(b2.getxSpeed() < oldSpeed); //If the speed we hit with is smaller then what we gave something is wrong


        Assert.assertTrue(b2.getxSpeed()>b1.getxSpeed()); //The ball we hit should now be faster then us
        //Assert.assertTrue(b2.getySpeed() > 0);
    }

}
