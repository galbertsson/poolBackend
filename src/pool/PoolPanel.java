package pool;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class PoolPanel extends JPanel {

    PoolTable t;

    public PoolPanel(PoolTable t){
        this.t = t;
        this.setSize(t.xWidth,t.yWidth);
        this.setBackground(Color.lightGray);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new Redraw(),0,15);
    }

    class Redraw extends TimerTask {
        @Override
        public void run() {
            repaint();
        }
    }

    @Override
    protected  void paintComponent (Graphics g){
        super.paintComponent(g);
        for (Ball ball : t.balls) {
            g.drawOval((int)(ball.getxPosition()-ball.radius), (int)(ball.getyPosition()-ball.radius), (int)ball.radius*2, (int)ball.radius*2);
            if(ball.number > 9){
                g.drawLine((int)ball.getxPosition()-5,(int)ball.getyPosition()-5,(int)(ball.getxPosition()+5),(int)(ball.getyPosition()-5));
                g.drawLine((int)ball.getxPosition()-5,(int)ball.getyPosition()+5,(int)(ball.getxPosition()+5),(int)(ball.getyPosition()+5));
            }
            //g.fillOval((int)(ball.getxPosition()), (int)(ball.getyPosition()), 4, 4);
            //g.drawLine(0,(int)(ball.getyPosition()+ball.radius),800,(int)(ball.getyPosition()+ball.radius));
            g.drawLine((int)ball.getxPosition(),(int)ball.getyPosition(),(int)(ball.getxPosition()+ball.getxSpeed()*5),(int)(ball.getyPosition()+ball.getySpeed()*5));
        }

        //Draw the pockets
        for(PoolPocket pocket : t.pockets){
            g.fillOval((int)(pocket.X-(pocket.RADIUS)), (int)(pocket.Y-(pocket.RADIUS)),(int)pocket.RADIUS*2,(int)pocket.RADIUS*2);
        }

        //Draw the table edges
        g.drawLine(0,0, t.xWidth,0);
        g.drawLine(0,0, 0,t.yWidth);
        g.drawLine(t.xWidth,0, t.xWidth,t.yWidth);
        g.drawLine(0,t.yWidth, t.xWidth,t.yWidth);
        //g.drawLine((int)t.balls.get(0).getxPosition(),(int)t.balls.get(0).getyPosition(),(int)t.balls.get(1).getxPosition(),(int)t.balls.get(1).getyPosition());

        //g.setColor(Color.RED);
        //g.fillOval((int)t.collisionPointX,(int)t.collisionPointY,2,2);
    }
}
