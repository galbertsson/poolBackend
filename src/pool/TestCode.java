package pool;

import java.util.HashSet;

public class TestCode {
    public static void main(String[] args) {
        /*double v1 = 5.4632266710107436;
        double v2 = 0.0;
        double  theta1 = 0.0;
        double  theta2 = 0.0;
        double  phi = 1.5707963267948966;
        double  m1 = 0.17;
        double  m2 = 0.16;

        double v1x = ((v1 * Math.cos(theta1 - phi) * (m1 - m2) + 2 * m2 * v2 * Math.cos(theta2 - phi)) / (m1 + m2)) * Math.cos(phi) - v1 * Math.sin(theta1 - phi) * Math.sin(phi);
        double v1y = ((v1 * Math.cos(theta1 - phi) * (m1 - m2) + 2 * m2 * v2 * Math.cos(theta2 - phi)) / (m1 + m2)) * Math.sin(phi) + v1 * Math.sin(theta1 - phi) * Math.cos(phi);

        double v2x = ((v2 * Math.cos(theta2 - phi) * (m1 - m2) + 2 * m1 * v1 * Math.cos(theta1 - phi)) / (m1 + m2)) * Math.cos(phi) - v2 * Math.sin(theta2 - phi) * Math.sin(phi);
        double v2y = ((v2 * Math.cos(theta2 - phi) * (m1 - m2) + 2 * m1 * v1 * Math.cos(theta1 - phi)) / (m1 + m2)) * Math.sin(phi) + v2 * Math.sin(theta2 - phi) * Math.cos(phi);

        double collisionision_angle = -1.5707963267948966;
        double new_xspeed_1 = v1*Math.cos(theta1-collisionision_angle);
        double new_yspeed_1 = v1*Math.sin(theta1-collisionision_angle);
        double new_xspeed_2 = v2*Math.cos(theta2-collisionision_angle);
        double new_yspeed_2 = v2*Math.sin(theta2-collisionision_angle);
        double final_xspeed_1 = ((m1-m2)*new_xspeed_1+(m2+m2)*new_xspeed_2)/(m1+m2);
        double final_xspeed_2 = ((m1+m1)*new_xspeed_1+(m2-m1)*new_xspeed_2)/(m1+m2);
        double final_yspeed_1 = new_yspeed_1;
        double final_yspeed_2 = new_yspeed_2;

        double ball1xspeed = Math.cos(collisionision_angle)*final_xspeed_1+Math.cos(collisionision_angle+Math.PI/2)*final_yspeed_1;
        double ball1yspeed = Math.sin(collisionision_angle)*final_xspeed_1+Math.sin(collisionision_angle+Math.PI/2)*final_yspeed_1;
        double ball2xspeed = Math.cos(collisionision_angle)*final_xspeed_2+Math.cos(collisionision_angle+Math.PI/2)*final_yspeed_2;
        double ball2yspeed = Math.sin(collisionision_angle)*final_xspeed_2+Math.sin(collisionision_angle+Math.PI/2)*final_yspeed_2;


        System.out.println(v1x);
        System.out.println(v1y);
        System.out.println(v2x);
        System.out.println(v2y);
        System.out.println("-----------------");
        System.out.println(ball1xspeed);
        System.out.println(ball1yspeed);
        System.out.println(ball2xspeed);
        System.out.println(ball2yspeed);
        System.out.println("-----------------");*/

        /*Table t = new Table(1000, 600, false);
        new Display(t);

        Ball b1 = new Ball(1,0.17,50,100,100);
        Ball b2 = new Ball(2,0.16,50,210,100);

        b1.setSpeed(10,0);
        b2.setSpeed(0,0);

        t.addBall(b1);
        t.addBall(b2);

        //After two ticks the balls should have collided
        t.timeTick();
        double oldSpeed = b1.getxSpeed();
        t.timeTick();
        t.timeTick();*/
/*
        Ball firstBall = new Ball(1,0.17,50,10,10);
        Ball secondBall = new Ball(2,0.16,50,200,200);


        double dx = firstBall.getxPosition()-secondBall.getxPosition();
        double dy = firstBall.getyPosition()-secondBall.getyPosition();
        double collisionision_angle = Math.atan2(dy, dx);
        double magnitude_1 = Math.sqrt(Math.abs(Math.pow(firstBall.getxSpeed(), 2) + Math.pow(firstBall.getySpeed(), 2)));
        double magnitude_2 = Math.sqrt(Math.abs(Math.pow(secondBall.getxSpeed(), 2) + Math.pow(secondBall.getySpeed(), 2)));
        double direction_1 = Math.atan2(firstBall.getySpeed(), firstBall.getxSpeed());
        double direction_2 = Math.atan2(secondBall.getySpeed(), secondBall.getxSpeed());
        double new_xspeed_1 = magnitude_1*Math.cos(direction_1-collisionision_angle);
        double new_yspeed_1 = magnitude_1*Math.sin(direction_1-collisionision_angle);
        double new_xspeed_2 = magnitude_2*Math.cos(direction_2-collisionision_angle);
        double new_yspeed_2 = magnitude_2*Math.sin(direction_2-collisionision_angle);
        double final_xspeed_1 = ((firstBall.weight-secondBall.weight)*new_xspeed_1+(secondBall.weight+secondBall.weight)*new_xspeed_2)/(firstBall.weight+secondBall.weight);
        double final_xspeed_2 = ((firstBall.weight+firstBall.weight)*new_xspeed_1+(secondBall.weight-firstBall.weight)*new_xspeed_2)/(firstBall.weight+secondBall.weight);
        double final_yspeed_1 = new_yspeed_1;
        double final_yspeed_2 = new_yspeed_2;

        double ball1xspeed = Math.cos(collisionision_angle)*final_xspeed_1+Math.cos(collisionision_angle+Math.PI/2)*final_yspeed_1;
        double ball1yspeed = Math.sin(collisionision_angle)*final_xspeed_1+Math.sin(collisionision_angle+Math.PI/2)*final_yspeed_1;
        double ball2xspeed = Math.cos(collisionision_angle)*final_xspeed_2+Math.cos(collisionision_angle+Math.PI/2)*final_yspeed_2;
        double ball2yspeed = Math.sin(collisionision_angle)*final_xspeed_2+Math.sin(collisionision_angle+Math.PI/2)*final_yspeed_2;

        firstBall.setSpeed(ball1xspeed,ball1yspeed);
        secondBall.setSpeed(ball2xspeed,ball2yspeed);
        */
    }
}
