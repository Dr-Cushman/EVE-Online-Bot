
public class EveBot {

    public EveBot() {
        // Initialize the bot controller and GUI
        BotController botController = new BotController();
        GUIManager guiManager = new GUIManager(botController);

        // Display the GUI
        guiManager.show();
    }

    public static void main(String[] args) {
        new EveBot();
    }
}