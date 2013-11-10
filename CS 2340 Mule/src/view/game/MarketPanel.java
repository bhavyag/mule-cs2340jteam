package view.game;

import javax.swing.*;

/**
 * For the panel that is shown when the player enters the market.
 * @author Chris
 *
 */
public class MarketPanel {

	private JLabel marketLabel;
	
	protected MarketPanel() {
        this.marketLabel = new JLabel("");
        marketLabel.setBounds(5, 5, 832, 400);

        initialize();
    }
	
	private void initialize() 
    {
		
    }
}
