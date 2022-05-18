/**
 * A panel inside the Dashboard that is dynamically switched, switching is handled by the dashbaord.
 * The refresh method is called by the dashbaord when the panel is switched in or whenever one of the "creators" calls it.
 */
package client.frontend.postentry.dashboardpanels;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import client.backend.User;
import client.frontend.Colors;
import client.frontend.Refreshable;
import client.frontend.postentry.viewers.UserViewer;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Users extends JPanel implements Refreshable {

	private static final long serialVersionUID = 1L;
	private JTextField Search;
	private JPanel paneUsers;
	private User user;

	/**
	 * Create the panel.
	 * 
	 * @param user The logged in user.
	 */
	public Users(User user) {
		this.user = user;
		setBackground(Colors.DARK_GRAY);
		setBounds(252, 12, 1436, 947);
		setLayout(null);
		setVisible(false);

		Search = new JTextField();
		Search.addActionListener(new ActionListener() {
			/**
			 * When enter is pressed. The method searches for non-matching elements inside
			 * the panel and removes them. The remaining elements are matching, refreshes to
			 * make sure that the panel contains all elements to avoid mistakes.
			 */
			public void actionPerformed(ActionEvent e) {
				refresh();
				for (Component user : paneUsers.getComponents()) {
					if (user instanceof UserViewer) {
						if (!((UserViewer) (user)).getTitle().contains(Search.getText())) {
							paneUsers.remove(user);
						}
					}
				}
				paneUsers.revalidate();
				paneUsers.repaint();
			}
		});
		Search.setBorder(null);
		Search.setForeground(Colors.WHITE);
		Search.setFont(new Font("Dialog", Font.PLAIN, 20));
		Search.setSelectedTextColor(Colors.LIGHT_GRAY);
		Search.setBackground(Colors.GRAY);
		Search.setBounds(431, 45, 596, 46);
		add(Search);
		Search.setColumns(10);

		JLabel search = new JLabel("");
		search.setIcon(new ImageIcon("IMG/Dashboard/search.png"));
		search.setOpaque(false);
		search.setBorder(null);
		search.setBackground(new Color(49, 63, 78));
		search.setBounds(355, 38, 64, 64);
		add(search);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 124, 1424, 811);
		add(scrollPane);
		paneUsers = new JPanel();
		paneUsers.setBounds(365, 132, 736, 769);
		scrollPane.setViewportView(paneUsers);
		paneUsers.setLayout(new BoxLayout(paneUsers, BoxLayout.Y_AXIS));

		refresh();
	}

	/**
	 * Refresh the panel.
	 * 
	 */
	@Override
	public void refresh() {
		paneUsers.removeAll();
		for (User other : User.getAllUsers()) {
			if (other.equals(user)) {
				continue; // Skipping the logged in user itself
			}
			paneUsers.add(new UserViewer(this, user, other));
		}
		paneUsers.revalidate();
		paneUsers.repaint();
	}
	
}
