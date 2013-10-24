package model;

import java.util.ArrayList;

/**
 * Class PlayerQueue contains an arrayList of current players in the game 
 * and increments the current player and round based on the progression of the game.
 * 
 *
 */
public class PlayerQueue {
    private ArrayList<Player> players;
    private int currentIndex;
    private int round;
    private boolean newRound;
    
    public PlayerQueue(int numPlayers, int startingMoney) {
        players = new ArrayList<Player>();

        for (int i = 0; i < numPlayers; i ++) {
            players.add(new Player(startingMoney));
        }

        currentIndex = 0;
        round = 0;
        newRound = false;
    }

    public ArrayList<Player> getPlayers() {
    	return players;
    }
    
    public Player getCurrentPlayer() {
        return players.get(currentIndex);
    }

    public void next() {
        if (currentIndex != players.size() - 1) {
            currentIndex ++;
            newRound = false;
        } else {
            currentIndex = 0;
            newRound = true;
            round ++;
        }
    }

    public int getRound() {
        return round;
    }

    public boolean isNewRound() {
        return newRound;
    }

    public int getNumPlayers() {
        return players.size();
    }

    public void resetRound() {
        round = 0;
    }

    public void beginRotation() {
        currentIndex = 0;
        newRound = true;
        round ++;
    }
}
