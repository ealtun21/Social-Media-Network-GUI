/*
 * Creates a JPanel that contains a UserGroup with a specific look.
 */
package client.frontend.postentry.viewers;

import javax.swing.JPanel;

import client.backend.Content;
import client.backend.User;
import client.backend.UserGroup;
import client.frontend.Colors;
import client.frontend.Refreshable;
import client.frontend.postentry.creators.GroupContentCreator;
import client.frontend.postentry.editors.GroupEditor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GroupViewer extends JPanel implements Refreshable {

	private static final long serialVersionUID = 1L;

	private String title;
	private JPanel contentPanel;
	private JScrollPane scrollPane;
	private UserGroup group;
	private User user;

	/**
	 * Create the panel.
	 * 
	 * @param refreshable Any class that implements Refreshable is given, Classes
	 *                    that implements Refreshable are refreshable meaning that
	 *                    they will update their panels with the new content once
	 *                    the refresh method is called.
	 * @param user        The logged in user
	 * @param group       The group to display
	 * 
	 */
	public GroupViewer(Refreshable refresh, User user, UserGroup group) {
		this.group = group;
		this.user = user;

		title = group.getTitle();

		setPreferredSize(new Dimension(401, 591));
		setBorder(null);
		setVisible(true);
		setBackground(Colors.DARK_GRAY);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 139, 547, 796);
		scrollPane.setBorder(null);

		JButton btnCreateContent = new JButton("Create content");
		btnCreateContent.addActionListener(new ActionListener() {
			/*
			 * Starts content maker
			 */
			public void actionPerformed(ActionEvent e) {
				startContentMaker();
			}
		});

		JButton btnJoin = new JButton("Join Group");
		btnJoin.addActionListener(new ActionListener() {
			/*
			 * Adds user to group. Refreshes both this JPanel and the caller of this object
			 * (Most likely the Groups dashboardpanel).
			 */
			public void actionPerformed(ActionEvent e) {
				group.addMember(user);
				refresh.refresh();
				refresh();
			}
		});
		btnJoin.setPreferredSize(new Dimension(27, 37));
		btnJoin.setForeground(Colors.CYAN);
		btnJoin.setFont(new Font("Dialog", Font.BOLD, 15));
		btnJoin.setFocusPainted(false);
		btnJoin.setBackground(new Color(22, 28, 35));

		JButton btnLeave = new JButton("Leave Group");
		btnLeave.addActionListener(new ActionListener() {
			/*
			 * Removes user to group. Refreshes both this JPanel and the caller of this
			 * object (Most likely the Groups dashboardpanel).
			 */
			public void actionPerformed(ActionEvent e) {
				if (group.isCreator(user)) {
					JOptionPane.showMessageDialog(null, "The creator can't leave the group", "Invalid Leave!",
							JOptionPane.PLAIN_MESSAGE);
					return;
				}
				group.removeUser(user);
				refresh.refresh();
				refresh();
			}
		});
		btnLeave.setForeground(Colors.RED);
		btnLeave.setFont(new Font("Dialog", Font.BOLD, 15));
		btnLeave.setFocusPainted(false);
		btnLeave.setBackground(new Color(22, 28, 35));

		btnCreateContent.setForeground(new Color(235, 207, 71));
		btnCreateContent.setFont(new Font("Dialog", Font.BOLD, 17));
		btnCreateContent.setFocusPainted(false);
		btnCreateContent.setBackground(new Color(22, 28, 35));

		// Adds create content button only if the user is a member of the group.
		if (group.isMember(user)) {
			add(btnCreateContent);
		}

		JLabel lbltitle = new JLabel("Group Title: " + title);
		add(lbltitle);
		lbltitle.setForeground(Colors.PINK);
		lbltitle.setFont(new Font("Dialog", Font.BOLD, 20));

		JLabel lblMemerbs = new JLabel("Members: " + group.getUsersStr());

		// Adds groups member list if the user is part of group.
		if (group.isMember(user)) {
			add(lblMemerbs);
		}

		lblMemerbs.setForeground(Colors.WHITE);
		lblMemerbs.setFont(new Font("Dialog", Font.BOLD, 15));

		JLabel hobbies = new JLabel("Hobbies: " + group.getHobbiesStr());
		hobbies.setForeground(new Color(204, 199, 209));
		hobbies.setFont(new Font("Dialog", Font.BOLD, 15));
		add(hobbies);

		JLabel Creator = new JLabel("Creator: " + group.getCreator());
		Creator.setForeground(new Color(204, 199, 209));
		Creator.setFont(new Font("Dialog", Font.BOLD, 15));

		// Add creator label if the user is the creator.
		if (group.isMember(user)) {
			add(Creator);
		}

		JLabel Country = new JLabel("Country: " + group.getLocation());
		Country.setForeground(new Color(204, 199, 209));
		Country.setFont(new Font("Dialog", Font.BOLD, 15));
		add(Country);

		contentPanel = new JPanel();
		contentPanel.setBounds(28, 139, 397, 795);
		scrollPane.setViewportView(contentPanel);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

		// Adds scrollPane contain a pane with the groups content if the user is a
		// member of the group.
		if (group.isMember(user)) {
			add(scrollPane);
		}

		JButton btnEdit = new JButton("<html>E<p>D</p><p>I</p><p>T</p></html>\n");
		btnEdit.setVerticalTextPosition(SwingConstants.TOP);
		btnEdit.setVerticalAlignment(SwingConstants.TOP);
		btnEdit.setPreferredSize(new Dimension(27, 37));
		btnEdit.addActionListener(new ActionListener() {
			/*
			 * Starts the group editor.
			 */
			public void actionPerformed(ActionEvent e) {
				startGroupEditor(refresh, user, group);
			}
		});
		btnEdit.setForeground(Colors.bluishwhite);
		btnEdit.setFont(new Font("Dialog", Font.BOLD, 15));
		btnEdit.setFocusPainted(false);
		btnEdit.setBackground(new Color(22, 28, 35));

		if (group.isMember(user)) {
			add(btnLeave);
		} else {
			add(btnJoin);
		}

		if (group.isCreator(user)) {
			scrollPane.setRowHeaderView(btnEdit);
		}

	}

	// Getter
	public String getTitle() {
		return title;
	}

	/**
	 * Starts the Content creator for groups.
	 */
	public void startContentMaker() {
		GroupContentCreator frame = new GroupContentCreator(this, user, group);
		frame.setVisible(true);
	}

	/**
	 * Starts the Group Editor
	 * 
	 * @param refresh Gives group editor ability to refresh the contents of this
	 *                viewers panel.
	 * @param user    The logged in user
	 * @param group   the group that is being edited
	 */
	public void startGroupEditor(Refreshable refresh, User user, UserGroup group) {
		GroupEditor frame = new GroupEditor(refresh, user, group);
		frame.setVisible(true);
	}

	/*
	 * Refreshes this panel.
	 */
	@Override
	public void refresh() {
		contentPanel.removeAll();
		for (Content content : group.getConent()) {
			contentPanel.add(new ContentViewer(this, user, content));
		}
		contentPanel.revalidate();
		contentPanel.repaint();

	}

}
