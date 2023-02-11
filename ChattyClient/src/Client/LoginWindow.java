package Client;

import UI.StartWindowUI;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class LoginWindow {
    public static String nickname;
    public static final int port = 5001;
    public static Socket clientSocket;
    public static DataOutputStream outputStream;
    public static DataInputStream inputStream;
    public static void main(String[] args) {
        StartWindowUI.createWindow();
        StartWindowUI.loginButton.addActionListener(e -> {
            boolean isEmpty = false;
            if (StartWindowUI.nicknameField.getText().isEmpty()) {StartWindowUI.errorLabel.setVisible(true); isEmpty = true;}
            if(!isEmpty) {
                nickname = StartWindowUI.nicknameField.getText();
                try {
                    Socket clientSocket= new Socket("localhost",port);
                    outputStream = new DataOutputStream(clientSocket.getOutputStream());
                    outputStream.writeUTF(nickname);
                    inputStream = new DataInputStream(clientSocket.getInputStream());
                    boolean exist = inputStream.readBoolean();
                    if(!exist){
                        ChatWindow.Main();
                    }
                    else{
                        StartWindowUI.errorLabel.setText("The username is already taken");
                        StartWindowUI.errorLabel.setLocation(StartWindowUI.errorLabel.getX() - 20, StartWindowUI.errorLabel.getY());
                        StartWindowUI.errorLabel.setVisible(true);
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}