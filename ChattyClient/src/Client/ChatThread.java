package Client;
import java.io.IOException;
import java.net.Socket;

public class ChatThread extends Thread{
    Socket socket;
    public ChatThread(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        while (true) {
            try {
                String message = LoginWindow.inputStream.readUTF();
                String [] splitMessage = message.split(">");
                if(splitMessage.length > 1){
                    System.out.println(splitMessage[0] + " > " + splitMessage[1]);
                    UI.MessengerWindowUI.enterMessage(splitMessage[1], splitMessage[0]);
                }
            } catch (IOException e) {
                System.exit(0);
            }
        }
    }
}
