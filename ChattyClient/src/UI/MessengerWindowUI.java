package UI;

import CustomElements.RoundJTextField;

import javax.swing.*;
import java.awt.*;

public class MessengerWindowUI {
    public static JFrame messengerWindowFrame;
    public static JLabel welcomeLabel;
    public static JTextField sendMessageField;
    public static JButton sendMessageButton;
    public static JPanel chatPanel;
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

        welcomeLabel = new JLabel("You're chatting as", getIcon("Images/UserIcon.png"), SwingConstants.CENTER);
        assert customTitleFont != null;
        welcomeLabel.setFont(customTitleFont.deriveFont(Font.BOLD));
        welcomeLabel.setForeground(Color.white);
        welcomeLabel.setBounds(JLabel.CENTER, 20, 600, 50);

        sendMessageField = new RoundJTextField(0);
        sendMessageField.setFont(customRegularFont);
        sendMessageField.setBounds(20, 615, 520, 40);

        sendMessageButton = new JButton(getSmallerIcon("Images/SendMessageIcon.png"));
        sendMessageButton.setBounds(550, 620, 30, 30);
        sendMessageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        chatPanel = new JPanel();
        chatPanel.setPreferredSize(new Dimension( 480,470));
        chatPanel.setLayout(null);
        chatPanel.setAutoscrolls(true);
        chatPanel.setBackground(Color.decode("#20262E"));


        JScrollPane scrollFrame = new JScrollPane(chatPanel);
        scrollFrame.setBounds(50, 100, 500, 480);

        String message = " Hey how you doing";

        JTextArea text = new JTextArea(message ,1 , 1);
        text.setLocation(15, 50);
        text.setEditable(false);
        text.setLineWrap( true );
        text.setWrapStyleWord( true );
        text.setBackground(Color.decode("#E9E8E8"));
        text.setFont(customRegularFont);
        text.setForeground(Color.black);

        chatPanel.add(text);

        messengerWindowFrame.add(scrollFrame);
        messengerWindowFrame.add(welcomeLabel);
        messengerWindowFrame.add(sendMessageButton);
        messengerWindowFrame.add(sendMessageField);
        messengerWindowFrame.setVisible(true);
    }
    private static ImageIcon getIcon(String iconPath) {
        return new ImageIcon(iconPath) {
            @Override
            public int getIconWidth() {
                return 50;
            }

            @Override
            public int getIconHeight() {
                return 50;
            }
            @Override
            public synchronized void paintIcon(Component c, Graphics g,
                                               int x, int y) {
                g.drawImage(getImage(), x, y, 50, 50, null);
            }
        };
    }
    private static ImageIcon getSmallerIcon(String iconPath) {
        return new ImageIcon(iconPath) {
            @Override
            public int getIconWidth() {
                return 30;
            }

            @Override
            public int getIconHeight() {
                return 30;
            }
            @Override
            public synchronized void paintIcon(Component c, Graphics g,
                                               int x, int y) {
                g.drawImage(getImage(), x, y, 30, 30, null);
            }
        };
    }
}
