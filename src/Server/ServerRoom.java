package Server;

import pool.Display;
import pool.EightBall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Random;

public class ServerRoom implements Runnable {

    //Socket threadSocket0;
    //Socket threadSocket1;

    private ClientHandler[] clients = new ClientHandler[2];
    public final String KEY;
    private Server server;

    //PrintWriter[] out;
    //BufferedReader[] in;

    public ServerRoom(ClientHandler c, String key, Server server) {
        System.out.println("Server Room running");
        this.server = server;
        clients[0] = c;
        KEY = key;
    }

    public synchronized boolean joinServer(ClientHandler client){
        if(clients[0] == null){
            clients[0] = client;
            return true;
        }else if(clients[1] == null){
            clients[1] = client;
            return true;
        }

        System.out.println(Arrays.toString(clients));

        return false;
    }

    public int getCapacity(){
        for (int i = 0; i < clients.length; i++) {
            if(clients[i] == null){
                return i;
            }
        }

        return clients.length;
    }

    @Override
    public void run() {
        while(clients[0] == null || clients[1] == null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("GOGOGO");
        //Setup the table
        EightBall t = new EightBall(1000, 500, 50);

        //For debug only, show the table on server side
        new Display(t);

        //Get the first players turn
        int clientTurn = new Random().nextInt(2);

        //Main server loop handling 2 clients
        while (true) {
            clients[clientTurn].writeToClient("/trn\n");

            System.out.println("Sent new turn heads up!");

            try {
                String command = clients[clientTurn].readFromClient();

                System.out.println("got the command : " + command);

                //Parse the response
                if (command == null) {
                    //A client most likely disconnected, Handle it in some nice way.
                    System.out.println("Client disconnected, shutting down the room thread!");

                    clients[(clientTurn + 1) % 2].writeToClient("/opff" + "\n");

                    //TODO: Give responsibility to a IdleClient object
                    new Thread(new IdleClient(clients[(clientTurn + 1) % 2], server)).start();
                    return;
                }

                command = command.substring(command.indexOf(" ") + 1);
                double x = Double.parseDouble(command.substring(0, command.indexOf(":")));
                double y = Double.parseDouble(command.substring(command.indexOf(":") + 1));

                //Write to the one who we dident get the data from
                clients[(clientTurn + 1) % 2].writeToClient("/sho " + x + ":" + y + "\n");

                //Simulate it server side
                t.shoot(x, y);

                System.out.println("Nothing is moving lets go!");

                clientTurn = t.getCurrentPlayer();
                //(clientTurn + 1) % 2;

            } catch (IOException e) {
                System.out.println("Client disconnected, shutting down the room thread!");
                clients[(clientTurn + 1) % 2].writeToClient("/opff" + "\n");

                new Thread(new IdleClient(clients[(clientTurn + 1) % 2], server)).start();
                //TODO: Give responsibility to a IdleClient object
                return;
            }
        }
    }
}

