package Client;

import UI.MessengerWindowUI;
import UI.StartWindowUI;
import java.io.IOException;

public class ChatWindow {
    public static void Main(){
        StartWindowUI.startWindow.setVisible(false);
        MessengerWindowUI.createWindow();
        String name=LoginWindow.nickname;

        MessengerWindowUI.welcomeLabel.setText("  You're chatting as " + name);

        ChatThread thread=new ChatThread(LoginWindow.clientSocket);
        thread.start();

        MessengerWindowUI.sendMessageButton.addActionListener(e->{
            String message = MessengerWindowUI.sendMessageField.getText();
            if(!message.isBlank()){
                try{
                    LoginWindow.outputStream.writeUTF(name+">"+message);
                    MessengerWindowUI.sendMessageField.setText("");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });
    }
}
