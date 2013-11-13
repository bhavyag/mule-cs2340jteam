package view.game;

import javax.swing.*;

import model.Player;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * For the panel that is shown when the player enters the market.
 * @author Chris
 *
 */
public class MarketPanel extends JPanel{

	private JLabel marketLabel;
	private JButton exitButton = new JButton("");
	
	JButton sellCrystite;
	JButton sellEnergy;
	JButton sellSmithore;
	JButton sellFood;
	JButton buyFood;
	JButton buySmithore;
	JButton buyEnergy;
	JButton buyCrystite;
	
	private JLabel playerFood;
	private JLabel playerSmithore;
	private JLabel playerEnergy;
	private JLabel playerCrystite;
	private JLabel storeFood;
	private JLabel storeSmithore;
	private JLabel storeEnergy;
	private JLabel storeCrystite;
	private JLabel total;
	
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
		
		sellCrystite = new JButton("");
		sellCrystite.setFocusable(false);
		sellCrystite.setBorderPainted(false);
		sellCrystite.setBorder(null);
		sellCrystite.setOpaque(false);
		sellCrystite.setRolloverSelectedIcon(null);
		sellCrystite.setRolloverIcon(null);
		sellCrystite.setRolloverEnabled(false);
		sellCrystite.setRequestFocusEnabled(false);
		sellCrystite.setSelectedIcon(null);
		sellCrystite.setPressedIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/sell-button-PRESSED.png")));
		sellCrystite.setContentAreaFilled(false);
		sellCrystite.setIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/sell-button.png")));
		sellCrystite.setBounds(512, 275, 106, 50);
		add(sellCrystite);
		
		sellEnergy = new JButton("");
		sellEnergy.setFocusable(false);
		sellEnergy.setBorderPainted(false);
		sellEnergy.setBorder(null);
		sellEnergy.setOpaque(false);
		sellEnergy.setRolloverSelectedIcon(null);
		sellEnergy.setRolloverIcon(null);
		sellEnergy.setRolloverEnabled(false);
		sellEnergy.setRequestFocusEnabled(false);
		sellEnergy.setSelectedIcon(null);
		sellEnergy.setPressedIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/sell-button-PRESSED.png")));
		sellEnergy.setContentAreaFilled(false);
		sellEnergy.setIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/sell-button.png")));
		sellEnergy.setBounds(512, 210, 106, 50);
		add(sellEnergy);
		
		sellSmithore = new JButton("");
		sellSmithore.setFocusable(false);
		sellSmithore.setBorderPainted(false);
		sellSmithore.setBorder(null);
		sellSmithore.setOpaque(false);
		sellSmithore.setRolloverSelectedIcon(null);
		sellSmithore.setRolloverIcon(null);
		sellSmithore.setRolloverEnabled(false);
		sellSmithore.setRequestFocusEnabled(false);
		sellSmithore.setSelectedIcon(null);
		sellSmithore.setPressedIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/sell-button-PRESSED.png")));
		sellSmithore.setContentAreaFilled(false);
		sellSmithore.setIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/sell-button.png")));
		sellSmithore.setBounds(512, 145, 106, 50);
		add(sellSmithore);
		
		sellFood = new JButton("");
		sellFood.setFocusable(false);
		sellFood.setFocusTraversalKeysEnabled(false);
		sellFood.setBorderPainted(false);
		sellFood.setBorder(null);
		sellFood.setOpaque(false);
		sellFood.setRolloverSelectedIcon(null);
		sellFood.setRolloverIcon(null);
		sellFood.setRolloverEnabled(false);
		sellFood.setRequestFocusEnabled(false);
		sellFood.setSelectedIcon(null);
		sellFood.setPressedIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/sell-button-PRESSED.png")));
		sellFood.setContentAreaFilled(false);
		sellFood.setIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/sell-button.png")));
		sellFood.setBounds(512, 82, 106, 50);
		add(sellFood);
		
		buyFood = new JButton("");
		buyFood.setPressedIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/buy-button-PRESSED.png")));
		buyFood.setContentAreaFilled(false);
		buyFood.setFocusTraversalPolicyProvider(true);
		buyFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buyFood.setRolloverEnabled(false);
		buyFood.setRequestFocusEnabled(false);
		buyFood.setFocusable(false);
		buyFood.setFocusTraversalKeysEnabled(false);
		buyFood.setFocusPainted(false);
		buyFood.setSelectedIcon(null);
		buyFood.setRolloverIcon(null);
		buyFood.setRolloverSelectedIcon(null);
		buyFood.setOpaque(false);
		buyFood.setBorderPainted(false);
		buyFood.setBorder(null);
		buyFood.setIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/buy-button.png")));
		buyFood.setBounds(216, 82, 106, 50);
		add(buyFood);
		
		buySmithore = new JButton("");
		buySmithore.setFocusable(false);
		buySmithore.setBorderPainted(false);
		buySmithore.setBorder(null);
		buySmithore.setOpaque(false);
		buySmithore.setRolloverSelectedIcon(null);
		buySmithore.setRolloverIcon(null);
		buySmithore.setRolloverEnabled(false);
		buySmithore.setRequestFocusEnabled(false);
		buySmithore.setSelectedIcon(null);
		buySmithore.setPressedIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/buy-button-PRESSED.png")));
		buySmithore.setContentAreaFilled(false);
		buySmithore.setIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/buy-button.png")));
		buySmithore.setBounds(216, 145, 106, 50);
		add(buySmithore);
		
		buyEnergy = new JButton("");
		buyEnergy.setFocusable(false);
		buyEnergy.setBorderPainted(false);
		buyEnergy.setBorder(null);
		buyEnergy.setOpaque(false);
		buyEnergy.setRolloverSelectedIcon(null);
		buyEnergy.setRolloverIcon(null);
		buyEnergy.setRolloverEnabled(false);
		buyEnergy.setRequestFocusEnabled(false);
		buyEnergy.setSelectedIcon(null);
		buyEnergy.setPressedIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/buy-button-PRESSED.png")));
		buyEnergy.setContentAreaFilled(false);
		buyEnergy.setIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/buy-button.png")));
		buyEnergy.setBounds(216, 210, 106, 50);
		add(buyEnergy);
		
		buyCrystite = new JButton("");
		buyCrystite.setFocusable(false);
		buyCrystite.setBorderPainted(false);
		buyCrystite.setBorder(null);
		buyCrystite.setOpaque(false);
		buyCrystite.setRolloverSelectedIcon(null);
		buyCrystite.setRolloverIcon(null);
		buyCrystite.setRolloverEnabled(false);
		buyCrystite.setRequestFocusEnabled(false);
		buyCrystite.setSelectedIcon(null);
		buyCrystite.setPressedIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/buy-button-PRESSED.png")));
		buyCrystite.setContentAreaFilled(false);
		buyCrystite.setIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/buy-button.png")));
		buyCrystite.setBounds(216, 275, 106, 50);
		add(buyCrystite);
		
		this.playerFood = new JLabel("10");
		this.playerFood.setForeground(Color.WHITE);
		this.playerFood.setFont(new Font("Arial", Font.BOLD, 25));
		this.playerFood.setBounds(91, 89, 85, 35);
		this.add(playerFood);
		
		this.playerSmithore = new JLabel("10");
		this.playerSmithore.setForeground(Color.WHITE);
		this.playerSmithore.setFont(new Font("Arial", Font.BOLD, 25));
		this.playerSmithore.setBounds(91, 152, 85, 35);
		this.add(playerSmithore);
		
		this.playerEnergy = new JLabel("10");
		this.playerEnergy.setForeground(Color.WHITE);
		this.playerEnergy.setFont(new Font("Arial", Font.BOLD, 25));
		this.playerEnergy.setBounds(91, 218, 85, 35);
		this.add(playerEnergy);
		
		this.playerCrystite = new JLabel("10");
		this.playerCrystite.setForeground(Color.WHITE);
		this.playerCrystite.setFont(new Font("Arial", Font.BOLD, 25));
		this.playerCrystite.setBounds(91, 280, 85, 35);
		this.add(playerCrystite);
		
		storeFood = new JLabel("10");
		storeFood.setForeground(Color.WHITE);
		storeFood.setFont(new Font("Arial", Font.BOLD, 25));
		storeFood.setBounds(720, 89, 85, 35);
		add(storeFood);
		
		storeSmithore = new JLabel("10");
		storeSmithore.setForeground(Color.WHITE);
		storeSmithore.setFont(new Font("Arial", Font.BOLD, 25));
		storeSmithore.setBounds(720, 152, 85, 35);
		add(storeSmithore);
		
		storeEnergy = new JLabel("10");
		storeEnergy.setForeground(Color.WHITE);
		storeEnergy.setFont(new Font("Arial", Font.BOLD, 25));
		storeEnergy.setBounds(720, 218, 85, 35);
		add(storeEnergy);
		
		storeCrystite = new JLabel("10");
		storeCrystite.setForeground(Color.WHITE);
		storeCrystite.setFont(new Font("Arial", Font.BOLD, 25));
		storeCrystite.setBounds(720, 280, 85, 35);
		add(storeCrystite);
		
		total = new JLabel("1000");
		total.setForeground(Color.WHITE);
		total.setFont(new Font("Arial", Font.BOLD, 35));
		total.setBounds(431, 348, 85, 35);
		add(total);
		this.marketLabel = new JLabel("");
		marketLabel.setFocusable(false);
		marketLabel.setIcon(new ImageIcon(MarketPanel.class.getResource("/sprites/market/Market-Screen.png")));
		marketLabel.setBounds(0, 0, 832, 400);
		this.add(marketLabel);
    }
	
	public void setUpMarket(int[][] data)
	{
		this.playerFood.setText(""+data[0][0]);
		this.playerSmithore.setText(""+data[0][1]);
		this.playerEnergy.setText(""+data[0][2]);
		this.playerCrystite.setText(""+data[0][3]);
		
		this.storeFood.setText(""+data[1][0]);
		this.storeSmithore.setText(""+data[1][1]);
		this.storeEnergy.setText(""+data[1][2]);
		this.storeCrystite.setText(""+data[1][3]);
		
		sellCrystite.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
			}
		});
		
		sellEnergy.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{

			}
		});
		
		sellSmithore.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{

			}
		});
		
		sellFood.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				int playerFoodAmount = Integer.parseInt(playerFood.getText());
				int storeFoodAmount = Integer.parseInt(storeFood.getText());
				if(playerFoodAmount != 0)
				{
					playerFoodAmount--;
					playerFood.setText(""+(playerFoodAmount));
					storeFoodAmount++;
					storeFood.setText(""+storeFoodAmount);
				}
				
			}
		});
		
		buyFood.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{

			}
		});
		
		buySmithore.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{

			}
		});
		
		buyEnergy.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{

			}
		});
		
		buyCrystite.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{

			}
		});
	}
	
	/**
     * METHOD that adds a mouse listener to the market panel exit button
     * @param mouseAdapter the mouse listener to add
     */
    protected void onClickExit(MouseAdapter mouseAdapter) {
        exitButton.addMouseListener(mouseAdapter);
    }
}
