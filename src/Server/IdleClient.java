package Server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

public class IdleClient implements Runnable {

    private ClientHandler client;
    private Server server;

    public IdleClient(ClientHandler handler, Server s) {
        server = s;
        client = handler;

        System.out.println("Up and running, waiting for command");
    }

    @Override
    public void run() {
        sendChannelInfo();
        System.out.println("Sent first RMS");

        while(true){

            String in = null;
            try {
                in = client.readFromClient();
            } catch (IOException e) {
                System.out.println("Client disconnected, shutting down thread");
                return;
                //e.printStackTrace();
            }

            if(in == null){
                System.out.println("Client disconnected, shutting down thread");
                return;
            }else if(in.startsWith("/req")){
                sendChannelInfo();
            }else if(in.startsWith("/join")){
                System.out.println("Got join!");
                String channelId = in.substring(in.indexOf(" ") + 1);

                boolean success = joinChannel(channelId);

                //Quit running if we joined a server, no longer our responsibility
                if(success){
                    client.writeToClient("/succ " + channelId + "\n");
                    System.out.println("Joined channel");
                    return;
                }

                System.out.println("Failed to join");
                /*try {
                    sem.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                //return;
            }else if(in.startsWith("/crt")){
                String id = creteChannel();
                joinChannel(id);
                /*try {
                    sem.acquire();
                } catch (interruptedexception e) {
                    e.printstacktrace();
                }*/
                return;
            }

        }
    }

    private String creteChannel(){
        return server.createServer(null); //TODO: Null is always hardcoded, there must be a better solution
    }

    private boolean joinChannel(String channelId) {
        return server.joinServer(client, channelId);
    }

    private void sendChannelInfo() {
        ArrayList<ServerRoom> rooms = server.getRoomsInfo();
        StringBuilder builderRooms = new StringBuilder();
        builderRooms.append("/rms ");

        for (ServerRoom room : rooms) {
            builderRooms.append(room.KEY).append(",").append(room.getCapacity()).append(":");
        }

        builderRooms.append("\n");

        client.writeToClient(builderRooms.toString());
    }
}