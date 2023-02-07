package UI;

import javax.swing.plaf.basic.BasicButtonUI;

import CustomElements.CustomJButtonUI;
import CustomElements.RoundJTextField;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
public class StartWindowUI {
    public static JFrame startWindow;
    public static JTextField nicknameField;
    public static JButton loginButton;
    public static JLabel errorLabel;
    public static void createWindow() {
        Font customRegularFont = createNormalFont();

        startWindow = new JFrame();
        startWindow.setIconImage(new ImageIcon("Images/Chatty.png").getImage());
        startWindow.setSize(400, 500);
        startWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackgroundImage(startWindow, "Images/Chatty.png");
        startWindow.setLayout(null);
        startWindow.setLocationRelativeTo(null);
        startWindow.setResizable(false);

        JLabel label = new JLabel("Please, put your nickname to join the chat");
        assert customRegularFont != null;
        label.setFont(customRegularFont.deriveFont(Font.BOLD));
        label.setForeground(Color.white);
        label.setBounds(45, 240, 350, 20);


        errorLabel = new JLabel("You have to put a name!");
        errorLabel.setFont(customRegularFont.deriveFont(Font.BOLD));
        errorLabel.setForeground(Color.decode("#CD5888"));
        errorLabel.setBounds(115, 370, 350, 20);
        errorLabel.setVisible(false);

        nicknameField = new RoundJTextField(0);
        nicknameField.setFont(customRegularFont);
        nicknameField.setBounds(105, 280, 200, 30);

        loginButton = new JButton("Join");
        loginButton.setOpaque(false);
        loginButton.setFont(customRegularFont);
        loginButton.setBounds(165, 330, 80, 25);
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.setUI(new CustomJButtonUI());

        startWindow.add(label);
        startWindow.add(errorLabel);
        startWindow.add(nicknameField);
        startWindow.add(loginButton);
        startWindow.setVisible(true);
    }
    public static Font createNormalFont(){
        try{
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/OpenSans.ttf")).deriveFont(15f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            return customFont;
        } catch (IOException | FontFormatException e) {
            System.out.println("Error with the font");
        }
        return null;
    }
    public static Font createLabelFont(){
        try{
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/OpenSans.ttf")).deriveFont(10f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            return customFont;
        } catch (IOException | FontFormatException e) {
            System.out.println("Error with the font");
        }
        return null;
    }
    public static Font createTitleFont(){
        try{
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/OpenSans.ttf")).deriveFont(25f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            return customFont;
        } catch (IOException | FontFormatException e) {
            System.out.println("Error with the font");
        }
        return null;
    }
    public static void setBackgroundImage(JFrame frame, String imagePath){
        try{
            final Image backgroundImage = javax.imageio.ImageIO.read(new File(imagePath));
            frame.setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            });
        } catch (IOException e) {
            System.out.println("Image not found");
        }
    }
}

