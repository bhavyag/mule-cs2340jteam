package model;

import java.util.ArrayList;

/**
 * Class PlayerQueue contains an arrayList of current players in the game 
 * and increments the current player and round based on the progression of the game.
 */
public class PlayerQueue {
    private ArrayList<Player> players;
    private int currentIndex;
    private int round;
    private int passes;
    private boolean newRound;
    
    /**
     * CONSTRUCTOR adds a specified number of players to the rotation
     * @param numPlayers the amount of players to rotate
     * @param startingMoney the amount of money each player should start with
     */
    public PlayerQueue(int numPlayers, int startingMoney) {
        players = new ArrayList<Player>();

        for (int i = 0; i < numPlayers; i ++) {
            players.add(new Player(startingMoney));
        }

        currentIndex = 0;
        round = 0;
        passes = 0;
        newRound = false;
    }

    /**
     * METHOD gives the player whose turn it is
     * @return the current player
     */
    public Player getCurrentPlayer() {
        return players.get(currentIndex);
    }

    /**
     * METHOD rotates to the next player in line
     */
    public void next() {
        if (currentIndex != players.size() - 1) {
            currentIndex ++;
            newRound = false;
        } else {
            currentIndex = 0;
            passes = 0;
            newRound = true;
            round ++;
        }
    }

    /**
     * METHOD rotates to the next player in line, but signifies and records a pass
     * @return true if all players passed in one round, false otherwise
     */
    public boolean pass() {
        int _passes;
        passes ++;
        _passes = passes;
        next();
        return _passes == players.size();
    }

    /**
     * METHOD gives the current round number
     * @return the current round number
     */
    public int getRound() {
        return round;
    }

    /**
     * METHOD tells whether the round has just begun
     * @return true if a new round has just begun, false otherwise
     */
    public boolean isNewRound() {
        return newRound;
    }

    /**
     * METHOD gives the total number of players
     * @return the total number of players
     */
    public int getNumPlayers() {
        return players.size();
    }

    /**
     * METHOD starts the rotation over
     */
    public void beginRotation() {
        round = 0;
        currentIndex = 0;
        passes = 0;
        newRound = true;
    }
}
