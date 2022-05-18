package client.frontend.postentry.viewers;

import javax.swing.JPanel;

import client.backend.Content;
import client.backend.User;
import client.backend.UserGroup;
import client.frontend.Colors;
import client.frontend.Refreshable;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JSeparator;
import javax.swing.JList;

public class UserViewer extends JPanel implements Refreshable {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private User other;
	private JList<User> friends;
	private JList<UserGroup> groups;

	/**
	 * Create the panel.
	 */
	public UserViewer(Refreshable refresh, User user, User other) {
		this.other = other;

		setSize(new Dimension(426, 41));
		setBackground(Colors.GRAY);
		setLayout(new BorderLayout(0, 0));

		JPanel titlePanel = new JPanel();
		titlePanel.setPreferredSize(new Dimension(10, 70));
		titlePanel.setBackground(Colors.DARK_GRAY);
		add(titlePanel, BorderLayout.NORTH);

		JLabel userName = new JLabel("User: " + other.getNickname());
		titlePanel.add(userName);
		userName.setSize(new Dimension(426, 41));
		userName.setForeground(Colors.BLUE);
		userName.setFont(new Font("Dialog", Font.BOLD, 17));

		JSeparator separator = new JSeparator();
		titlePanel.add(separator);

		JLabel realname = new JLabel("Fullname : " + other.getFullname());
		realname.setSize(new Dimension(426, 41));
		realname.setForeground(new Color(91, 192, 220));
		realname.setFont(new Font("Dialog", Font.BOLD, 17));
		titlePanel.add(realname);

		JSeparator separator_1 = new JSeparator();
		titlePanel.add(separator_1);

		JLabel accountType = new JLabel("Account Type: " + (other.isPremium() ? "Premium" : "Standard"));
		accountType.setSize(new Dimension(426, 41));
		accountType.setForeground(new Color(91, 192, 220));
		accountType.setFont(new Font("Dialog", Font.BOLD, 17));
		titlePanel.add(accountType);

		JLabel profilePic = new JLabel("");
		profilePic.setIcon(other.getProfileImage());
		add(profilePic, BorderLayout.WEST);

		JScrollPane scrollPane = new JScrollPane();
		if (user.getFollowingUsers().contains(other)) {
			add(scrollPane, BorderLayout.CENTER);
		}

		contentPanel = new JPanel();
		scrollPane.setViewportView(contentPanel);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

		JPanel sidePanel = new JPanel();

		if (user.getFollowingUsers().contains(other)) {
			add(sidePanel, BorderLayout.EAST);
		}

		sidePanel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPaneGrops = new JScrollPane();
		groups = new JList<UserGroup>(new Vector<UserGroup>(other.getFollowingGroups()));
		groups.setBackground(Colors.GRAY.brighter());
		scrollPaneGrops.setViewportView(groups);

		JScrollPane scrollPaneFriends = new JScrollPane();
		friends = new JList<User>(new Vector<User>(other.getFollowingUsers()));
		friends.setBackground(Colors.GRAY.brighter());
		scrollPaneFriends.setViewportView(friends);

		sidePanel.add(scrollPaneFriends, BorderLayout.WEST);

		JLabel lblFriends = new JLabel("Friends");
		lblFriends.setBackground(Colors.BLACK);
		lblFriends.setOpaque(true);
		lblFriends.setForeground(Colors.WHITE);
		scrollPaneFriends.setColumnHeaderView(lblFriends);

		sidePanel.add(scrollPaneGrops, BorderLayout.EAST);

		JLabel lblGroups = new JLabel("Groups");
		lblGroups.setBackground(Colors.BLACK);
		lblGroups.setOpaque(true);
		lblGroups.setForeground(Color.WHITE);
		scrollPaneGrops.setColumnHeaderView(lblGroups);

		JButton btnUnfollow = new JButton("Unfollow");
		if (user.getFollowingUsers().contains(other)) {
			titlePanel.add(btnUnfollow);
		}
		btnUnfollow.setBackground(Colors.BLACK);
		btnUnfollow.setForeground(Colors.PINK);

		JButton btnFollow = new JButton("Follow");

		if (!user.getFollowingUsers().contains(other)) {
			titlePanel.add(btnFollow);
		}

		btnFollow.setBackground(Colors.BLACK);
		btnFollow.setForeground(Colors.YELLOW);
		btnFollow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.follow(other);
				refresh.refresh(user);
				refresh(user);
			}
		});
		btnUnfollow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.unfollow(other);
				refresh.refresh(user);
				refresh(user);
			}
		});

		if (user.getFollowingUsers().contains(other)) {
			for (Content content : other.getConentPersonal()) {
				contentPanel.add(new ContentViewer(this, user, content));
			}
		}

	}

	public String getTitle() {
		return other.getNickname() + " " + other.getFullname();
	}

	@Override
	public void refresh(User user) {
		if (user.getFollowingUsers().contains(other)) {
			groups.removeAll();
			friends.removeAll();

			groups = new JList<UserGroup>(new Vector<UserGroup>(other.getFollowingGroups()));
			friends = new JList<User>(new Vector<User>(other.getFollowingUsers()));

			groups.repaint();
			friends.repaint();

			contentPanel.removeAll();
			for (Content content : other.getConentPersonal()) {
				contentPanel.add(new ContentViewer(this, user, content));
			}
			contentPanel.revalidate();
			contentPanel.repaint();
		}
		revalidate();
		repaint();
	}

}
