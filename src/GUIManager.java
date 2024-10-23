import javax.swing.*;
import java.awt.*;

public class GUIManager {
    private JFrame frame;
    private JButton startButton;
    private JButton stopButton;
    private JButton settingsButton;
    private BotController botController;
    private SettingsWindow settingsWindow;

    public GUIManager(BotController botController) {
        this.botController = botController;

        // Create GUI components
        frame = new JFrame("EVE Online Bot");
        frame.setSize(600, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        settingsButton = new JButton("Settings");
        stopButton.setEnabled(false); // Disable stop button if bot is not running

        startButton.addActionListener(e -> startBot());
        stopButton.addActionListener(e -> stopBot());

        // TODO: Add action listener for settings button
        settingsButton.addActionListener(e -> openSettings());

        // Add components to frame
        frame.setLayout(new BorderLayout());
        frame.add(startButton, BorderLayout.SOUTH);
        frame.add(stopButton, BorderLayout.NORTH);
        frame.add(settingsButton, BorderLayout.CENTER);

        // Initialize settings window
        settingsWindow = new SettingsWindow(botController);
    }

    public void show() {
        frame.setVisible(true);
    }

    private void startBot() {
        botController.startBot();
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
    }

    private void stopBot() {
        botController.stopBot();
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
    }

    private void openSettings() {
        // Show settings window
        settingsWindow.show();
    }
}
