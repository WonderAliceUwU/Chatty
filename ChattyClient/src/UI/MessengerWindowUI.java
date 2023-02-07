package UI;
import Client.LoginWindow;
import CustomElements.CustomScrollBarUI;
import CustomElements.RoundJTextArea;
import CustomElements.RoundJTextFieldHint;
import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class MessengerWindowUI {
    public static JFrame messengerWindowFrame;
    public static JLabel welcomeLabel;
    public static JTextField sendMessageField;
    public static JButton sendMessageButton;
    public static JPanel chatPanel;
    public static RoundJTextArea text;
    public static JScrollPane scrollFrame;
    public static void createWindow() {
        Font customRegularFont = StartWindowUI.createNormalFont();
        Font customTitleFont = StartWindowUI.createTitleFont();

        messengerWindowFrame = new JFrame();
        messengerWindowFrame.setIconImage(new ImageIcon("Images/Chatty.png").getImage());
        messengerWindowFrame.setSize(600, 700);
        messengerWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StartWindowUI.setBackgroundImage(messengerWindowFrame, "Images/ChatTemplate.png");
        messengerWindowFrame.setLayout(null);
        messengerWindowFrame.setLocationRelativeTo(null);
        messengerWindowFrame.setResizable(false);


        welcomeLabel = new JLabel("You're chatting as", getIcon("Images/UserIcon.png", 50, 50), SwingConstants.CENTER);
        assert customTitleFont != null;
        welcomeLabel.setFont(customTitleFont.deriveFont(Font.BOLD));
        welcomeLabel.setForeground(Color.white);
        welcomeLabel.setBounds(JLabel.CENTER, 20, 600, 50);

        sendMessageField = new RoundJTextFieldHint(0, "Put some nice things");
        sendMessageField.setFont(customRegularFont);
        sendMessageField.setBounds(20, 615, 520, 40);

        sendMessageButton = new JButton(getIcon("Images/SendMessageIcon.png", 30, 30));
        sendMessageButton.setBounds(550, 620, 30, 30);
        sendMessageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        chatPanel = new JPanel();
        chatPanel.setPreferredSize(new Dimension( 480,480));
        chatPanel.setLayout(null);
        chatPanel.setAutoscrolls(true);
        chatPanel.setBackground(Color.decode("#20262E"));

        scrollFrame = new JScrollPane(chatPanel);
        scrollFrame.setBorder(BorderFactory.createEmptyBorder());
        scrollFrame.setBounds(50, 100, 500, 480);
        scrollFrame.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        scrollFrame.getVerticalScrollBar().setBackground(Color.decode("#20262E"));
        scrollFrame.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        messengerWindowFrame.add(scrollFrame);
        messengerWindowFrame.add(welcomeLabel);
        messengerWindowFrame.add(sendMessageButton);
        messengerWindowFrame.add(sendMessageField);
        messengerWindowFrame.setVisible(true);
    }
    private static ImageIcon getIcon(String iconPath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(iconPath);
        Image newimg = imageIcon.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }
    public static void enterMessage(String message, String nickname){
        JScrollBar vertical = MessengerWindowUI.scrollFrame.getVerticalScrollBar();

        JLabel messageInfo = new JLabel();
        if(LocalTime.now().getMinute() < 10){
            messageInfo.setText(LoginWindow.nickname + " - " + LocalTime.now().getHour() + ":0"+LocalTime.now().getMinute());
        }
        else{
            messageInfo.setText(nickname + " - " + LocalTime.now().getHour() + ":"+LocalTime.now().getMinute());
        }
        messageInfo.setFont(StartWindowUI.createLabelFont());
        messageInfo.setForeground(Color.decode("#E9E8E8"));

        RoundJTextArea text = new RoundJTextArea(message, 1, 1);
        text.setLocation(15, vertical.getMaximum());
        text.setMaximumSize(new Dimension(280, 80));
        text.setPreferredSize(new Dimension(280, 80));
        text.setEditable(false);
        text.setMargin( new Insets(0,5,0,0) );
        text.setLineWrap( true );
        text.setWrapStyleWord( true );
        text.setBackground(Color.decode("#E9E8E8"));
        text.setFont(StartWindowUI.createNormalFont());
        text.setForeground(Color.black);

        if(nickname.equals(LoginWindow.nickname)){
            if(message.length() < 5)  {
                text.setSize(40, 25);
                text.setLocation(chatPanel.getWidth() - text.getWidth() - 20, vertical.getMaximum());
                MessengerWindowUI.chatPanel.setPreferredSize(new Dimension( MessengerWindowUI.chatPanel.getWidth(),
                        MessengerWindowUI.chatPanel.getHeight() + 45));
                messageInfo.setBounds(chatPanel.getWidth() - 114,  text.getY() - 13, 300, 10);
            }
            if (message.length() <= 10 && message.length() >= 5) {
                text.setSize(message.length()*12, 25);
                text.setLocation(chatPanel.getWidth() - text.getWidth() - 20, vertical.getMaximum());
                MessengerWindowUI.chatPanel.setPreferredSize(new Dimension( MessengerWindowUI.chatPanel.getWidth(),
                        MessengerWindowUI.chatPanel.getHeight() + 45));
                messageInfo.setBounds(chatPanel.getWidth() - 114,  text.getY() - 13, 300, 10);
            }
            if (message.length() <= 40 && message.length() > 10) {
                text.setSize(message.length()*9, 25);
                text.setLocation(chatPanel.getWidth() - text.getWidth() - 20, vertical.getMaximum());
                MessengerWindowUI.chatPanel.setPreferredSize(new Dimension( MessengerWindowUI.chatPanel.getWidth(),
                        MessengerWindowUI.chatPanel.getHeight() + 50));
                messageInfo.setBounds(chatPanel.getWidth() - 114,  text.getY() - 13, 300, 10);
            }
            if (message.length() <= 68 && message.length() > 40) {
                text.setRows(2);
                text.setSize(message.length()*5, 45);
                text.setLocation(chatPanel.getWidth() - text.getWidth() - 20, vertical.getMaximum());
                MessengerWindowUI.chatPanel.setPreferredSize(new Dimension( MessengerWindowUI.chatPanel.getWidth(),
                        MessengerWindowUI.chatPanel.getHeight() + 62));
                messageInfo.setBounds(chatPanel.getWidth() - 114,  text.getY() - 13, 300, 10);
            }
            if (message.length() <= 120 && message.length() > 68) {
                text.setRows(3);
                text.setSize(message.length()*3, 65);
                text.setLocation(chatPanel.getWidth() - text.getWidth() - 20, vertical.getMaximum());
                MessengerWindowUI.chatPanel.setPreferredSize(new Dimension( MessengerWindowUI.chatPanel.getWidth(),
                        MessengerWindowUI.chatPanel.getHeight() + 85));
                messageInfo.setBounds(chatPanel.getWidth() - 114,  text.getY() - 13, 300, 10);
            }
            if (message.length() <= 150 && message.length() > 120) {
                text.setRows(4);
                text.setSize(message.length()*2, 85);
                text.setLocation(chatPanel.getWidth() - text.getWidth() - 20, vertical.getMaximum());
                MessengerWindowUI.chatPanel.setPreferredSize(new Dimension( MessengerWindowUI.chatPanel.getWidth(),
                        MessengerWindowUI.chatPanel.getHeight() + 105));
                messageInfo.setBounds(chatPanel.getWidth() - 114,  text.getY() - 13, 300, 10);
            }
        }
        else{
            if(message.length() < 5)  {
                text.setSize(40, 25);
                MessengerWindowUI.chatPanel.setPreferredSize(new Dimension( MessengerWindowUI.chatPanel.getWidth(),
                        MessengerWindowUI.chatPanel.getHeight() + 45));
                messageInfo.setBounds(text.getX(),  text.getY() - 13, 300, 10);
            }
            if (message.length() <= 10 && message.length() >= 5) {
                text.setSize(message.length()*12, 25);
                MessengerWindowUI.chatPanel.setPreferredSize(new Dimension( MessengerWindowUI.chatPanel.getWidth(),
                        MessengerWindowUI.chatPanel.getHeight() + 45));
                messageInfo.setBounds(text.getX(),  text.getY() - 13, 300, 10);
            }
            if (message.length() <= 40 && message.length() > 10) {
                text.setSize(message.length()*9, 25);
                MessengerWindowUI.chatPanel.setPreferredSize(new Dimension( MessengerWindowUI.chatPanel.getWidth(),
                        MessengerWindowUI.chatPanel.getHeight() + 50));
                messageInfo.setBounds(text.getX(),  text.getY() - 18, 300, 20);
            }
            if (message.length() <= 68 && message.length() > 40) {
                text.setRows(2);
                text.setSize(message.length()*5, 45);
                MessengerWindowUI.chatPanel.setPreferredSize(new Dimension( MessengerWindowUI.chatPanel.getWidth(),
                        MessengerWindowUI.chatPanel.getHeight() + 62));
                messageInfo.setBounds(text.getX(),  text.getY() - 18, 300, 20);
            }
            if (message.length() <= 120 && message.length() > 68) {
                text.setRows(3);
                text.setSize(message.length()*3, 65);
                MessengerWindowUI.chatPanel.setPreferredSize(new Dimension( MessengerWindowUI.chatPanel.getWidth(),
                        MessengerWindowUI.chatPanel.getHeight() + 85));
                messageInfo.setBounds(text.getX(),  text.getY() - 18, 300, 20);
            }
            if (message.length() <= 150 && message.length() > 120) {
                text.setRows(4);
                text.setSize(message.length()*2, 85);
                MessengerWindowUI.chatPanel.setPreferredSize(new Dimension( MessengerWindowUI.chatPanel.getWidth(),
                        MessengerWindowUI.chatPanel.getHeight() + 105));
                messageInfo.setBounds(text.getX(),  text.getY() - 18, 300, 20);
            }
        }

        MessengerWindowUI.chatPanel.add(messageInfo);
        MessengerWindowUI.chatPanel.add(text);
        MessengerWindowUI.chatPanel.updateUI();

        SwingUtilities.invokeLater(() -> scrollFrame.getVerticalScrollBar().setValue(scrollFrame.getVerticalScrollBar().getMaximum()));
    }

}
