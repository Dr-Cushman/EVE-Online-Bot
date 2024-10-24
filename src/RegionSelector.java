/*
    * RegionSelector.java
    * This class lets you draw a red rectangle when the user clicks and drags the mouse to select a region on the screen.
    * This new region can be used to take a screenshot of that specific region.
    *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class RegionSelector extends JFrame {

    private BotController botController;
    private Rectangle region;
    private JLabel regionLabel;
    private Point start;
    private Point end;

    public RegionSelector(BotController botController) {
        this.botController = botController;
        region = new Rectangle();
        regionLabel = new JLabel("Select a region by clicking and dragging the mouse");
        start = new Point();
        end = new Point();

        // Set up the frame
        setTitle("Select Region");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set the frame to full screen
        setAlwaysOnTop(true);
        setOpacity(0.5f); // Set the frame to be semi-transparent

    }

    public Rectangle getSelectedRegion() {
        return region;
    }

    public void start() {
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR)); // Set the cursor to crosshair

    }

}