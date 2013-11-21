package view.game;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

public class DialogMessage extends JDialog {

	private JLabel textLabel;
	private JPanel buttonPane;
	private JButton okButton;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { try { DialogMessage dialog = new
	 * DialogMessage();
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 */

	/**
	 * Sets the text for the textLabel
	 */
	public void setDialogText(String text) {
		// <html> tag helps wrap the text so it doesn't overflow
		textLabel.setText("<html>" + text);
	}

	/**
	 * METHOD that adds a mouse listener to the OK button
	 * 
	 * @param mouseAdapter
	 *            the mouse adapter to add.
	 */
	public void onClickNext(MouseAdapter mouseAdapter) {
		okButton.addMouseListener(mouseAdapter);
	}

	/**
	 * Create the dialog.
	 */
	public DialogMessage(final String text) {
		setFont(new Font("Arial", Font.BOLD, 13));
		setTitle("Random Event");
		setName("RandomEvent");
		getContentPane().setBackground(new Color(255, 140, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				DialogMessage.class.getResource("/sprites/muleIcon.png")));
		setResizable(false);
		setType(Type.POPUP);
		setAlwaysOnTop(true);
		setBounds(503, 296, 450, 100);
		getContentPane().setLayout(null);

		textLabel = new JLabel("");
		// <html> tag helps wrap the text so it doesn't overflow
		textLabel.setText("<html>" + text);
		textLabel.setBackground(new Color(255, 140, 0));
		textLabel.setForeground(Color.WHITE);
		textLabel.setFont(new Font("Arial", Font.BOLD, 15));
		textLabel.setBounds(10, 0, 434, 71);
		getContentPane().add(textLabel);
		{
			buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 140, 0));
			buttonPane.setBounds(377, 38, 67, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}

		// instantiate the dialog box
		try {
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
