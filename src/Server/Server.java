package Server;

import pool.Display;
import pool.EightBall;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * Communication protocol over TCP
 * /sho x:y - used to send x:y from the client to the server, where x is the new x speed, y is the new y speed of the cue ball this value is a double, after sho is send the turn is switched
 * /trn - Notifies a client that is their turn
 * /skp - Notifies a client that it/the other client was skipped due to timeout/AFK prevention
 * /opff - Notifies a client that the other client has forfeited, this is the case when they leave the game/ gets disconnected
 * /crt - The client creates a room
**/
public class Server {

    private Map<String, ServerRoom> rooms = new HashMap<String, ServerRoom>();

    private Random rand = new Random();

    private int KEY_LENGTH = 5;

    public Server(String stringPort){
        int port = Integer.parseInt(stringPort);

        try {
            ServerSocket s = new ServerSocket(port);
            System.out.println("Server is running on " + s.getInetAddress() + ":" + port);

            System.out.println("Creating some test channels:");
            /*createServer(null);
            createServer(null);
            createServer(null);
            createServer(null);
            createServer(null);
            createServer(null);*/


            while(true) {
                Socket socket = s.accept();
                System.out.println("Client connected " + socket.getInetAddress());

                //Create handler for the client
                ClientHandler handler = new ClientHandler(socket);
                new Thread(new IdleClient(handler, this)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the rooms created right now
     * */
    public ArrayList <ServerRoom> getRoomsInfo(){
        ArrayList <ServerRoom> roomsCopy = new ArrayList<>(rooms.size());

        roomsCopy.addAll(rooms.values());

        return roomsCopy;
    }

    public String createServer(ClientHandler c){
        String key = generateRandomKey();
        ServerRoom room = new ServerRoom(c, key, this);
        new Thread(room).start();

        rooms.put(key,room);

        return key;
    }

    private String generateRandomKey() {
        StringBuilder key = new StringBuilder(KEY_LENGTH);
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();

        for(int i = 0;i<KEY_LENGTH;i++){
            key.append(chars[rand.nextInt(chars.length)]);
        }

        return key.toString();
    }

    public boolean joinServer(ClientHandler c, String roomId){
        ServerRoom room = rooms.get(roomId);
        boolean successfulJoin = room.joinServer(c);

        return successfulJoin;
    }

}
