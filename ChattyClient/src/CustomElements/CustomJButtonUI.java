package CustomElements;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class CustomJButtonUI extends BasicButtonUI {
    public void update(Graphics g, JComponent c) {
        Color fillColor = c.getBackground();
        g.setColor(fillColor);
        g.fillRoundRect(0, 0, c.getWidth(),c.getHeight(), 20, 20);
        paint(g, c);
    }
}
