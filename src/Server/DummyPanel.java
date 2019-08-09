package Server;

import pool.Ball;
import pool.Table;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class DummyPanel extends JPanel {

    Table t;

    public DummyPanel(Table t){
        this.t = t;
        this.setSize(t.xWidth,t.yWidth);
        //this.setBackground(Color.green);
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

        int i = 0;
        double[] radius = t.getBallRadius();

        for (double[] position : t.getBallPositions()) {
            g.drawOval((int)(position[0]-radius[i]), (int)(position[1]-radius[i]), (int)radius[i]*2, (int)radius[i]*2);
            //g.drawLine((int)position[0],(int)position[1],(int)(position[0]+ball.getxSpeed()*5),(int)(position[1]+ball.getySpeed()*5));
            i++;
        }

        //g.drawLine((int)t.balls.get(0).getxPosition(),(int)t.balls.get(0).getyPosition(),(int)t.balls.get(1).getxPosition(),(int)t.balls.get(1).getyPosition());

        //g.setColor(Color.RED);
        //g.fillOval((int)t.collisionPointX,(int)t.collisionPointY,2,2);

    }
}
