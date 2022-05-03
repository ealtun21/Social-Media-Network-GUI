package client.FrontEnd.Main.DashboardPanels;

import javax.swing.JPanel;

import client.BackEnd.Colors;
import client.BackEnd.Content;
import client.BackEnd.User;
import client.FrontEnd.Main.ContentMaker;
import client.FrontEnd.Main.ContentViewer;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Homepage extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Homepage(User user) {
		setBackground(Colors.DARK_GRAY);
		setBounds(252, 12, 1436, 947);
		setLayout(null);
		
		JButton btnCreateContent = new JButton("Create content");
		btnCreateContent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContentMaker frame = new ContentMaker(user);
				frame.setVisible(true);
			}
		});
		btnCreateContent.setForeground(Colors.yellow);
		btnCreateContent.setFont(new Font("Dialog", Font.BOLD, 17));
		btnCreateContent.setFocusPainted(false);
		btnCreateContent.setBackground(new Color(22, 28, 35));
		btnCreateContent.setBounds(27, 28, 180, 45);
		add(btnCreateContent);
		
		// TODO Dynamticly Add ContentViewer panels. to Homepage!
		
		// Note the code below does not work. it's just the current idea I have.
		
		JButton btnRefreshPage = new JButton("Refresh Page");
		btnRefreshPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Content content : user.getConentPersonal()) {
					add(new ContentViewer(content));
				}
			}
		});
		btnRefreshPage.setForeground(Colors.MAGENTA);
		btnRefreshPage.setFont(new Font("Dialog", Font.BOLD, 17));
		btnRefreshPage.setFocusPainted(false);
		btnRefreshPage.setBackground(new Color(22, 28, 35));
		btnRefreshPage.setBounds(252, 28, 180, 45);
		add(btnRefreshPage);
		
		
	}
}
