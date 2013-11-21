import java.io.File;

public class Driver
{
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        File saveFile = new File("save_file.json");
        GameController gc = new GameController();

        if (saveFile.exists()) {
            gc.load();
            gc.startGame();
        } else {
            gc.startTitleSequence();
        }
    }
}
