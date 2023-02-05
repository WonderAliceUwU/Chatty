import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatThread extends Thread{
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
        while (true) {
            try {
                String message = inputStream.readUTF();
                System.out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
