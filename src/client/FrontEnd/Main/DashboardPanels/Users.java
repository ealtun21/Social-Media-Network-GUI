package client.FrontEnd.Main.DashboardPanels;

import javax.swing.JPanel;

import client.BackEnd.Colors;
import client.BackEnd.User;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Users extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField Search;

	/**
	 * Create the panel.
	 * @param user 
	 */
	public Users(User user) {
		setBackground(Colors.DARK_GRAY);
		setBounds(252, 12, 1436, 947);
		setLayout(null);
		setVisible(false);
		
		Search = new JTextField();
		Search.setBorder(null);
		Search.setForeground(Colors.WHITE);
		Search.setFont(new Font("Dialog", Font.PLAIN, 20));
		Search.setSelectedTextColor(Colors.LIGHT_GRAY);
		Search.setBackground(Colors.GRAY);
		Search.setBounds(431, 45, 596, 46);
		add(Search);
		Search.setColumns(10);
		
		JLabel search = new JLabel("");
		search.setIcon(new ImageIcon("IMG/Dashboard/search.png"));
		search.setOpaque(false);
		search.setBorder(null);
		search.setBackground(new Color(49, 63, 78));
		search.setBounds(355, 38, 64, 64);
		add(search);
	}
}
