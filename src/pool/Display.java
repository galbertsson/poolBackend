package pool;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class Display{
    public Display(PoolTable t){
        JFrame f = new JFrame();
        f.setSize(t.xWidth+100,t.yWidth+100);
        PoolPanel p = new PoolPanel(t);

        f.add(p);
        f.setTitle("Server");

        //f.pack();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
