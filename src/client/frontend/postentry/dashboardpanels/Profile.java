/**
 * A panel inside the Dashboard that is dynamically switched, switching is handled by the dashbaord.
 * The refresh method is called by the dashbaord when the panel is switched in or whenever one of the "creators" calls it.
 */
package client.frontend.postentry.dashboardpanels;

import client.backend.Content;
import client.backend.User;
import client.backend.UserGroup;
import client.frontend.Colors;
import client.frontend.Dashboard;
import client.frontend.Refreshable;
import client.frontend.entry.LoginPage;
import client.frontend.postentry.creators.GroupCreator;
import client.frontend.postentry.creators.UserContentCreator;
import client.frontend.postentry.editors.AccountEditor;
import client.frontend.postentry.viewers.ContentViewer;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import java.util.Vector;

public class Profile extends JPanel implements Refreshable {

	private static final long serialVersionUID = 1L;
	protected JPanel panel;
	private JTextField Search;
	private final LoginPage loginpage;
	private JList<User> listSugUsers;
	private JList<UserGroup> listSugGroups;
	private JScrollPane scrollPaneSugGroups;
	private JScrollPane scrollPaneSugUsers;
	private User user;

	/**
	 * Create the panel.
	 * 
	 * @param user      The logged in user.
	 * @param dashboard The dashboard. Needed in order to logout when deleting your
	 *                  own account.
	 * @param loginpage The login page. Needed in order to pass to the account
	 *                  editor.
	 */
	public Profile(User user, Dashboard dashboard, LoginPage loginpage) {
		this.user = user;
		this.loginpage = loginpage;

		setBackground(Colors.DARK_GRAY);
		setBounds(252, 12, 1436, 947);
		setLayout(null);
		setVisible(false);

		JButton btnCreateContent = new JButton(
				"<html>\n<p>N</p>\n<p>e</p>\n<p>w</p>\n<p>&nbsp;</p>\n<p>C</p>\n<p>o</p>\n<p>n</p>\n<p>t</p>\n<p>e</p>\n<p>n</p>\n<p>t</p>\n </html>");
		btnCreateContent.addActionListener(new ActionListener() {
			/*
			 * Starts the content maker.
			 */
			public void actionPerformed(ActionEvent e) {
				startContentMaker();
			}
		});
		btnCreateContent.setForeground(Colors.yellow);
		btnCreateContent.setFont(new Font("Dialog", Font.BOLD, 17));
		btnCreateContent.setFocusPainted(false);
		btnCreateContent.setBackground(new Color(22, 28, 35));
		btnCreateContent.setBounds(362, 139, 56, 285);
		add(btnCreateContent);

		JLabel lblYourPosts = new JLabel("Your posts");
		lblYourPosts.setFont(new Font("Dialog", Font.BOLD, 18));
		lblYourPosts.setForeground(Colors.WHITE);
		lblYourPosts.setBounds(429, 105, 113, 26);
		add(lblYourPosts);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(430, 139, 783, 796);
		add(scrollPane);
		panel = new JPanel();
		panel.setSize(397, 795);
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setVisible(true);

		JButton btnCreateGroup = new JButton("Create Group");
		btnCreateGroup.addActionListener(new ActionListener() {
			/*
			 * Starts the group creator.
			 */
			public void actionPerformed(ActionEvent e) {
				startGroupCreator();
			}
		});
		btnCreateGroup.setForeground(Colors.magenta);
		btnCreateGroup.setFont(new Font("Dialog", Font.BOLD, 17));
		btnCreateGroup.setFocusPainted(false);
		btnCreateGroup.setBackground(new Color(22, 28, 35));
		btnCreateGroup.setBounds(1225, 139, 180, 45);

		// Only adds the create group button if the user is premium.
		if (user.isPremium()) {
			add(btnCreateGroup);
		}

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

		Search.setBorder(null);
		Search.setForeground(Colors.WHITE);
		Search.setFont(new Font("Dialog", Font.PLAIN, 20));
		Search.setSelectedTextColor(Colors.LIGHT_GRAY);
		Search.setBackground(Colors.GRAY);
		Search.setBounds(431, 45, 782, 46);
		add(Search);
		Search.setColumns(10);

		JLabel search = new JLabel("");
		search.setIcon(new ImageIcon("IMG/Dashboard/search.png"));
		search.setOpaque(false);
		search.setBorder(null);
		search.setBackground(new Color(49, 63, 78));
		search.setBounds(355, 38, 64, 64);
		add(search);

		JButton btnDeleteAccont = new JButton("Delete Account");
		btnDeleteAccont.addActionListener(new ActionListener() {
			/**
			 * Starts a JOptionPane that asks if you really want to delete the account, yes
			 * is selected, account is deleted, then user is logged out.
			 */
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this account?",
						"Confirm Deleting Account", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					user.dispose();
					dashboard.logout(false);
				}
			}
		});
		btnDeleteAccont.setForeground(Colors.RED.darker());
		btnDeleteAccont.setFont(new Font("Dialog", Font.BOLD, 17));
		btnDeleteAccont.setFocusPainted(false);
		btnDeleteAccont.setBackground(new Color(22, 28, 35));
		btnDeleteAccont.setBounds(1244, 890, 180, 45);
		add(btnDeleteAccont);

		JButton btnEditAccount = new JButton("Edit Account");
		btnEditAccount.addActionListener(new ActionListener() {
			/**
			 * Starts the account editor panel.
			 */
			public void actionPerformed(ActionEvent e) {
				AccountEditor edit = new AccountEditor(user, dashboard, loginpage);
				edit.setVisible(true);
			}
		});
		btnEditAccount.setForeground(new Color(235, 207, 71));
		btnEditAccount.setFont(new Font("Dialog", Font.BOLD, 17));
		btnEditAccount.setFocusPainted(false);
		btnEditAccount.setBackground(new Color(22, 28, 35));
		btnEditAccount.setBounds(1244, 832, 180, 45);
		add(btnEditAccount);

		JLabel lblAccountType = new JLabel("Account type:");
		lblAccountType.setForeground(new Color(204, 199, 209));
		lblAccountType.setFont(new Font("Dialog", Font.BOLD, 18));
		lblAccountType.setBounds(1137, 105, 144, 26);
		add(lblAccountType);

		JLabel lblisPremium = new JLabel(user.isPremium() ? "Premium" : "Standard");
		lblisPremium.setForeground(new Color(204, 199, 209));
		lblisPremium.setFont(new Font("Dialog", Font.BOLD, 18));
		lblisPremium.setBounds(1280, 105, 144, 26);
		add(lblisPremium);

		JLabel lblSugestedUsers = new JLabel("Sugested Users");
		lblSugestedUsers.setForeground(new Color(204, 199, 209));
		lblSugestedUsers.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSugestedUsers.setBounds(31, 105, 163, 26);
		add(lblSugestedUsers);

		JLabel lblSugestedGroups = new JLabel("Sugested Groups");
		lblSugestedGroups.setForeground(new Color(204, 199, 209));
		lblSugestedGroups.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSugestedGroups.setBounds(31, 455, 163, 26);
		add(lblSugestedGroups);

		scrollPaneSugUsers = new JScrollPane((Component) null);
		scrollPaneSugUsers.setBounds(25, 138, 282, 286);
		add(scrollPaneSugUsers);

		listSugUsers = new JList<User>(new Vector<User>(user.getSugUsers()));
		scrollPaneSugUsers.setViewportView(listSugUsers);

		scrollPaneSugGroups = new JScrollPane((Component) null);
		scrollPaneSugGroups.setBounds(25, 493, 282, 313);
		add(scrollPaneSugGroups);

		listSugGroups = new JList<UserGroup>(new Vector<UserGroup>(user.getSugGroups()));
		scrollPaneSugGroups.setViewportView(listSugGroups);

	}

	/**
	 * Starts the GroupCreator which will create a group, and also refresh this
	 * page.
	 * 
	 */
	protected void startGroupCreator() {
		GroupCreator frame = new GroupCreator(this, user);
		frame.setVisible(true);
	}

	/**
	 * Refreshes the panel inside the profile page
	 * 
	 */
	@Override
	public void refresh() {
		panel.removeAll();
		for (Content content : user.getConentPersonal()) {
			panel.add(new ContentViewer(this, user, content));
		}
		panel.revalidate();
		panel.repaint();

		listSugUsers = new JList<User>(new Vector<User>(user.getSugUsers()));
		listSugGroups = new JList<UserGroup>(new Vector<UserGroup>(user.getSugGroups()));

		scrollPaneSugGroups.setViewportView(listSugGroups);
		scrollPaneSugUsers.setViewportView(listSugUsers);

	}

	/**
	 * Starts the UserContentCreator which will create a content, and also refresh
	 * this page.
	 */
	public void startContentMaker() {
		UserContentCreator frame = new UserContentCreator(this, user);
		frame.setVisible(true);
	}

}
