package client.FrontEnd.Main;

import javax.swing.JPanel;
import client.BackEnd.Colors;
import client.BackEnd.Content;
import client.BackEnd.Refreshable;
import client.BackEnd.User;
import client.BackEnd.UserGroup;

import javax.swing.JLabel;
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

public class GroupViewer extends JPanel implements Refreshable{

	private static final long serialVersionUID = 1L;

	private String title;
	private JPanel contentPanel;
	

	/**
	 * Create the panel.
	 */
	public GroupViewer(Refreshable refresh, User user, UserGroup group) {
		title = group.getTitle();

		setPreferredSize(new Dimension(401, 591));
		setBorder(null);
		setVisible(true);
		setBackground(Colors.DARK_GRAY);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		add(scrollPane);

		JTextPane textPane = new JTextPane();
		textPane.setMaximumSize(new Dimension(2147483647, 30));
		textPane.setPreferredSize(new Dimension(7, 15));
		textPane.setFont(new Font("Dialog", Font.PLAIN, 14));
		textPane.setCaretColor(Colors.WHITE);
		textPane.setForeground(Colors.WHITE);
		textPane.setBackground(Colors.GRAY);
		textPane.setText(group.getHobbies().toString());
		scrollPane.setViewportView(textPane);

		JLabel lbltitle = new JLabel(
				"Creator: " + group.getCreator() + " Title: " + title + " @: " + group.getLocation());
		scrollPane.setColumnHeaderView(lbltitle);
		lbltitle.setForeground(Colors.WHITE);
		lbltitle.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JButton btnCreateContent = new JButton("Create content");
		btnCreateContent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startContentMaker(user);
			}
		});
		btnCreateContent.setForeground(new Color(235, 207, 71));
		btnCreateContent.setFont(new Font("Dialog", Font.BOLD, 17));
		btnCreateContent.setFocusPainted(false);
		btnCreateContent.setBackground(new Color(22, 28, 35));
		add(btnCreateContent);
		
		JScrollPane scrollPanePanel = new JScrollPane();
		scrollPane.setBounds(27, 139, 547, 796);
		add(scrollPane);
		contentPanel = new JPanel();
		contentPanel.setBounds(28, 139, 397, 795);
		scrollPane.setViewportView(contentPanel);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

		JButton btnEdit = new JButton("<html>E<p>D</p><p>I</p><p>T</p></html>\n");
		btnEdit.setVerticalTextPosition(SwingConstants.TOP);
		btnEdit.setVerticalAlignment(SwingConstants.TOP);
		btnEdit.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnEdit.setHorizontalAlignment(SwingConstants.RIGHT);
		btnEdit.setPreferredSize(new Dimension(27, 37));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGroupEditor(user, group);
			}
		});
		btnEdit.setForeground(new Color(235, 161, 76));
		btnEdit.setFont(new Font("Dialog", Font.BOLD, 15));
		btnEdit.setFocusPainted(false);
		btnEdit.setBackground(new Color(22, 28, 35));

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
		GroupContentMaker frame = new GroupContentMaker(this, user);
		frame.setVisible(true);
	}

	/**
	 * @param contentable
	 * @param group
	 */
	public void startGroupEditor(User contentable, UserGroup group) {
		GroupEditor frame = new GroupEditor(this, contentable, group);
		frame.setVisible(true);
	}

	@Override
	public void refresh(User user) {
		// TODO Auto-generated method stub
		
	}


}
