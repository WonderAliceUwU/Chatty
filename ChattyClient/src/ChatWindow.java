import UI.MessengerWindowUI;
import UI.StartWindowUI;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatWindow {
    public static void Main(){
        StartWindowUI.startWindow.setVisible(false);
        MessengerWindowUI.createWindow();
        MessengerWindowUI.welcomeLabel.setText("  You're chatting as " + LoginWindow.nickname);

        int port=5001;
        String name=LoginWindow.nickname;

        try{
            Socket clientSocket= new Socket("localhost",port);
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

            ChatThread thread=new ChatThread(clientSocket);
            thread.start();

            MessengerWindowUI.sendMessageButton.addActionListener(e->{
                String message = MessengerWindowUI.sendMessageField.getText();
                try{
                    outputStream.writeUTF(name+"> "+message);
                    MessengerWindowUI.sendMessageField.setText("");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
