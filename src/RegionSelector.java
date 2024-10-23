import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;

public class RegionSelector extends JFrame {
    private Point startPoint;
    private Point endPoint;
    private BotController botController;

    public RegionSelector(BotController botController) {
        System.out.println("Region Selector Window Created");
        this.botController = botController;

        // Set frame to fullscreen and transparent
        setUndecorated(true);
        setOpacity(0.5f); // Semi-transparent window
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBackground(new Color(0, 0, 0, 0)); // Transparent background
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Add mouse listener for dragging and selecting the region
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                endPoint = e.getPoint();
                // Rectangle drawn; handle screenshot here
                Rectangle selectedRegion = getSelectedRectangle();
                System.out.println("Selected region: " + selectedRegion);
                botController.takeScreenshot(selectedRegion);
                dispose(); // Close the region selector
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                endPoint = e.getPoint();
                repaint(); // Redraw the rectangle as the user drags
            }
        });

        setVisible(true);
    }

    // Get the rectangle selected by the user
    private Rectangle getSelectedRectangle() {
        int x = Math.min(startPoint.x, endPoint.x);
        int y = Math.min(startPoint.y, endPoint.y);
        int width = Math.abs(startPoint.x - endPoint.x);
        int height = Math.abs(startPoint.y - endPoint.y);
        return new Rectangle(x, y, width, height);
    }

    // Paint the rectangle as the user drags the mouse
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (startPoint != null && endPoint != null) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.RED);
            g2d.setStroke(new BasicStroke(2)); // Thickness of the rectangle's border
            Rectangle rect = getSelectedRectangle();
            g2d.drawRect(rect.x, rect.y, rect.width, rect.height);
        }
    }

    // Start the region selector (optional method, just for organization)
    public void start() {
        // This method can be called to initialize the region selection
        setVisible(true);
    }

    // ESC key to close the region selector window
    @Override
    protected void processKeyEvent(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            dispose(); // Close the region selector
        }
    }

}
