package view.game;

import javax.swing.*;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Color;

public class EndGamePanel extends JPanel {
	protected JLabel nameP1;
	protected JLabel nameP2;
	protected JLabel nameP3;
	protected JLabel nameP4;

	protected JLabel lblScore;
	protected JLabel label_8;
	protected JLabel label_12;
	protected JLabel label_13;

	protected JLabel scoreP1;
	protected JLabel scoreP2;
	protected JLabel scoreP3;
	protected JLabel scoreP4;

	public EndGamePanel() {
		setBounds(new Rectangle(0, 0, 832, 400));
		setLayout(null);

		nameP1 = new JLabel("");
		nameP1.setForeground(Color.WHITE);
		nameP1.setFont(new Font("Arial", Font.BOLD, 25));
		nameP1.setBounds(36, 141, 154, 51);
		add(nameP1);

		nameP2 = new JLabel("");
		nameP2.setForeground(Color.WHITE);
		nameP2.setFont(new Font("Arial", Font.BOLD, 25));
		nameP2.setBounds(237, 141, 154, 51);
		add(nameP2);

		nameP3 = new JLabel("");
		nameP3.setForeground(Color.WHITE);
		nameP3.setFont(new Font("Arial", Font.BOLD, 25));
		nameP3.setBounds(440, 141, 154, 51);
		add(nameP3);

		nameP4 = new JLabel("");
		nameP4.setForeground(Color.WHITE);
		nameP4.setFont(new Font("Arial", Font.BOLD, 25));
		nameP4.setBounds(644, 141, 154, 51);
		add(nameP4);

		lblScore = new JLabel("SCORE:");
		lblScore.setForeground(Color.WHITE);
		lblScore.setFont(new Font("Arial", Font.BOLD, 25));
		lblScore.setBounds(36, 203, 154, 51);
		add(lblScore);

		label_8 = new JLabel("SCORE:");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Arial", Font.BOLD, 25));
		label_8.setBounds(237, 203, 154, 51);
		add(label_8);

		label_12 = new JLabel("SCORE:");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Arial", Font.BOLD, 25));
		label_12.setBounds(641, 203, 154, 51);
		add(label_12);

		label_13 = new JLabel("SCORE:");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Arial", Font.BOLD, 25));
		label_13.setBounds(440, 203, 154, 51);
		add(label_13);

		scoreP1 = new JLabel("");
		scoreP1.setForeground(Color.WHITE);
		scoreP1.setFont(new Font("Arial", Font.BOLD, 25));
		scoreP1.setBounds(36, 265, 154, 40);
		add(scoreP1);

		scoreP2 = new JLabel("");
		scoreP2.setForeground(Color.WHITE);
		scoreP2.setFont(new Font("Arial", Font.BOLD, 25));
		scoreP2.setBounds(237, 265, 154, 40);
		add(scoreP2);

		scoreP3 = new JLabel("");
		scoreP3.setForeground(Color.WHITE);
		scoreP3.setFont(new Font("Arial", Font.BOLD, 25));
		scoreP3.setBounds(440, 265, 154, 40);
		add(scoreP3);

		scoreP4 = new JLabel("");
		scoreP4.setForeground(Color.WHITE);
		scoreP4.setFont(new Font("Arial", Font.BOLD, 25));
		scoreP4.setBounds(644, 265, 154, 40);
		add(scoreP4);

		final JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(EndGamePanel.class
				.getResource("/sprites/finalScoreScreen.png")));
		background.setBounds(0, 0, 832, 400);
		add(background);
	}

	public void getPlayerInfo(String[][] playerInfo) {
		nameP1.setText(playerInfo[0][0]);
		nameP2.setText(playerInfo[1][0]);
		nameP3.setText(playerInfo[2][0]);
		nameP4.setText(playerInfo[3][0]);

		scoreP1.setText(playerInfo[0][1]);
		scoreP2.setText(playerInfo[1][1]);
		scoreP3.setText(playerInfo[2][1]);
		scoreP4.setText(playerInfo[3][1]);
	}
}
