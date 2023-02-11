import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatThread extends Thread {
    Socket socket;
    DataInputStream inputStream;
    public boolean nameExist;
    public String nickname;
    public ChatThread(Socket socket) {
        this.socket = socket;
        try {
            inputStream = new DataInputStream(this.socket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void run() {
        try {
            nickname = inputStream.readUTF();
            DataOutputStream memberOutput = new DataOutputStream(socket.getOutputStream());
            System.out.println("Nickname received");
            System.out.println("Nickname " + nickname);
            nameExist = false;
            for (int i = 0; i < Main.names.size(); i++){
                if (nickname.equals(Main.names.get(i))) {
                    nameExist = true;
                    break;
                }
            }
            if(!nameExist){
                Main.streams.add(memberOutput);
                Main.names.add(nickname);
                try {
                    memberOutput.writeBoolean(false);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                while (true) {
                    String message = inputStream.readUTF();
                    System.out.println("Message: " + message);
                    for (int i = 0; i < Main.streams.size(); i++) {
                        Main.streams.get(i).writeUTF(message);
                    }
                }
            }
            memberOutput.writeBoolean(true);
        } catch (IOException e) {
            System.out.println("Member disconnected");
        } finally {
            if(!nameExist){
                Main.names.remove(nickname);
            }
            interrupt();
        }
    }
}