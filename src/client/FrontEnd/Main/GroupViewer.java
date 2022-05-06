package client.FrontEnd.Main;

import javax.swing.JPanel;
import client.BackEnd.Colors;
import client.BackEnd.Content;
import client.BackEnd.Refreshable;
import client.BackEnd.User;
import client.BackEnd.UserGroup;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTextPane;
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
	private UserGroup group;

	/**
	 * Create the panel.
	 */
	public GroupViewer(Refreshable refresh, User user, UserGroup group) {
		// TODO: Join Group, Leave Group. Member list. Refresh. Content panel
		this.group = group;
		
		title = group.getTitle();

		setPreferredSize(new Dimension(401, 591));
		setBorder(null);
		setVisible(true);
		setBackground(Colors.DARK_GRAY);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		add(scrollPane);

		JButton btnCreateContent = new JButton("Create content");
		btnCreateContent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startContentMaker(user);
			}
		});
		
		JButton btnJoin = new JButton("Join Group");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				group.addMember(user);
				refresh.refresh(user);
				refresh(user);
			}
		});
		btnJoin.setPreferredSize(new Dimension(27, 37));
		btnJoin.setForeground(Colors.CYAN);
		btnJoin.setFont(new Font("Dialog", Font.BOLD, 15));
		btnJoin.setFocusPainted(false);
		btnJoin.setBackground(new Color(22, 28, 35));
		
		JButton btnLeave = new JButton("Leave Group");
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (group.isCreator(user)) {
					JOptionPane.showMessageDialog(null, "The creator can't leave the group", "Invalid Leave!", JOptionPane.PLAIN_MESSAGE);
					return;
				}
				group.removeUser(user);
				refresh.refresh(user);
				refresh(user);
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
		add(btnCreateContent);

		JLabel lbltitle = new JLabel(
				"Group Title: " + title + " Creator: " + group.getCreator() + " @: " + group.getLocation());
		add(lbltitle);
		lbltitle.setForeground(Colors.WHITE);
		lbltitle.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JLabel lblMemerbs = new JLabel(
				"Members: " + group.getUsersStr());
		add(lblMemerbs);
		lblMemerbs.setForeground(Colors.WHITE);
		lblMemerbs.setFont(new Font("Dialog", Font.BOLD, 15));

		JLabel hobbies = new JLabel(group.getHobbiesStr());
		hobbies.setForeground(new Color(204, 199, 209));
		hobbies.setFont(new Font("Dialog", Font.BOLD, 15));
		add(hobbies);

		scrollPane.setBounds(27, 139, 547, 796);
		add(scrollPane);
		contentPanel = new JPanel();
		contentPanel.setBounds(28, 139, 397, 795);
		scrollPane.setViewportView(contentPanel);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

		JButton btnEdit = new JButton("<html>E<p>D</p><p>I</p><p>T</p></html>\n");
		btnEdit.setVerticalTextPosition(SwingConstants.TOP);
		btnEdit.setVerticalAlignment(SwingConstants.TOP);
		btnEdit.setPreferredSize(new Dimension(27, 37));
		btnEdit.addActionListener(new ActionListener() {
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

	public String getTitle() {
		return title;
	}

	/**
	 * Refreshes the panel inside the group viewer
	 * 
	 * @param user
	 */
	public void refresh(User creator, UserGroup group) {
		contentPanel.removeAll();
		for (Content content : group.getConent()) {
			contentPanel.add(new ContentViewer(this, creator, content));
		}
		contentPanel.revalidate();
		contentPanel.repaint();
	}

	/**
	 * @param contentable
	 */
	public void startContentMaker(User user) {
		GroupContentMaker frame = new GroupContentMaker(this, user, group);
		frame.setVisible(true);
	}

	/**
	 * @param contentable
	 * @param group
	 */
	public void startGroupEditor(Refreshable refresh, User contentable, UserGroup group) {
		GroupEditor frame = new GroupEditor(refresh, contentable, group);
		frame.setVisible(true);
	}

	@Override
	public void refresh(User user) {
		contentPanel.removeAll();
		for (Content content : group.getConent()) {
			contentPanel.add(new ContentViewer(this, user, content));
		}
		contentPanel.revalidate();
		contentPanel.repaint();

	}

}
