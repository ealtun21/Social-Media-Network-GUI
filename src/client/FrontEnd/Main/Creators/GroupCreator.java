package client.FrontEnd.Main.Creators;

import client.BackEnd.Colors;
import client.BackEnd.User;
import client.BackEnd.UserGroup;
import client.FrontEnd.Main.DashboardPanels.Profile;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class GroupCreator extends JFrame {
	
	// TODO Add icons.
	
	private static final long serialVersionUID = 1L;

	private User creator;
	private JTextField groupTitleField;
	private JTextField hobbies;
	private JTextField location;

	public GroupCreator(Profile profile, User creator) {
		setTitle("Create Group");
		setSize(new Dimension(400, 320));
		setResizable(false);
		getContentPane().setBackground(Colors.DARK_GRAY);
		this.creator = creator;
		getContentPane().setLayout(null);

		groupTitleField = new JTextField();
		groupTitleField.setForeground(new Color(204, 199, 209));
		groupTitleField.setColumns(10);
		groupTitleField.setCaretColor(new Color(204, 199, 209));
		groupTitleField.setBorder(null);
		groupTitleField.setBackground(new Color(49, 63, 78));
		groupTitleField.setBounds(79, 84, 264, 23);
		getContentPane().add(groupTitleField);

		JLabel lblGroupTitle = new JLabel("Group Title");
		lblGroupTitle.setForeground(new Color(204, 199, 209));
		lblGroupTitle.setBounds(79, 61, 88, 23);
		getContentPane().add(lblGroupTitle);

		JLabel lblCreateGroup = new JLabel("Create Group");
		lblCreateGroup.setForeground(new Color(204, 199, 209));
		lblCreateGroup.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCreateGroup.setBounds(22, 12, 159, 37);
		getContentPane().add(lblCreateGroup);

		JLabel lblGroupHobbies = new JLabel("Group Hobbies");
		lblGroupHobbies.setForeground(new Color(204, 199, 209));
		lblGroupHobbies.setBounds(79, 119, 114, 23);
		getContentPane().add(lblGroupHobbies);

		hobbies = new JTextField();
		hobbies.setForeground(new Color(204, 199, 209));
		hobbies.setColumns(10);
		hobbies.setCaretColor(new Color(204, 199, 209));
		hobbies.setBorder(null);
		hobbies.setBackground(new Color(49, 63, 78));
		hobbies.setBounds(79, 142, 264, 23);
		getContentPane().add(hobbies);

		JLabel lblGroupLocation = new JLabel("Group Location");
		lblGroupLocation.setForeground(new Color(204, 199, 209));
		lblGroupLocation.setBounds(79, 177, 114, 23);
		getContentPane().add(lblGroupLocation);

		location = new JTextField();
		location.setForeground(new Color(204, 199, 209));
		location.setColumns(10);
		location.setCaretColor(new Color(204, 199, 209));
		location.setBorder(null);
		location.setBackground(new Color(49, 63, 78));
		location.setBounds(79, 200, 264, 23);
		getContentPane().add(location);

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!creator.isPremium()) {
					JOptionPane.showMessageDialog(null, "Only premium users can create groups!", "Not Premium",
							JOptionPane.PLAIN_MESSAGE);
					dispose();
				} else {
					if (groupTitleField.getText().length() <= 0) {
						JOptionPane.showMessageDialog(null, "Group must have a name!", "No name",
								JOptionPane.PLAIN_MESSAGE);
					} else if (hobbies.getText().length() <= 0) {
						JOptionPane.showMessageDialog(null, "Group must have hobbies!", "No hobbies",
								JOptionPane.PLAIN_MESSAGE);
					} else if (location.getText().length() <= 0) {
						JOptionPane.showMessageDialog(null, "Group must have a location!", "No location",
								JOptionPane.PLAIN_MESSAGE);
					} else {
						UserGroup group =new UserGroup(creator, groupTitleField.getText(), location.getText(), new ArrayList<String>(
								Arrays.asList(hobbies.getText().replaceAll("\\s+", "").split(","))));
						group.addMember(creator); // Adds creator to the group, creator shouldn't leave group.
						profile.refresh(creator);
						dispose();
					}
				}
			}
		});
		btnCreate.setForeground(new Color(107, 255, 86));
		btnCreate.setFont(new Font("Dialog", Font.BOLD, 14));
		btnCreate.setFocusPainted(false);
		btnCreate.setBackground(new Color(22, 28, 35));
		btnCreate.setBounds(37, 250, 112, 29);
		getContentPane().add(btnCreate);

		JButton btnDiscard = new JButton("Discard");
		btnDiscard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnDiscard.setForeground(new Color(243, 68, 115));
		btnDiscard.setFont(new Font("Dialog", Font.BOLD, 14));
		btnDiscard.setFocusPainted(false);
		btnDiscard.setBackground(new Color(22, 28, 35));
		btnDiscard.setBounds(160, 250, 112, 29);
		getContentPane().add(btnDiscard);
	}
}