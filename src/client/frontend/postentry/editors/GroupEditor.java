/**
 * Starts a window that is used to edit groups.
 */
package client.frontend.postentry.editors;

import client.backend.Content;
import client.backend.User;
import client.backend.UserGroup;
import client.frontend.Colors;
import client.frontend.Refreshable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class GroupEditor extends JFrame implements Refreshable {

	private static final long serialVersionUID = 1L;
	private JList<User> list;
	private UserGroup group;
	private Refreshable refreshable;
	private User user;

	/**
	 * Create the window.
	 * 
	 * @param refreshable Any class that implements Refreshable is given, Classes
	 *                    that implements Refreshable are refreshable meaning that
	 *                    they will update their panels with the new content once
	 *                    the refresh method is called.
	 * @param user        the logged in user
	 * 
	 * @param group       the group that is being modified
	 */
	public GroupEditor(Refreshable refreshable, User user, UserGroup group) {
		this.user = user;
		this.refreshable = refreshable;
		this.group = group;
		setType(Type.UTILITY);
		setAlwaysOnTop(true);
		setTitle("Create Content");
		getContentPane().setBackground(Colors.DARK_GRAY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(323, 470);
		getContentPane().setLayout(null);

		JLabel lblEditGroup = new JLabel("Edit Group");
		lblEditGroup.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditGroup.setHorizontalTextPosition(SwingConstants.LEFT);
		lblEditGroup.setForeground(Colors.WHITE);
		lblEditGroup.setFont(new Font("Dialog", Font.BOLD, 20));
		lblEditGroup.setBounds(12, 12, 281, 37);
		getContentPane().add(lblEditGroup);

		JButton btnDeleteGroup = new JButton("Delete Group");
		btnDeleteGroup.addActionListener(new ActionListener() {
			/**
			 * Deletes the group, sends a confirmation to the user via a JOptionPane, if
			 * deleted refreshes the passed refreshable (most likely the groups dashboard
			 * panel) and closes window.
			 * 
			 */
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this group?",
						"Confirm Deleting Group", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					group.dispose(user);
					refreshable.refresh();
					dispose();
				}
			}
		});
		btnDeleteGroup.setForeground(Colors.RED.darker());
		btnDeleteGroup.setFont(new Font("Dialog", Font.BOLD, 14));
		btnDeleteGroup.setFocusPainted(false);
		btnDeleteGroup.setBackground(Colors.BLACK);
		btnDeleteGroup.setBounds(181, 386, 130, 29);
		getContentPane().add(btnDeleteGroup);

		list = new JList<User>(new Vector<User>(group.getUsers()));
		list.setBounds(12, 88, 282, 286);
		setVisible(true);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(12, 88, 282, 286);
		getContentPane().add(scrollPane);

		JLabel lblMembers = new JLabel("Members");
		lblMembers.setForeground(Colors.WHITE);
		lblMembers.setFont(new Font("Dialog", Font.BOLD, 18));
		lblMembers.setBounds(12, 61, 113, 26);
		getContentPane().add(lblMembers);

		JButton btnRemoveSelected = new JButton("Remove Selected");
		btnRemoveSelected.addActionListener(new ActionListener() {
			/*
			 * Removes user from the group except for the creator, if creator attempt to
			 * leave, sends corresponding error via JOptionPane. Calls this classes refresh
			 * method.
			 */
			public void actionPerformed(ActionEvent e) {
				if (group.isCreator(user)) {
					JOptionPane.showMessageDialog(null, "The creator can't leave the group", "Invalid Leave!",
							JOptionPane.PLAIN_MESSAGE);
					return;
				}
				group.removeUser(list.getSelectedValue());
				refresh(); // This classes refresh.
			}
		});
		btnRemoveSelected.setForeground(Colors.RED);
		btnRemoveSelected.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRemoveSelected.setFocusPainted(false);
		btnRemoveSelected.setBackground(Colors.BLACK);
		btnRemoveSelected.setBounds(12, 386, 158, 29);
		getContentPane().add(btnRemoveSelected);
		setVisible(false);
	}

	/**
	 * Checks if the title is already used. NOTE: Titles are unique.
	 * 
	 * 
	 * @param title The title that will be checked
	 * @return returns true is title is used, false if not used.
	 */
	protected boolean isTitleUsed(JTextField title) {
		for (User user : User.getAllUsers()) {
			if (user.getConentPersonal() == null) {
				return false;
			}
			for (Content content : user.getConentPersonal()) {
				if (title.getText().equals(content.getTitle())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Refreshes both the member list in this class, and calls the refresh for the
	 * caller of this method..
	 * 
	 */
	@Override
	public void refresh() {
		list.removeAll();
		getContentPane().remove(list);
		list = new JList<User>(new Vector<User>(group.getUsers()));
		list.setBounds(12, 88, 282, 286);
		getContentPane().add(list);
		getContentPane().repaint();
		refreshable.refresh();
	}
}
