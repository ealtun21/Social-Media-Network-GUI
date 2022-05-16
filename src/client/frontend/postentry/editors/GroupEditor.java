package client.frontend.postentry.editors;

import client.backend.Content;
import client.backend.User;
import client.backend.UserGroup;
import client.frontend.postentry.Colors;
import client.frontend.postentry.Refreshable;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.DefaultListCellRenderer;
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
import javax.swing.ScrollPaneConstants;

public class GroupEditor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JList<User> list;

	/**
	 * Create the panel.
	 * 
	 * @param refreshable
	 * @param homepage
	 * 
	 * @param contentable
	 */
	public GroupEditor(Refreshable refreshable, User user, UserGroup group) {
		// TODO Fix member list.
		
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
		lblEditGroup.setForeground(new Color(204, 199, 209));
		lblEditGroup.setFont(new Font("Dialog", Font.BOLD, 20));
		lblEditGroup.setBounds(12, 12, 281, 37);
		getContentPane().add(lblEditGroup);

		JButton btnDeleteGroup = new JButton("Delete Group");
		btnDeleteGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this group?",
						"Confirm Deleting Group", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					group.dispose(user);
					refreshable.refresh(user);
					dispose();
				}
			}
		});
		btnDeleteGroup.setForeground(Colors.RED.darker());
		btnDeleteGroup.setFont(new Font("Dialog", Font.BOLD, 14));
		btnDeleteGroup.setFocusPainted(false);
		btnDeleteGroup.setBackground(new Color(22, 28, 35));
		btnDeleteGroup.setBounds(181, 386, 130, 29);
		getContentPane().add(btnDeleteGroup);

		list = new JList<User>(new Vector<User>(group.getUsers()));
		list.setBounds(12, 88, 282, 286);
		setVisible(true); 
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(12, 88, 282, 286);
		getContentPane().add(scrollPane);

		JLabel lblMembers = new JLabel("Members");
		lblMembers.setForeground(new Color(204, 199, 209));
		lblMembers.setFont(new Font("Dialog", Font.BOLD, 18));
		lblMembers.setBounds(12, 61, 113, 26);
		getContentPane().add(lblMembers);

		JButton btnRemoveSelected = new JButton("Remove Selected");
		btnRemoveSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (group.isCreator(user)) {
					JOptionPane.showMessageDialog(null, "The creator can't leave the group", "Invalid Leave!", JOptionPane.PLAIN_MESSAGE);
					return;
				}
				group.removeUser(list.getSelectedValue());
				refresh(refreshable, user, group);
			}
		});
		btnRemoveSelected.setForeground(new Color(243, 68, 115));
		btnRemoveSelected.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRemoveSelected.setFocusPainted(false);
		btnRemoveSelected.setBackground(new Color(22, 28, 35));
		btnRemoveSelected.setBounds(12, 386, 158, 29);
		getContentPane().add(btnRemoveSelected);
		setVisible(false);
	}

	/**
	 * 
	 * @param title
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
	 * @param refreshable
	 * @param user
	 * @param group
	 */
	public void refresh(Refreshable refreshable, User user, UserGroup group) {
		list.removeAll();
		getContentPane().remove(list);
		list = new JList<User>(new Vector<User>(group.getUsers()));
		list.setBounds(12, 88, 282, 286);
		getContentPane().add(list);
		getContentPane().repaint();
		refreshable.refresh(user);
	}
}
