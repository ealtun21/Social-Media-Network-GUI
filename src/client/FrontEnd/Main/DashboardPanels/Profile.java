package client.FrontEnd.Main.DashboardPanels;

import client.BackEnd.Colors;
import client.BackEnd.Content;
import client.BackEnd.Refreshable;
import client.BackEnd.User;
import client.FrontEnd.Main.ContentMaker;
import client.FrontEnd.Main.ContentViewer;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class Profile extends JPanel implements Refreshable{

	private static final long serialVersionUID = 1L;
	protected JPanel panel;
	
	/**
	 * Create the panel.
	 */
	public Profile(User user) {
		setBackground(Colors.DARK_GRAY);
		setBounds(252, 12, 1436, 947);
		setLayout(null);
		setVisible(false);
		
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
		
		JLabel lblYourPosts = new JLabel("Your posts");
		lblYourPosts.setFont(new Font("Dialog", Font.BOLD, 18));
		lblYourPosts.setForeground(Color.WHITE);
		lblYourPosts.setBounds(26, 105, 113, 26);
		add(lblYourPosts);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 139, 434, 796);
		add(scrollPane);
		panel =  new JPanel();
		panel.setBounds(28, 139, 397, 795);
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JButton btnCreateGroup = new JButton("Create Group");
		btnCreateGroup.setForeground(Colors.magenta);
		btnCreateGroup.setFont(new Font("Dialog", Font.BOLD, 17));
		btnCreateGroup.setFocusPainted(false);
		btnCreateGroup.setBackground(new Color(22, 28, 35));
		btnCreateGroup.setBounds(572, 28, 180, 45);
		if (user.isPremium()) {
			add(btnCreateGroup);
		}
		panel.setVisible(true);
		
	}
	
	/**
	 * Refreshes the panel inside the home page
	 * @param user
	 */
	public void refresh(User user) {
		panel.removeAll();
		for (Content content : user.getConentPersonal()) {
			panel.add(new ContentViewer(this,user,content));
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
