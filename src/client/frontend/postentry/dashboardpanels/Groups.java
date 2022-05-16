package client.frontend.postentry.dashboardpanels;

import javax.swing.JPanel;

import client.backend.Content;
import client.backend.User;
import client.backend.UserGroup;
import client.frontend.postentry.Colors;
import client.frontend.postentry.Refreshable;
import client.frontend.postentry.viewers.ContentViewer;
import client.frontend.postentry.viewers.GroupViewer;

import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;


public class Groups extends JPanel implements Refreshable {

	private static final long serialVersionUID = 1L;
	protected JPanel panel;

	/**
	 * Create the panel.
	 * @param user 
	 */
	public Groups(User user) {
		setBackground(Colors.DARK_GRAY);
		setBounds(252, 12, 1436, 947);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 62, 550, 873);
		add(scrollPane);
		panel = new JPanel();
		panel.setSize(397, 795);
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblYourPosts = new JLabel("Groups");
		lblYourPosts.setForeground(new Color(204, 199, 209));
		lblYourPosts.setFont(new Font("Dialog", Font.BOLD, 18));
		lblYourPosts.setBounds(24, 24, 113, 26);
		add(lblYourPosts);
		setVisible(false);
		
	}

	@Override
	public void refresh(User user) {
		panel.removeAll();
		for (UserGroup group : UserGroup.getAllGroups()) {
			GroupViewer viewer = new GroupViewer(this, user, group);
			panel.add(viewer);
			viewer.refresh(user);
		}
		panel.revalidate();
		panel.repaint();
	}
}
