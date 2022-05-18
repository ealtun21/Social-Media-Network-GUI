/*
 * Main JFrame of the Application
 */
package client.frontend;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.backend.User;
import client.frontend.entry.LoginPage;
import client.frontend.postentry.dashboardpanels.Groups;
import client.frontend.postentry.dashboardpanels.Homepage;
import client.frontend.postentry.dashboardpanels.Profile;
import client.frontend.postentry.dashboardpanels.Users;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel profilePanel;
	private JPanel groupsPanel;
	private JPanel usersPanel;
	private JPanel homepagePanel;
	private JPanel profilePicBar;
	private JPanel groupBar;
	private JPanel usersBar;
	private JPanel homepageBar;
	private LoginPage loginPage;

	/**
	 * Create the frame.
	 * 
	 * @param loginPage
	 */
	public Dashboard(User user, LoginPage loginPage) {
		this.loginPage = loginPage;

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1700, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(Colors.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();

		panel.setBackground(Colors.GRAY);
		panel.setBounds(0, 0, 240, 970);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton profilePic = new JButton("");
		profilePic.setFocusPainted(false);
		profilePic.setIcon(user.getProfileImage());
		profilePic.addActionListener(new ActionListener() {
			/*
			 * Swap panels to the profilePic panel
			 */
			public void actionPerformed(ActionEvent e) {
				profilePicBar.setBackground(Colors.BLUE);
				groupBar.setBackground(Colors.DARK_GRAY);
				usersBar.setBackground(Colors.DARK_GRAY);
				homepageBar.setBackground(Colors.DARK_GRAY);

				profilePanel.setVisible(true);
				groupsPanel.setVisible(false);
				usersPanel.setVisible(false);
				homepagePanel.setVisible(false);

				((Profile) profilePanel).refresh();
			}
		});
		profilePic.setBackground(Colors.GRAY);
		profilePic.setBorder(null);
		profilePic.setBorderPainted(false);
		profilePic.setBounds(22, 33, 206, 128);
		panel.add(profilePic);

		JButton homepage = new JButton("");
		homepage.setFocusPainted(false);
		homepage.setIcon(new ImageIcon(new ImageIcon("IMG/Dashboard/home.png").getImage().getScaledInstance(64, 64,
				java.awt.Image.SCALE_SMOOTH)));
		homepage.addActionListener(new ActionListener() {
			/*
			 * Swap panels to the homepage panel
			 */
			public void actionPerformed(ActionEvent e) {
				profilePicBar.setBackground(Colors.DARK_GRAY);
				groupBar.setBackground(Colors.DARK_GRAY);
				usersBar.setBackground(Colors.DARK_GRAY);
				homepageBar.setBackground(Colors.BLUE);

				profilePanel.setVisible(false);
				groupsPanel.setVisible(false);
				usersPanel.setVisible(false);
				homepagePanel.setVisible(true);

				((Homepage) homepagePanel).refresh();
			}
		});
		homepage.setBorderPainted(false);
		homepage.setBorder(null);
		homepage.setBackground(new Color(49, 63, 78));
		homepage.setBounds(22, 271, 206, 104);
		panel.add(homepage);

		JButton logout = new JButton("");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logout(true);
			}
		});
		logout.setFocusPainted(false);
		logout.setIcon(new ImageIcon(new ImageIcon("IMG/Dashboard/logout.png").getImage().getScaledInstance(40, 40,
				java.awt.Image.SCALE_SMOOTH)));
		logout.setBorderPainted(false);
		logout.setBorder(null);
		logout.setBackground(new Color(49, 63, 78));
		logout.setBounds(12, 894, 216, 64);
		panel.add(logout);

		JButton groups = new JButton("");
		groups.addActionListener(new ActionListener() {
			/*
			 * Swap panels to the groups panel
			 */
			public void actionPerformed(ActionEvent e) {
				profilePicBar.setBackground(Colors.DARK_GRAY);
				groupBar.setBackground(Colors.BLUE);
				usersBar.setBackground(Colors.DARK_GRAY);
				homepageBar.setBackground(Colors.DARK_GRAY);

				profilePanel.setVisible(false);
				groupsPanel.setVisible(true);
				usersPanel.setVisible(false);
				homepagePanel.setVisible(false);

				((Groups) groupsPanel).refresh();
			}
		});
		groups.setFocusPainted(false);
		groups.setIcon(new ImageIcon(new ImageIcon("IMG/Dashboard/groups.png").getImage().getScaledInstance(64, 64,
				java.awt.Image.SCALE_SMOOTH)));
		groups.setBorderPainted(false);
		groups.setBorder(null);
		groups.setBackground(new Color(49, 63, 78));
		groups.setBounds(22, 438, 206, 104);
		panel.add(groups);

		JButton users = new JButton("");
		users.addActionListener(new ActionListener() {
			/*
			 * Swap panels to the users panel
			 */
			public void actionPerformed(ActionEvent e) {
				profilePicBar.setBackground(Colors.DARK_GRAY);
				groupBar.setBackground(Colors.DARK_GRAY);
				usersBar.setBackground(Colors.BLUE);
				homepageBar.setBackground(Colors.DARK_GRAY);

				profilePanel.setVisible(false);
				groupsPanel.setVisible(false);
				usersPanel.setVisible(true);
				homepagePanel.setVisible(false);

				((Users) usersPanel).refresh();
			}
		});
		users.setFocusPainted(false);
		users.setIcon(new ImageIcon(new ImageIcon("IMG/Dashboard/users.png").getImage().getScaledInstance(64, 64,
				java.awt.Image.SCALE_SMOOTH)));
		users.setBorderPainted(false);
		users.setBorder(null);
		users.setBackground(new Color(49, 63, 78));
		users.setBounds(22, 601, 206, 104);
		panel.add(users);

		profilePicBar = new JPanel();
		profilePicBar.setBackground(Colors.DARK_GRAY);
		profilePicBar.setBounds(0, 33, 10, 128);
		panel.add(profilePicBar);
		profilePicBar.setLayout(null);

		groupBar = new JPanel();
		groupBar.setBackground(Colors.DARK_GRAY);
		groupBar.setBounds(0, 438, 10, 128);
		panel.add(groupBar);
		groupBar.setLayout(null);

		usersBar = new JPanel();
		usersBar.setBackground(Colors.DARK_GRAY);
		usersBar.setBounds(0, 601, 10, 128);
		panel.add(usersBar);
		usersBar.setLayout(null);

		homepageBar = new JPanel();
		homepageBar.setBackground(Colors.BLUE);
		homepageBar.setBounds(0, 271, 10, 128);
		panel.add(homepageBar);
		homepageBar.setLayout(null);

		JLabel lblHomepage = new JLabel("Homepage");
		lblHomepage.setForeground(Colors.WHITE);
		lblHomepage.setFont(new Font("Dialog", Font.BOLD, 17));
		lblHomepage.setBounds(72, 371, 101, 28);
		panel.add(lblHomepage);

		JLabel lblGroups = new JLabel("Groups");
		lblGroups.setForeground(new Color(204, 199, 209));
		lblGroups.setFont(new Font("Dialog", Font.BOLD, 17));
		lblGroups.setBounds(84, 538, 66, 28);
		panel.add(lblGroups);

		JLabel lblUsers = new JLabel("Users");
		lblUsers.setForeground(new Color(204, 199, 209));
		lblUsers.setFont(new Font("Dialog", Font.BOLD, 17));
		lblUsers.setBounds(95, 701, 52, 28);
		panel.add(lblUsers);

		JLabel nameSurname = new JLabel(user.getName() + " " + user.getSurname());
		nameSurname.setHorizontalTextPosition(SwingConstants.CENTER);
		nameSurname.setHorizontalAlignment(SwingConstants.CENTER);
		nameSurname.setForeground(new Color(204, 199, 209));
		nameSurname.setFont(new Font("Dialog", Font.BOLD, 17));
		nameSurname.setBounds(12, 166, 216, 28);
		panel.add(nameSurname);

		// External Panels
		groupsPanel = new Groups(user);
		usersPanel = new Users(user);
		homepagePanel = new Homepage(user);
		profilePanel = new Profile(user, this, loginPage);

		contentPane.add(groupsPanel);
		contentPane.add(usersPanel);
		contentPane.add(homepagePanel);
		contentPane.add(profilePanel);

	}

	/**
	 * Specifies the different types of logout you can do.
	 * @param showConfirm true for showing confirm, false for no confirmation.
	 */
	public void logout(boolean showConfirm) {
		if (showConfirm) {
			int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Confirm Logout",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				loginPage.setVisible(true);
				this.dispose();
			}
		} else {
			loginPage.setVisible(true);
			this.dispose();
		}

	}
}
