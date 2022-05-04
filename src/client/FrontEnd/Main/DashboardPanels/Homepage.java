package client.FrontEnd.Main.DashboardPanels;

import client.BackEnd.Colors;
import client.BackEnd.Content;
import client.BackEnd.User;
import client.FrontEnd.Main.ContentMaker;
import client.FrontEnd.Main.ContentViewer;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;


public class Homepage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	
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
				startContentMaker(user);
			}
		});
		btnCreateContent.setForeground(Colors.yellow);
		btnCreateContent.setFont(new Font("Dialog", Font.BOLD, 17));
		btnCreateContent.setFocusPainted(false);
		btnCreateContent.setBackground(new Color(22, 28, 35));
		btnCreateContent.setBounds(27, 28, 180, 45);
		add(btnCreateContent);
		
		/*
		JButton btnRefreshPage = new JButton("Refresh Page");
		btnRefreshPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh(user);
			}
		});
		
		btnRefreshPage.setForeground(Colors.MAGENTA);
		btnRefreshPage.setFont(new Font("Dialog", Font.BOLD, 17));
		btnRefreshPage.setFocusPainted(false);
		btnRefreshPage.setBackground(new Color(22, 28, 35));
		btnRefreshPage.setBounds(252, 28, 180, 45);
		add(btnRefreshPage);
		*/
		
		JLabel lblYourPosts = new JLabel("Your posts");
		lblYourPosts.setFont(new Font("Dialog", Font.BOLD, 18));
		lblYourPosts.setForeground(Color.WHITE);
		lblYourPosts.setBounds(27, 141, 113, 26);
		add(lblYourPosts);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 179, 934, 756);
		add(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setBorder(null);
		panel.setLayout(new WrapLayout());
		panel.setVisible(true);
		refresh(user);
		
		
	}

	/**
	 * Refreshes the panel inside the home page
	 * @param user
	 */
	public void refresh(User user) {
		panel.removeAll();
		for (Content content : user.getConentPersonal()) {
			panel.add(new ContentViewer(content));
		}
		panel.revalidate();
		panel.repaint();
	}

	/**
	 * Creates new content then, refreshes the panel inside the home page
	 * @param user
	 */
	public void startContentMaker(User user) {
		ContentMaker frame = new ContentMaker(this,user);
		frame.setVisible(true);
	}
}
