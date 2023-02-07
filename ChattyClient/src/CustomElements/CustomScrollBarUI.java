package CustomElements;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class CustomScrollBarUI extends BasicScrollBarUI {
    private final Dimension d = new Dimension();

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return new JButton() {

            private static final long serialVersionUID = -3592643796245558676L;

            @Override
            public Dimension getPreferredSize() {
                return d;
            }
        };
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return new JButton() {

            private static final long serialVersionUID = 1L;

            @Override
            public Dimension getPreferredSize() {
                return d;
            }
        };
    }
    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color color;
        JScrollBar sb = (JScrollBar) c;
        if (!sb.isEnabled() || r.width > r.height) {
            return;
        } else if (isDragging) {
            color = Color.decode("#504c54"); // change color
        } else {
            color = Color.decode("#504c54"); // change color
        }
        g2.setPaint(color);
        g2.fillRoundRect(r.x+1 , r.y, r.width - 12, r.height -5, 8, 8);
        g2.setPaint(Color.decode("#504c54"));
        g2.drawRoundRect(r.x+1, r.y, r.width - 12, r.height -5, 8, 8);
        g2.dispose();
    }

    @Override
    protected void setThumbBounds(int x, int y, int width, int height) {
        super.setThumbBounds(x, y, width, height);
        scrollbar.repaint();
    }
}
