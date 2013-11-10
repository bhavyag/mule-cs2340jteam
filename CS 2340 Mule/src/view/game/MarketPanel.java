package view.game;

import javax.swing.*;

import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Font;
import java.awt.Color;

/**
 * For the panel that is shown when the player enters the market.
 * @author Chris
 *
 */
public class MarketPanel extends JPanel{

	private JLabel marketLabel;
	private JButton exitLabel = new JButton("");
	
	protected MarketPanel() 
	{
		this.setLayout(null);
        this.setBounds(168, 0, 832, 400);

        initialize();
    }
	
	private void initialize() 
    {
		
		JLabel lblNewLabel = new JLabel("10");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(91, 89, 85, 35);
		add(lblNewLabel);
		exitLabel.setBounds(new Rectangle(19, 340, 168, 53));
		
		exitLabel.setIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/Exit-Button-RED.png")));
		this.add(exitLabel);
		
		JButton label = new JButton("");
		label.setIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/Trade-Button.png")));
		label.setBounds(new Rectangle(10, 340, 168, 53));
		label.setBounds(648, 340, 168, 53);
		add(label);
		
		JLabel label_1 = new JLabel("10");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial", Font.BOLD, 25));
		label_1.setBounds(91, 152, 85, 35);
		add(label_1);
		
		JLabel label_2 = new JLabel("10");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Arial", Font.BOLD, 25));
		label_2.setBounds(91, 218, 85, 35);
		add(label_2);
		
		JLabel label_3 = new JLabel("10");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Arial", Font.BOLD, 25));
		label_3.setBounds(91, 280, 85, 35);
		add(label_3);
		
		JLabel label_4 = new JLabel("10");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Arial", Font.BOLD, 25));
		label_4.setBounds(720, 89, 85, 35);
		add(label_4);
		
		JLabel label_5 = new JLabel("10");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Arial", Font.BOLD, 25));
		label_5.setBounds(720, 152, 85, 35);
		add(label_5);
		
		JLabel label_6 = new JLabel("10");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Arial", Font.BOLD, 25));
		label_6.setBounds(720, 218, 85, 35);
		add(label_6);
		
		JLabel label_7 = new JLabel("10");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Arial", Font.BOLD, 25));
		label_7.setBounds(720, 280, 85, 35);
		add(label_7);
		
		JLabel label_8 = new JLabel("1000");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Arial", Font.BOLD, 35));
		label_8.setBounds(431, 348, 85, 35);
		add(label_8);
		this.marketLabel = new JLabel("");
		marketLabel.setIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/Market-Screen.png")));
		marketLabel.setBounds(0, 0, 832, 400);
		this.add(marketLabel);
    }
}
