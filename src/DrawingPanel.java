import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingPanel extends JPanel {
    private Point startPoint = null;
    private Point endPoint = null;

    public DrawingPanel() {
        // Add mouse listener to handle drawing
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // When mouse is pressed, set the start point
                startPoint = e.getPoint();
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // When mouse is released, set end point
                endPoint = e.getPoint();
                repaint();
                System.out.println("Region selected: " + getRectangle());
            }
        });

        // Mouse motion listener to update end point while dragging
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                endPoint = e.getPoint();
                repaint();
            }
        });
    }

    // Get the rectangle defined by start and end points
    public Rectangle getRectangle() {
        if (startPoint == null && endPoint == null) {
            return null;
        }
        return new Rectangle(
                Math.min(startPoint.x, endPoint.x), // x
                Math.min(startPoint.y, endPoint.y), // y
                Math.abs(startPoint.x - endPoint.x), // width
                Math.abs(startPoint.y - endPoint.y) // height
        );
    }

    // Paint the rectangle on the panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (startPoint != null && endPoint != null) {
            g.setColor(Color.RED);
            g.drawRect(
                    Math.min(startPoint.x, endPoint.x), // x
                    Math.min(startPoint.y, endPoint.y), // y
                    Math.abs(startPoint.x - endPoint.x), // width
                    Math.abs(startPoint.y - endPoint.y) // height
            );
        }
    }
}
