/**
 * A panel inside the Dashboard that is dynamically switched, switching is handled by the dashbaord.
 * The refresh method is called by the dashbaord when the panel is switched in or whenever one of the "creators" calls it.
 */
package client.frontend.postentry.dashboardpanels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import client.backend.Content;
import client.backend.User;
import client.backend.UserGroup;
import client.frontend.Colors;
import client.frontend.Refreshable;
import client.frontend.postentry.viewers.ContentViewer;

public class Homepage extends JPanel implements Refreshable {

	private static final long serialVersionUID = 1L;
	protected JPanel panel;
	private JTextField Search;
	private User user;

	/**
	 * Create the panel.
	 * 
	 * @param user The logged in user.
	 */
	public Homepage(User user) {
		this.user = user;
		setBackground(Colors.DARK_GRAY);
		setBounds(252, 12, 1436, 947);
		setLayout(null);
		setVisible(true);

		Search = new JTextField();
		Search.addActionListener(new ActionListener() {
			/**
			 * When enter is pressed. The method searches for non-matching elements inside
			 * the panel and removes them. The remaining elements are matching, refreshes to
			 * make sure that the panel contains all elements to avoid mistakes.
			 */
			public void actionPerformed(ActionEvent e) {
				refresh();
				for (Component content : panel.getComponents()) {
					if (content instanceof ContentViewer) {
						if (!((ContentViewer) (content)).getTitle().contains(Search.getText())) {
							panel.remove(content);
						}
					}
				}
				panel.revalidate();
				panel.repaint();
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(207, 136, 1093, 799);
		add(scrollPane);
		panel = new JPanel();
		panel.setSize(397, 795);
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setVisible(true);

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

		// Refresh on first shown
		refresh();
	}

	/**
	 * Refreshes the homapage panel.
	 * 
	 */
	@Override
	public void refresh() {
		TreeSet<Content> shownContent = new TreeSet<>();
		panel.removeAll();
		shownContent.clear();

		shownContent.addAll(user.getConentPersonal());

		for (UserGroup group : user.getFollowingGroups()) {
			shownContent.addAll(group.getConent());
		}
		for (User fUser : user.getFollowingUsers()) {
			shownContent.addAll(fUser.getConentPersonal());
		}
		for (Content content : shownContent) {
			panel.add(new ContentViewer(this, user, content));
		}

		panel.revalidate();
		panel.repaint();
	}
}
