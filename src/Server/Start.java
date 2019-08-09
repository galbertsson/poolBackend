package Server;

public class Start {
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("No port supplied!");
        }else{
            new Server(args[0]);
        }
    }
}