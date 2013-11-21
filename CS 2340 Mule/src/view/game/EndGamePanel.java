package view.game;

import javax.swing.*;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Color;

public class EndGamePanel extends JPanel
{
	protected JLabel NameP1;
	protected JLabel NameP2;
	protected JLabel NameP3;
	protected JLabel NameP4;
	
	protected JLabel lblScore;
	protected JLabel label_8;
	protected JLabel label_12;
	protected JLabel label_13;
	
	protected JLabel ScoreP1;
	protected JLabel ScoreP2;
	protected JLabel ScoreP3;
	protected JLabel ScoreP4;
	
	public EndGamePanel() 
	{
		setBounds(new Rectangle(0, 0, 832, 400));
		setLayout(null);
		
		NameP1 = new JLabel("");
		NameP1.setForeground(Color.WHITE);
		NameP1.setFont(new Font("Arial", Font.BOLD, 25));
		NameP1.setBounds(36, 141, 154, 51);
		add(NameP1);
		
		NameP2 = new JLabel("");
		NameP2.setForeground(Color.WHITE);
		NameP2.setFont(new Font("Arial", Font.BOLD, 25));
		NameP2.setBounds(237, 141, 154, 51);
		add(NameP2);
		
		NameP3 = new JLabel("");
		NameP3.setForeground(Color.WHITE);
		NameP3.setFont(new Font("Arial", Font.BOLD, 25));
		NameP3.setBounds(440, 141, 154, 51);
		add(NameP3);
		
		NameP4 = new JLabel("");
		NameP4.setForeground(Color.WHITE);
		NameP4.setFont(new Font("Arial", Font.BOLD, 25));
		NameP4.setBounds(644, 141, 154, 51);
		add(NameP4);
		
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
		
		ScoreP1 = new JLabel("");
		ScoreP1.setForeground(Color.WHITE);
		ScoreP1.setFont(new Font("Arial", Font.BOLD, 25));
		ScoreP1.setBounds(36, 265, 154, 40);
		add(ScoreP1);
		
		ScoreP2 = new JLabel("");
		ScoreP2.setForeground(Color.WHITE);
		ScoreP2.setFont(new Font("Arial", Font.BOLD, 25));
		ScoreP2.setBounds(237, 265, 154, 40);
		add(ScoreP2);
		
		ScoreP3 = new JLabel("");
		ScoreP3.setForeground(Color.WHITE);
		ScoreP3.setFont(new Font("Arial", Font.BOLD, 25));
		ScoreP3.setBounds(440, 265, 154, 40);
		add(ScoreP3);
		
		ScoreP4 = new JLabel("");
		ScoreP4.setForeground(Color.WHITE);
		ScoreP4.setFont(new Font("Arial", Font.BOLD, 25));
		ScoreP4.setBounds(644, 265, 154, 40);
		add(ScoreP4);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(EndGamePanel.class.getResource("/sprites/finalScoreScreen.png")));
		background.setBounds(0, 0, 832, 400);
		add(background);
	}
	
	public void getPlayerInfo(String[][] playerInfo)
	{
		NameP1.setText(playerInfo[0][0]);
		NameP2.setText(playerInfo[1][0]);
		NameP3.setText(playerInfo[2][0]);
		NameP4.setText(playerInfo[3][0]);
		
		ScoreP1.setText(playerInfo[0][1]);
		ScoreP2.setText(playerInfo[1][1]);
		ScoreP3.setText(playerInfo[2][1]);
		ScoreP4.setText(playerInfo[3][1]);
	}
}
