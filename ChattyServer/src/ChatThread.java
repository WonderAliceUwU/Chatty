import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatThread extends Thread {
    Socket socket;
    ChatRoom room;
    DataInputStream inputStream;
    DataOutputStream outputStream;

    public ChatThread(Socket socket, ChatRoom room) {
        this.socket = socket;
        this.room = room;
        try {
            inputStream = new DataInputStream(this.socket.getInputStream());
            outputStream = new DataOutputStream(this.socket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        System.out.println("New thread started");
        while (true) {
            try {
                String message = inputStream.readUTF();
                System.out.println("mensaje:" + message);
                outputStream.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
