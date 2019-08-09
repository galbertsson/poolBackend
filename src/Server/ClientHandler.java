package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * A class that handles the communication with a client TODO: off a server
* */
public class ClientHandler{

    //TODO: Maybe client handler should know about the Server and not the things that handels the handler?

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            System.out.println("ClientHandler setup failed, " + e.getMessage());
        }
    }

    /**
     * Sends the given string to the client
     * @param s The string to be sent to the client
     * */
    public void writeToClient(String s){
        out.write(s);
        out.flush();
    }

    /**
     * Blocks the current thread until something is received or the connection drops
     * If the client disconnects null is returned
     * */
    public String readFromClient() throws IOException {
            return in.readLine();
    }

}
