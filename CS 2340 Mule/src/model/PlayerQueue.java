package model;

import java.util.ArrayList;

public class PlayerQueue {
    private ArrayList<Player> players;
    private int currentIndex;
    private int round;
    private boolean newRound;

    public PlayerQueue(int numPlayers) {
        players = new ArrayList<Player>();

        for (int i = 0; i < numPlayers; i ++) {
            players.add(new Player());
        }

        currentIndex = 0;
        round = 0;
        newRound = false;
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
}
