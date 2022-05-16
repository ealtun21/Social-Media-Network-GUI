package client.frontend.postentry.dashboardpanels;

import javax.swing.JPanel;

import client.backend.User;
import client.frontend.postentry.Colors;


public class Homepage extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @param user 
	 */
	public Homepage(User user) {
		setBackground(Colors.DARK_GRAY);
		setBounds(252, 12, 1436, 947);
		setVisible(true);
	}

}
