import java.awt.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: craigrmccown
 * Date: 10/7/13
 * Time: 8:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameController {
    private int difficulty;
    private ArrayList<Player> players;
    private int currentPlayer;

    public GameController() {
        this.players = new ArrayList<Player>();
        this.currentPlayer = 0;
    }

    public static void triggerStartGame() {
    	startGame();
    }
    
    private void startTitleScreen() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    GUI_Title window = new GUI_Title();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    
    private static void startGame() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    GUIGameBoard guiGameBoard = new GUIGameBoard();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public void configurePlayers() {
        for (Player player : players) {

        }
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        GameController gc = new GameController();
        gc.startTitleScreen();
    }
}
