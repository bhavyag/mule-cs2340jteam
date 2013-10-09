import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: craigrmccown
 * Date: 10/7/13
 * Time: 8:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameController {
    private GUI_Title view;
    private int difficulty;
    private ArrayList<Player> players;
    private int currentPlayer;

    public GameController(GUI_Title view) {
        this.view = view;
        this.players = new ArrayList<Player>();
        this.currentPlayer = 0;
    }
    
    private void startTitleScreen() {
        view.showTitlePanel();
        view.getTitlePanel().listenForStartBtn(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("worked");
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
        GameController gc = new GameController(new GUI_Title());
        gc.startTitleScreen();
    }
}
