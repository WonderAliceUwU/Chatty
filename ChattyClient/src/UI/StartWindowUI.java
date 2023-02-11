package UI;

import CustomElements.CustomJButtonUI;
import CustomElements.RoundJTextFieldHint;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
public class StartWindowUI {
    public static JFrame startWindow;
    public static JTextField nicknameField;
    public static JButton loginButton;
    public static JLabel errorLabel;

    /**Creates main Window for the user to log in. It is used by the class LoginWindow. The listener of loginButton
     * is called externally*/
    public static void createWindow() {

        startWindow = new JFrame();
        startWindow.setIconImage(new ImageIcon("Images/Chatty.png").getImage());
        startWindow.setSize(400, 500);
        setBackgroundImage(startWindow, "Images/Chatty.png");
        startWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startWindow.setLayout(null);
        startWindow.setLocationRelativeTo(null);
        startWindow.setResizable(false);

        //This is the regular font with the regular size the app will use
        Font customRegularFont = createCustomFont(15f);

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

        nicknameField = new RoundJTextFieldHint(0, "");
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

    /**Creates a font of the OpenSans family with a given size. Uses the fonts located in the folder Fonts, draws
     * it with the Graphics Environment and returns it for later use
     * @param size A float given to adjust the font to the desired size.*/
    public static Font createCustomFont(Float size){
        try{
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/OpenSans.ttf")).deriveFont(size);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(customFont);
            return customFont;
        } catch (IOException | FontFormatException e) {
            System.out.println("Error with the font");
            return null;
        }
    }

    /**Draws an image as a background for a JFrame. Creates an Image from a given path, and draws it to a desired width
     * and height.
     * @param frame JFrame to draw an image
     * @param imagePath The path to the desired image as a String
     */
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

