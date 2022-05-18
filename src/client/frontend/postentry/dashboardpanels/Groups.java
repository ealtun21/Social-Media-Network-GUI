/**
 * A panel inside the Dashboard that is dynamically switched, switching is handled by the dashbaord.
 * The refresh method is called by the dashbaord when the panel is switched in or whenever one of the "creators" calls it.
 */
package client.frontend.postentry.dashboardpanels;

import javax.swing.JPanel;
import client.backend.User;
import client.backend.UserGroup;
import client.frontend.Colors;
import client.frontend.Refreshable;
import client.frontend.postentry.viewers.GroupViewer;

import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;

public class Groups extends JPanel implements Refreshable {

	private static final long serialVersionUID = 1L;
	protected JPanel panel;
	private User user;

	/**
	 * Create the panel.
	 * 
	 * @param user The logged in user.
	 */
	public Groups(User user) {
		this.user = user;
		setBackground(Colors.DARK_GRAY);
		setBounds(252, 12, 1436, 947);
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(175, 62, 1028, 873);
		add(scrollPane);
		panel = new JPanel();
		panel.setSize(397, 795);
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JLabel lblYourPosts = new JLabel("Groups");
		lblYourPosts.setForeground(new Color(204, 199, 209));
		lblYourPosts.setFont(new Font("Dialog", Font.BOLD, 18));
		lblYourPosts.setBounds(639, 24, 113, 26);
		add(lblYourPosts);
		setVisible(false);

	}

	/**
	 * This method refreshes this panel.
	 */
	@Override
	public void refresh() {
		panel.removeAll();
		for (UserGroup group : UserGroup.getAllGroups()) {
			GroupViewer viewer = new GroupViewer(this, user, group); // The user is needed in order to determine the if
																		// the current user is the creator of the group
																		// or any content.
			panel.add(viewer);
			panel.add(new JSeparator());
			viewer.refresh();
		}
		panel.revalidate();
		panel.repaint();
	}
}
