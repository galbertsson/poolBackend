package Server;

import pool.EightBall;

import java.io.*;
import java.net.Socket;

public class DummyClient {
    public static void main(String[] args) {
        new DummyClient();
    }

    public DummyClient(){
        EightBall t = new EightBall(1000, 500,50);

        new DummyClientDisplay(t);

        try {
            Socket s = new Socket("127.0.0.1", 25515);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(),true);

            System.out.println("Ready");

            while(true) {
                System.out.println("Ready for next command");
                String message = in.readLine();
                if(message.startsWith("/trn")){//Our turn to shoot
                    System.out.println("Our turn and we shoot!");
                    out.write("/sho " + 50 + ":" + 100 + "\n");
                    out.flush();
                    double[] pos = t.getCueBallPosition();

                    t.shoot(pos[0]-50,pos[1]-100);

                }else if(message.startsWith("/skp")){//Someones turn in skipped, Change GUI
                    System.out.println("Skipped turn, toggle UI");
                }else if(message.startsWith("/sho")){//The other client shot
                    message = message.substring(message.indexOf(" ")+1);
                    int x = Integer.parseInt(message.substring(0,message.indexOf(":")));
                    int y = Integer.parseInt(message.substring(message.indexOf(":")+1));
                    double[] pos = t.getCueBallPosition();

                    t.shoot(pos[0]-x,pos[1]-y);
                }
            }

        } catch (IOException e) {
            System.out.println("Failed to open socket");
            e.printStackTrace();
        }


    }


}
