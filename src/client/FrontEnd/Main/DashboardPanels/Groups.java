package client.FrontEnd.Main.DashboardPanels;

import javax.swing.JPanel;

import client.BackEnd.Colors;
import client.BackEnd.User;


public class Groups extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @param user 
	 */
	public Groups(User user) {
		setBackground(Colors.DARK_GRAY);
		setBounds(252, 12, 1436, 947);
		setVisible(false);
	}

}
