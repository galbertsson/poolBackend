package Server;

import pool.Table;

import javax.swing.*;

public class DummyClientDisplay {

    public DummyClientDisplay(Table t){
        JFrame f = new JFrame();
        f.setSize(t.xWidth+100,t.yWidth+100);
        f.add(new DummyPanel(t));
        f.setTitle("Client");

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

}
