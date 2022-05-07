package client.FrontEnd.Main.Viewers;

import javax.swing.JPanel;
import client.BackEnd.Colors;
import client.BackEnd.Content;
import client.BackEnd.Refreshable;
import client.BackEnd.User;
import client.BackEnd.UserGroup;
import client.FrontEnd.Main.Creators.GroupContentCreator;
import client.FrontEnd.Main.Editors.GroupEditor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JTextPane;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class UserViewer extends JPanel{

	private static final long serialVersionUID = 1L;


	/**
	 * Create the panel.
	 */
	public UserViewer(Refreshable refresh, User user, User other) {
		// TODO add Friends, Groups, Contents when useer follows.
		
		setSize(new Dimension(426, 41));
		setPreferredSize(new Dimension(585, 255));
		setBackground(Colors.GRAY);
		setLayout(new BorderLayout(0, 0));
			
			JPanel panel = new JPanel();
			panel.setBackground(Colors.DARK_GRAY);
			add(panel, BorderLayout.NORTH);
			JLabel userName = new JLabel("User: " + user.getNickname());
			panel.add(userName);
			userName.setSize(new Dimension(426, 41));
			userName.setForeground(Colors.BLUE);
			userName.setFont(new Font("Dialog", Font.BOLD, 17));
			
			JSeparator separator = new JSeparator();
			panel.add(separator);
			
			JLabel realname = new JLabel("Fullname : "+other.getFullname());
			realname.setSize(new Dimension(426, 41));
			realname.setForeground(new Color(91, 192, 220));
			realname.setFont(new Font("Dialog", Font.BOLD, 17));
			panel.add(realname);
			
			JSeparator separator_1 = new JSeparator();
			panel.add(separator_1);
			
			JLabel accountType = new JLabel("Account Type: " + (other.isPremium() ? "Premium" : "Standard"));
			accountType.setSize(new Dimension(426, 41));
			accountType.setForeground(new Color(91, 192, 220));
			accountType.setFont(new Font("Dialog", Font.BOLD, 17));
			panel.add(accountType);
			
			JLabel profilePic = new JLabel("");
			profilePic.setIcon(other.getProfileImage());
			add(profilePic, BorderLayout.CENTER);
			
			JButton btnUnfollow = new JButton("Unfollow");
			if (user.getFollowingUsers().contains(other)) {
				panel.add(btnUnfollow);
			}
			btnUnfollow.setBackground(Colors.BLACK);
			btnUnfollow.setForeground(Colors.PINK);
			
			JButton btnFollow = new JButton("Follow");
			if (user.getFollowingUsers().contains(other)) {
				panel.add(btnFollow);
			}
			btnFollow.setBackground(Colors.BLACK);
			btnFollow.setForeground(Colors.YELLOW);
			btnFollow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					user.follow(other);
					refresh.refresh(user);
				}
			});
			btnUnfollow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					user.unfollow(other);
					refresh.refresh(user);
				}
			});
		
		
	}
}
