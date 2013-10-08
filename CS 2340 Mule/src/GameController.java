import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: craigrmccown
 * Date: 10/7/13
 * Time: 8:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameController {
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
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
}
