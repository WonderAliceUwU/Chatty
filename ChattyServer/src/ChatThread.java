import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatThread extends Thread {
    Socket socket;
    DataInputStream inputStream;
    public ChatThread(Socket socket) {
        this.socket = socket;
        try {
            inputStream = new DataInputStream(this.socket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        System.out.println("New thread started");
        while (true) {
            try {
                String message = inputStream.readUTF();
                System.out.println("Message: " + message);
                for (int i = 0; i < Main.streams.size(); i++){
                    Main.streams.get(i).writeUTF(message);
                }
            } catch (IOException e) {
                System.out.println("Member disconnected");
                stop();
            }
        }
    }
}