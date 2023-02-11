import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static ArrayList<DataOutputStream> streams;
    public static ArrayList<String> names;
    public static void main(String[] args) {
        int port=5001;
        try {
            ServerSocket server=new ServerSocket(port);
            System.out.println("Server started on port: " + port);
            streams = new ArrayList<>();
            names = new ArrayList<>();

            while(true) {
                Socket newMember = server.accept();
                System.out.println("New member");
                ChatThread thread=new ChatThread(newMember);
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error starting the server, aborting...");
            System.exit(1);
        }
    }
}
