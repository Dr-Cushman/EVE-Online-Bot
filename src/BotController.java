public class BotController {
    private boolean running;
    private ScreenshotManager screenshotManager;


    public BotController() {
        running = false;
        screenshotManager = new ScreenshotManager();
    }

    public void startBot() {
        running = true;
        System.out.println("Bot started");
        // Start screenshot processing
        screenshotManager.startScreenshotProcess();
    }

    public void stopBot() {
        running = false;
        System.out.println("Bot stopped");
        // Stop screenshot processing
        screenshotManager.stopScreenshotProcess();
    }

    public boolean isRunning() {
        return running;
    }
}
