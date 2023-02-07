package CustomElements;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundJTextFieldHint extends JTextField {
    private Shape shape;
    private String hint;

    public RoundJTextFieldHint(int size, String hint) {
        super(size);
        this.hint = hint;
        setOpaque(false);
    }
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
    }
    public void paint(Graphics g) {
        super.paint(g);
        if (getText().length() == 0) {
            ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            FontMetrics fm = g.getFontMetrics();
            g.setColor(new Color(Color.gray.getRGB(), true));
            g.drawString(hint, getInsets().left, getHeight() / 2 + fm.getAscent() / 2 - 2);
        }
    }
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        }
        return shape.contains(x, y);
    }
}
