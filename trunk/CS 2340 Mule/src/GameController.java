import model.*;
import util.LimitTimer;
import view.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class GameController {
    private TitleFrame titleView;
    private GameFrame gameView;
    private BoardPanel boardPanel;
    private TilePanel tilePanel;
    private StatusPanel statusPanel;
    private MessagePanel messagePanel;
    
    private int difficulty;
    private PlayerQueue players;
    private Board board;
    private LimitTimer timer;


    public GameController() {

    }

    private void startTitleSequence() {
        titleView = new TitleFrame();
        titleScreen();
    }


    private void titleScreen() {
        titleView.showTitlePanel();

        titleView.getTitlePanel().onClickStart(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        configureGame();
                    }
                }
        );
    }

    private void configureGame() {
        titleView.showGameConfigPanel();

        final GameConfigPanel gameConfigPanel = titleView.getGameConfigPanel();
        gameConfigPanel.onClickNext(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        players = new PlayerQueue(gameConfigPanel.getNumPlayers());
                        difficulty = gameConfigPanel.getDifficulty();
                        board = BoardFactory.constructBoard(gameConfigPanel.getMap());

                        configurePlayers();
                    }
                }
        );
    }

    private void configurePlayers() {
        titleView.showPlayerConfigPanel();
        titleView.updatePlayerConfigPanel(players.getCurrentPlayer().getPlayerNum());

        final PlayerConfigPanel playerConfigPanel = titleView.getPlayerConfigPanel();
        playerConfigPanel.onClickNext(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        players.getCurrentPlayer().setName(playerConfigPanel.getName());
                        players.getCurrentPlayer().setColor(playerConfigPanel.getColor());
                        players.getCurrentPlayer().setRace(playerConfigPanel.getRace());

                        players.next();

                        if (players.isNewRound()) {
                            startGame();
                        } else {
                            titleView.updatePlayerConfigPanel(players.getCurrentPlayer().getPlayerNum());
                        }
                    }
                }
        );
    }

    private void startGame() {
        titleView.dispose();
        gameView = new GameFrame();
        
        statusPanel = gameView.getStatusPanel();
        messagePanel = gameView.getMessagePanel();
        boardPanel = gameView.getBoardPanel();
        tilePanel = boardPanel.getTilePanel();

        players.resetRound();
        players.beginRotation();
        this.makeMap();

        timer = new LimitTimer(10, 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("tick " + timer.getCount() + ": " + players.getCurrentPlayer());

                if (timer.isOutOfTime()) {
                    System.out.println("out of time");
                    players.next();
                    timer.reset();
                }
            }
        });
        timer.start();
    }
    
    private void makeMap()
    {
    	Tile[][] tiles = board.getMap();
    	
    	for(int i = 0; i<5; i++)
    	{
    		for(int j = 0; j<9; j++)
    		{
    			Tile tile1 = tiles[i][j];
    			
    			URL url = tile1.getType().getImgPath();
    			ImageIcon icon = new ImageIcon(url);
    			this.tilePanel.instantiateTileImage(icon, i, j);
    			
    			
    		}
    	}
    	
    	for(int i = 0; i<5; i++)
    	{
    		for(int j = 0; j<9; j++)
    		{
    			Tile tile2 = tiles[i][j];
    			
    			URL url2 = tile2.getTileColor().getBorderPath();
    			ImageIcon borderIcon = new ImageIcon(url2);
    			this.tilePanel.instantiateBorderImage(borderIcon,i,j);	
    			
    		}
    	}
    }
    
    private void update()
    {
    	this.statusPanel.updateStatusPanel(players.getPlayers());
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        GameController gc = new GameController();
        gc.startTitleSequence();
    }
}
