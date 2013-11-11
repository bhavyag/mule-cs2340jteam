package view.game;

import javax.swing.*;

import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * For the panel that is shown when the player enters the market.
 * @author Chris
 *
 */
public class MarketPanel extends JPanel{

	private JLabel marketLabel;
	private JButton exitButton = new JButton("");
	
	protected MarketPanel() 
	{
		this.setLayout(null);
        this.setBounds(168, 0, 832, 400);

        initialize();
    }
	
	private void initialize() 
    {
		exitButton.setBounds(new Rectangle(19, 340, 168, 53));
		
		exitButton.setIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/Exit-Button-RED.png")));
		this.add(exitButton);
		
		JButton tradeButton = new JButton("");
		tradeButton.setIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/Trade-Button.png")));
		tradeButton.setBounds(new Rectangle(10, 340, 168, 53));
		tradeButton.setBounds(648, 340, 168, 53);
		add(tradeButton);
		
		JLabel sellCrystite = new JLabel("");
		sellCrystite.setIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/sell-button.png")));
		sellCrystite.setBounds(512, 275, 106, 50);
		add(sellCrystite);
		
		JLabel sellEnergy = new JLabel("");
		sellEnergy.setIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/sell-button.png")));
		sellEnergy.setBounds(512, 210, 106, 50);
		add(sellEnergy);
		
		JLabel sellSmithore = new JLabel("");
		sellSmithore.setIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/sell-button.png")));
		sellSmithore.setBounds(512, 145, 106, 50);
		add(sellSmithore);
		
		JLabel sellFood = new JLabel("");
		sellFood.setIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/sell-button.png")));
		sellFood.setBounds(512, 82, 106, 50);
		add(sellFood);
		
		JButton buyFood = new JButton("");
		buyFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buyFood.setRolloverEnabled(false);
		buyFood.setRequestFocusEnabled(false);
		buyFood.setFocusable(false);
		buyFood.setFocusTraversalKeysEnabled(false);
		buyFood.setFocusPainted(false);
		buyFood.setPressedIcon(null);
		buyFood.setSelectedIcon(null);
		buyFood.setRolloverIcon(null);
		buyFood.setRolloverSelectedIcon(null);
		buyFood.setOpaque(false);
		buyFood.setBorderPainted(false);
		buyFood.setBorder(null);
		buyFood.setIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/buy-button.png")));
		buyFood.setBounds(216, 82, 106, 50);
		add(buyFood);
		
		JLabel buySmithore = new JLabel("");
		buySmithore.setIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/buy-button.png")));
		buySmithore.setBounds(216, 145, 106, 50);
		add(buySmithore);
		
		JLabel buyEnergy = new JLabel("");
		buyEnergy.setIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/buy-button.png")));
		buyEnergy.setBounds(216, 210, 106, 50);
		add(buyEnergy);
		
		JLabel buyCrystite = new JLabel("");
		buyCrystite.setIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/buy-button.png")));
		buyCrystite.setBounds(216, 275, 106, 50);
		add(buyCrystite);
		
		JLabel playerFood = new JLabel("10");
		playerFood.setForeground(Color.WHITE);
		playerFood.setFont(new Font("Arial", Font.BOLD, 25));
		playerFood.setBounds(91, 89, 85, 35);
		add(playerFood);
		
		JLabel playerSmithore = new JLabel("10");
		playerSmithore.setForeground(Color.WHITE);
		playerSmithore.setFont(new Font("Arial", Font.BOLD, 25));
		playerSmithore.setBounds(91, 152, 85, 35);
		add(playerSmithore);
		
		JLabel playerEnergy = new JLabel("10");
		playerEnergy.setForeground(Color.WHITE);
		playerEnergy.setFont(new Font("Arial", Font.BOLD, 25));
		playerEnergy.setBounds(91, 218, 85, 35);
		add(playerEnergy);
		
		JLabel playerCrystite = new JLabel("10");
		playerCrystite.setForeground(Color.WHITE);
		playerCrystite.setFont(new Font("Arial", Font.BOLD, 25));
		playerCrystite.setBounds(91, 280, 85, 35);
		add(playerCrystite);
		
		JLabel storeFood = new JLabel("10");
		storeFood.setForeground(Color.WHITE);
		storeFood.setFont(new Font("Arial", Font.BOLD, 25));
		storeFood.setBounds(720, 89, 85, 35);
		add(storeFood);
		
		JLabel storeSmithore = new JLabel("10");
		storeSmithore.setForeground(Color.WHITE);
		storeSmithore.setFont(new Font("Arial", Font.BOLD, 25));
		storeSmithore.setBounds(720, 152, 85, 35);
		add(storeSmithore);
		
		JLabel storeEnergy = new JLabel("10");
		storeEnergy.setForeground(Color.WHITE);
		storeEnergy.setFont(new Font("Arial", Font.BOLD, 25));
		storeEnergy.setBounds(720, 218, 85, 35);
		add(storeEnergy);
		
		JLabel storeCrystite = new JLabel("10");
		storeCrystite.setForeground(Color.WHITE);
		storeCrystite.setFont(new Font("Arial", Font.BOLD, 25));
		storeCrystite.setBounds(720, 280, 85, 35);
		add(storeCrystite);
		
		JLabel total = new JLabel("1000");
		total.setForeground(Color.WHITE);
		total.setFont(new Font("Arial", Font.BOLD, 35));
		total.setBounds(431, 348, 85, 35);
		add(total);
		this.marketLabel = new JLabel("");
		marketLabel.setIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/Market-Screen.png")));
		marketLabel.setBounds(0, 0, 832, 400);
		this.add(marketLabel);
    }
}
