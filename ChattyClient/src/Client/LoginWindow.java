package Client;

import UI.StartWindowUI;
public class LoginWindow {
    public static String nickname;
    public static void main(String[] args) {
        StartWindowUI.createWindow();
        StartWindowUI.loginButton.addActionListener(e -> {
            boolean isEmpty = false;
            if (StartWindowUI.nicknameField.getText().isEmpty()) {StartWindowUI.errorLabel.setVisible(true); isEmpty = true;}
            if(!isEmpty) {
                nickname = StartWindowUI.nicknameField.getText();
                ChatWindow.Main();
            }
        });
    }
}