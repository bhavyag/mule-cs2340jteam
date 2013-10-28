package view.game;

import javax.swing.*;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Color;

/**
 * CLASS StatusPanel. For the JPanel that displays the status of each player,
 * their name, money, and resources.
 * @author Chris
 *
 */
public class StatusPanel extends JPanel {

	JLabel p1StatusLabel, p1Name, p1Money, p1Energy, p1Smithore, p1Food, p1Crystite;
	JLabel p2StatusLabel, p2Name, p2Money, p2Energy, p2Smithore, p2Food, p2Crystite;
	JLabel p3StatusLabel, p3Name, p3Money, p3Energy, p3Smithore, p3Food, p3Crystite;
	JLabel p4StatusLabel, p4Name, p4Money, p4Energy, p4Smithore, p4Food, p4Crystite;

	/**
	 * CONSTRUCTOR for the StatusPanel, sets its initial size.
	 */
	protected StatusPanel(int numPlayers) {
		this.setBounds(new Rectangle(168, 400, 832, 163));

		initialize(numPlayers);

	}

	/**
	 * METHOD that updates the StatusPanel's JLabels for each player's information
	 */
	public void updateStatusPanel(String[][] info)
	{

		//player 1:
		p1StatusLabel.setIcon(new ImageIcon(StatusPanel.class.getResource("/sprites/statusBorder-" + info[0][1].substring(0,1).toUpperCase() + info[0][1].substring(1) + ".png")));
		p1Name.setText(info[0][0]);
		p1Money.setText("$" + info[0][3]);
		p1Energy.setText(info[0][4]);
		p1Smithore.setText(info[0][5]);
		p1Food.setText(info[0][6]);
		p1Crystite.setText(info[0][7]);

		//player 2:
		p2StatusLabel.setIcon(new ImageIcon(StatusPanel.class.getResource("/sprites/statusBorder-" + info[1][1].substring(0,1).toUpperCase() + info[1][1].substring(1) + ".png")));
		p2Name.setText(info[1][0]);
		p2Money.setText("$" + info[1][3]);
		p2Energy.setText(info[1][4]);
		p2Smithore.setText(info[1][5]);
		p2Food.setText(info[1][6]);
		p2Crystite.setText(info[1][7]);

		//player 3:
		if (info[2][0] != null) {
			p3StatusLabel.setIcon(new ImageIcon(StatusPanel.class.getResource("/sprites/statusBorder-" + info[2][1].substring(0,1).toUpperCase() + info[2][1].substring(1) + ".png")));
			p3Name.setText(info[2][0]);
			p3Money.setText("$" + info[2][3]);
			p3Energy.setText(info[2][4]);
			p3Smithore.setText(info[2][5]);
			p3Food.setText(info[2][6]);
			p3Crystite.setText(info[2][7]);
		}

		//player 4:
		if (info[3][0] != null) {
			p4StatusLabel.setIcon(new ImageIcon(StatusPanel.class.getResource("/sprites/statusBorder-" + info[3][1].substring(0,1).toUpperCase() + info[3][1].substring(1) + ".png")));
			p4Name.setText(info[3][0]);
			p4Money.setText("$" + info[3][3]);
			p4Energy.setText(info[3][4]);
			p4Smithore.setText(info[3][5]);
			p4Food.setText(info[3][6]);
			p4Crystite.setText(info[3][7]);
		}
	}

	/**
	 * METHOD that adds the StatusPanel's JLabels for each player's information
	 */
	private void initialize(int numPlayers) {
		setLayout(null);

		initializeP1Labels();
		initializeP2Labels();
		if (numPlayers > 2)
			initializeP3Labels();
		if (numPlayers > 3)
			initializeP4Labels();

		JLabel statusLabelBackground = new JLabel("");
		statusLabelBackground.setBounds(new Rectangle(0, 0, 195, 143));
		statusLabelBackground.setBounds(0, 0, 832, 163);
		statusLabelBackground.setIcon(new ImageIcon(StatusPanel.class.getResource("/sprites/Status-Panel.png")));
		add(statusLabelBackground);
	}

	/**
	 * METHOD that initializes all the JLabels for Player 1
	 */
	private void initializeP1Labels()
	{
		p1StatusLabel = new JLabel("");
		p1StatusLabel.setForeground(Color.WHITE);
		p1StatusLabel.setBounds(new Rectangle(11, 10, 195, 143));
		add(p1StatusLabel);

		p1Name = new JLabel("");
		p1Name.setForeground(Color.WHITE);
		add(p1Name);
		p1Name.setFont(new Font("Impact", Font.PLAIN, 21));
		p1Name.setBounds(21, 24, 82, 25);

		p1Money = new JLabel("");
		p1Money.setForeground(Color.WHITE);
		add(p1Money);
		p1Money.setFont(new Font("Impact", Font.PLAIN, 21));
		p1Money.setBounds(113, 24, 82, 25);

		p1Energy = new JLabel("");
		p1Energy.setForeground(Color.WHITE);
		p1Energy.setIcon(new ImageIcon(StatusPanel.class.getResource("/sprites/energy.png")));
		p1Energy.setFont(new Font("Impact", Font.PLAIN, 21));
		p1Energy.setBounds(14, 67, 72, 40);
		add(p1Energy);

		p1Smithore = new JLabel("");
		p1Smithore.setForeground(Color.WHITE);
		p1Smithore.setIcon(new ImageIcon(StatusPanel.class.getResource("/sprites/smithore.png")));
		p1Smithore.setFont(new Font("Impact", Font.PLAIN, 21));
		p1Smithore.setBounds(93, 67, 72, 40);
		add(p1Smithore);

		p1Food = new JLabel("");
		p1Food.setForeground(Color.WHITE);
		p1Food.setIcon(new ImageIcon(StatusPanel.class.getResource("/sprites/food.png")));
		p1Food.setFont(new Font("Impact", Font.PLAIN, 21));
		p1Food.setBounds(14, 110, 72, 40);
		add(p1Food);

		p1Crystite = new JLabel("");
		p1Crystite.setForeground(Color.WHITE);
		p1Crystite.setIcon(new ImageIcon(StatusPanel.class.getResource("/sprites/christite.png")));
		p1Crystite.setFont(new Font("Impact", Font.PLAIN, 21));
		p1Crystite.setBounds(93, 110, 72, 40);
		add(p1Crystite);         
	}

	/**
	 * METHOD that initializes all the JLabels for Player 2
	 */
	private void initializeP2Labels()
	{
		p2StatusLabel = new JLabel("");
		p2StatusLabel.setBounds(new Rectangle(11, 10, 195, 143));
		p2StatusLabel.setBounds(216, 10, 195, 143);
		add(p2StatusLabel);

		p2Name = new JLabel("");
		p2Name.setForeground(Color.WHITE);
		p2Name.setFont(new Font("Impact", Font.PLAIN, 21));
		p2Name.setBounds(226, 24, 82, 25);
		add(p2Name);

		p2Money = new JLabel("");
		p2Money.setForeground(Color.WHITE);
		p2Money.setFont(new Font("Impact", Font.PLAIN, 21));
		p2Money.setBounds(318, 24, 82, 25);
		add(p2Money);

		p2Energy = new JLabel("");
		p2Energy.setIcon(new ImageIcon(StatusPanel.class.getResource("/sprites/energy.png")));
		p2Energy.setForeground(Color.WHITE);
		p2Energy.setFont(new Font("Impact", Font.PLAIN, 21));
		p2Energy.setBounds(218, 67, 72, 40);
		add(p2Energy);

		p2Smithore = new JLabel("");
		p2Smithore.setIcon(new ImageIcon(StatusPanel.class.getResource("/sprites/smithore.png")));
		p2Smithore.setForeground(Color.WHITE);
		p2Smithore.setFont(new Font("Impact", Font.PLAIN, 21));
		p2Smithore.setBounds(300, 67, 72, 40);
		add(p2Smithore);

		p2Food = new JLabel("");
		p2Food.setIcon(new ImageIcon(StatusPanel.class.getResource("/sprites/food.png")));
		p2Food.setForeground(Color.WHITE);
		p2Food.setFont(new Font("Impact", Font.PLAIN, 21));
		p2Food.setBounds(218, 110, 72, 40);
		add(p2Food);

		p2Crystite = new JLabel("");
		p2Crystite.setIcon(new ImageIcon(StatusPanel.class.getResource("/sprites/christite.png")));
		p2Crystite.setForeground(Color.WHITE);
		p2Crystite.setFont(new Font("Impact", Font.PLAIN, 21));
		p2Crystite.setBounds(300, 110, 72, 40);
		add(p2Crystite);
	}

	/**
	 * METHOD that initializes all the JLabels for Player 3
	 */
	private void initializeP3Labels()
	{
		p3StatusLabel = new JLabel("");
		p3StatusLabel.setBounds(new Rectangle(11, 10, 195, 143));
		p3StatusLabel.setBounds(421, 10, 195, 143);
		add(p3StatusLabel);

		p3Name = new JLabel("");
		p3Name.setForeground(Color.WHITE);
		p3Name.setFont(new Font("Impact", Font.PLAIN, 21));
		p3Name.setBounds(430, 24, 82, 25);
		add(p3Name);

		p3Money = new JLabel("");
		p3Money.setForeground(Color.WHITE);
		p3Money.setFont(new Font("Impact", Font.PLAIN, 21));
		p3Money.setBounds(522, 24, 82, 25);
		add(p3Money);

		p3Energy = new JLabel("");
		p3Energy.setIcon(new ImageIcon(StatusPanel.class.getResource("/sprites/energy.png")));
		p3Energy.setForeground(Color.WHITE);
		p3Energy.setFont(new Font("Impact", Font.PLAIN, 21));
		p3Energy.setBounds(424, 67, 72, 40);
		add(p3Energy);

		p3Smithore = new JLabel("");
		p3Smithore.setIcon(new ImageIcon(StatusPanel.class.getResource("/sprites/smithore.png")));
		p3Smithore.setForeground(Color.WHITE);
		p3Smithore.setFont(new Font("Impact", Font.PLAIN, 21));
		p3Smithore.setBounds(505, 67, 72, 40);
		add(p3Smithore);

		p3Food = new JLabel("");
		p3Food.setIcon(new ImageIcon(StatusPanel.class.getResource("/sprites/food.png")));
		p3Food.setForeground(Color.WHITE);
		p3Food.setFont(new Font("Impact", Font.PLAIN, 21));
		p3Food.setBounds(424, 110, 72, 40);
		add(p3Food);

		p3Crystite = new JLabel("");
		p3Crystite.setIcon(new ImageIcon(StatusPanel.class.getResource("/sprites/christite.png")));
		p3Crystite.setForeground(Color.WHITE);
		p3Crystite.setFont(new Font("Impact", Font.PLAIN, 21));
		p3Crystite.setBounds(505, 110, 72, 40);
		add(p3Crystite);
	}

	/**
	 * METHOD that initializes all the JLabels for Player 4
	 */
	private void initializeP4Labels()
	{
		p4StatusLabel = new JLabel("");
		p4StatusLabel.setBounds(new Rectangle(11, 10, 195, 143));
		p4StatusLabel.setBounds(626, 10, 195, 143);
		add(p4StatusLabel);

		p4Name = new JLabel("");
		p4Name.setForeground(Color.WHITE);
		p4Name.setFont(new Font("Impact", Font.PLAIN, 21));
		p4Name.setBounds(635, 24, 82, 25);
		add(p4Name);

		p4Money = new JLabel("");
		p4Money.setForeground(Color.WHITE);
		p4Money.setFont(new Font("Impact", Font.PLAIN, 21));
		p4Money.setBounds(727, 24, 82, 25);
		add(p4Money);

		p4Energy = new JLabel("");
		p4Energy.setIcon(new ImageIcon(StatusPanel.class.getResource("/sprites/energy.png")));
		p4Energy.setForeground(Color.WHITE);
		p4Energy.setFont(new Font("Impact", Font.PLAIN, 21));
		p4Energy.setBounds(629, 67, 72, 40);
		add(p4Energy);

		p4Smithore = new JLabel("");
		p4Smithore.setIcon(new ImageIcon(StatusPanel.class.getResource("/sprites/smithore.png")));
		p4Smithore.setForeground(Color.WHITE);
		p4Smithore.setFont(new Font("Impact", Font.PLAIN, 21));
		p4Smithore.setBounds(710, 67, 72, 40);
		add(p4Smithore);

		p4Food = new JLabel("");
		p4Food.setIcon(new ImageIcon(StatusPanel.class.getResource("/sprites/food.png")));
		p4Food.setForeground(Color.WHITE);
		p4Food.setFont(new Font("Impact", Font.PLAIN, 21));
		p4Food.setBounds(629, 110, 72, 40);
		add(p4Food);

		p4Crystite = new JLabel("");
		p4Crystite.setIcon(new ImageIcon(StatusPanel.class.getResource("/sprites/christite.png")));
		p4Crystite.setForeground(Color.WHITE);
		p4Crystite.setFont(new Font("Impact", Font.PLAIN, 21));
		p4Crystite.setBounds(710, 110, 72, 40);
		add(p4Crystite);
	}

}
