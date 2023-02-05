import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        int port=5001;
        try {
            ServerSocket server=new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            Socket[] tabla = new Socket[20];
            ChatRoom sala=new ChatRoom(0,0,tabla);

            while(true) {
                Socket newMember = server.accept();
                System.out.println("New member");

                sala.addTabla(newMember, sala.getConnections());
                sala.setOngoingConnections(sala.getOngoingConnections()+1);
                sala.setConnections(sala.getConnections()+1);

                ChatThread thread=new ChatThread(newMember,sala);
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error starting the server, aborting...");
            System.exit(1);
        }
    }
}
