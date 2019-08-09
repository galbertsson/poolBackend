package pool;

public class Main {

    public static void main(String[] args) {
        //EightBall t = new EightBall(1000, 500,50);
        PoolTable t = new PoolTable(1000,600,50);

        new Display(t);

        //Clipping the ball following

		Ball b1 = new Ball(1,0.16,10,100,150);
		//Ball b2 = new Ball(2,0.16,10,300,150);
        //Ball b3 = new Ball(2,0.16,10,350,150);

		//b1.setSpeed(10,0);
		//b2.setSpeed(0,0);

		//Clipping the ball left to right
		//Ball b1 = new Ball(1,0.16,50,100,150);
		//Ball b2 = new Ball(2,0.16,50,400,150);

		//b1.setSpeed(0,0);
		//b2.setSpeed(-10,0);

		//Clipping the ball right to left
/*
		Ball b1 = new Ball(1,0.17,50,500,150);
		Ball b2 = new Ball(2,0.16,50,100,100);

		b1.setSpeed(-10,0);
		b2.setSpeed(0,0);
*/
		//Clipping bottom to top
/*
		Ball b1 = new Ball(1,0.17,50,100,500);
		Ball b2 = new Ball(2,0.16,50,120,100);

		b1.setSpeed(0,-10);
		b2.setSpeed(0,0);
*/

		//Clipping top to bottom and bouncing?
/*
		Ball b1 = new Ball(1,0.17,50,100,100);
		Ball b2 = new Ball(2,0.16,50,120,450);

		b1.setSpeed(0,10);
		b2.setSpeed(0,0);
*/

		//Clipping top to bottom
		/*
		Ball b1 = new Ball(1,0.17,50,100,100);
		Ball b2 = new Ball(2,0.16,50,120,300);

		b1.setSpeed(0,10);
		b2.setSpeed(0,0);
*/
		//Diagonal hit
		/*Ball b1 = new Ball(1,0.17,50,100,100);
		Ball b2 = new Ball(2,0.16,50,400,400);

		b1.setSpeed(10,10);
		b2.setSpeed(0,0);
*/

		//4 ball collision

		/*Ball b1 = new Ball(1,0.17,50,400,250);
		Ball b2 = new Ball(2,0.16,50,630,300);

		b1.setSpeed(2,0);
//		b2.setSpeed(0,0);

		Ball b3 = new Ball(3,0.16,50,680,200);
		//Ball b4 = new Ball(4,0.16,50,700,300);
*/
        /*Ball b1 = new Ball(1,0.17,50,400,250);
		Ball b2 = new Ball(2,0.16,50,600,300);

		b1.setSpeed(2,0);

		Ball b3 = new Ball(3,0.16,50,680,350);
		Ball b4 = new Ball(4,0.16,50,720,400);
*/
		//t.addBall(b1);
        //t.addBall(b2);
		//t.addBall(b3);
		//t.addBall(b4);

        //t.setCueBallSpeed(30,0);
        //t.shoot(20,1);
        //t.shoot(2,0);

        //b1.setSpeed(-2,0);
    }
}
