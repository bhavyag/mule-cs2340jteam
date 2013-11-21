package model;

import java.util.Random;

public class RandomEvent {
	private static String[] events = {
			"YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.",
			"A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE.",
			"THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $ 8*m.",
			"YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $2*m.",
			"FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $4*m.",
			"MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.",
			"YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. IT COST YOU $6*m TO CLEAN IT UP." };

	private static int returnM(int round) {
		if (round < 3) {
			return 25;
		}
		if (round < 8) {
			return 50;
		}
		if (round < 12) {
			return 75;
		}
		return 100;
	}

	public static String performRandom(PlayerQueue playerQ, int index) {
		int event = 0;
		Player p = playerQ.getCurrentPlayer();
		String result = "";

		Random rand = new Random();
		if (index == playerQ.getNumPlayers() - 1) {
			event = rand.nextInt(4);
		} else {
			event = rand.nextInt(7);
		}

		switch (event) {
		case 0:
			p.incrementFood(3);
			p.incrementEnergy(2);
			result = events[event];
			break;
		case 1:
			p.incrementSmithore(2);
			result = events[event];
			break;
		case 2:
			p.incrementMoney(8 * returnM(playerQ.getRound()));
			result = "THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $"
					+ (8 * returnM(playerQ.getRound()) + ".");
			break;
		case 3:
			p.incrementMoney(2 * returnM(playerQ.getRound()));
			result = "YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $"
					+ (2 * returnM(playerQ.getRound()) + ".");
			break;
		case 4:
			p.incrementMoney(-4 * returnM(playerQ.getRound()));
			result = "FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $"
					+ (4 * returnM(playerQ.getRound()) + ".");
			break;
		case 5:
			p.incrementFood(-p.getFood() / 2);
			result = events[event];
			break;
		case 6:
			p.incrementMoney(-6 * returnM(playerQ.getRound()));
			result = "YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. IT COST YOU $"
					+ (6 * returnM(playerQ.getRound()) + " TO CLEAN IT UP.");
			break;
		default:
			break;
		}

		return result;

	}
}
