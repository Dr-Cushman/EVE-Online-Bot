import javax.swing.*;
import java.awt.*;

public class SettingsWindow {
    private JFrame settingsFrame;
    private JButton selectRegionButton;
    private BotController botController;

    public SettingsWindow(BotController botController) {
        this.botController = botController;

        // Create settings frame
        settingsFrame = new JFrame("Settings");
        settingsFrame.setSize(400, 200);
        settingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create select region button
        selectRegionButton = new JButton("Select Observation Region");
        selectRegionButton.addActionListener(e -> selectRegion());

        // Layout components
        settingsFrame.setLayout(new BorderLayout());
        settingsFrame.add(selectRegionButton, BorderLayout.NORTH);

        // Show settings frame
        settingsFrame.setVisible(true);
    }

    // Show settings window
    public void show() {
        settingsFrame.setVisible(true);
    }

    // Select observation region
    private void selectRegion() {
        // Open overlay to start selecting region
        RegionSelector regionSelector = new RegionSelector(botController);
        regionSelector.start();
    }
}
