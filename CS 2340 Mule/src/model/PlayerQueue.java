package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * CLASS PlayerQueue contains an arrayList of current players in the game 
 * and increments the current player and round based on the progression of the game.
 */
public class PlayerQueue {
    private ArrayList<Player> players;
    private int currentIndex;
    private int round;
    private int passes;
    private boolean newRound;
    private Random rand; //for debugging
    
    /**
     * CONSTRUCTOR adds a specified number of players to the rotation
     * @param numPlayers the amount of players to rotate
     * @param startingMoney the amount of money each player should start with
     */
    public PlayerQueue(int numPlayers, int startingMoney) {
    	rand = new Random();//for debugging
    	players = new ArrayList<Player>();

        for (int i = 0; i < numPlayers; i ++) {
            players.add(new Player(startingMoney + rand.nextInt(20))); //random is for debugging scoreSort()
        }

        currentIndex = 0;
        round = 0;
        passes = 0;
        newRound = false;
    }
    
    public void resetPlayers(){
    	for(Player player : players){
    		player.resetPlayerPos();
    	}
    }

    /**
     * METHOD gives the player whose turn it is
     * @return the current player
     */
    public Player getCurrentPlayer() {
        return players.get(currentIndex);
    }
    
    /**
     * METHOD gives the current index of the player
     * @return the current index
     */
    public int getCurrentIndex() {
        return currentIndex;
    }
    
    /**
     * METHOD gives the player at the specified index
     * @return player specified
     */
    public Player get(int i) {
    	return players.get(i);
    }

    /**
     * METHOD returns the arraylist of players
     * @return the arraylist of players
     */
    public ArrayList<Player> getPlayers() {
        return players;
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
            scoreSort();
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
    
    /**
     * METHOD sorts players based on score
     */
    public void scoreSort() {
    	Player temp;
    	for(int k=players.size();k>1;k--){
	    	for(int i=0;i<k-1;i++){
	    		if(players.get(i).getScore()>players.get(i+1).getScore()) {
	    			temp = players.get(i);
	    			players.set(i, players.get(i+1));
	    			players.set(i+1, temp);
	    		}
	    	}
    	}
    	/*DEBUG
    	 */
    	for(int j=0;j<players.size();j++){
    		System.out.println("Player" + players.get(j).getPlayerNum() + " with score: " + players.get(j).getScore());
    	}
    	
    }
}
