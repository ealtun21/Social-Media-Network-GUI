package client.FrontEnd.Main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.BackEnd.Colors;
import client.BackEnd.User;
import client.FrontEnd.Main.DashboardPanels.Groups;
import client.FrontEnd.Main.DashboardPanels.Homepage;
import client.FrontEnd.Main.DashboardPanels.Profile;
import client.FrontEnd.Main.DashboardPanels.Users;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

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

	/**
	 * Create the frame.
	 */
	public Dashboard(User user) {
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
			public void actionPerformed(ActionEvent e) {
				profilePicBar.setBackground(Colors.BLUE);
				groupBar.setBackground(Colors.DARK_GRAY);
				usersBar.setBackground(Colors.DARK_GRAY);
				homepageBar.setBackground(Colors.DARK_GRAY);
				
				profilePanel.setVisible(true);
				groupsPanel.setVisible(false);
				usersPanel.setVisible(false);
				homepagePanel.setVisible(false);
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
			public void actionPerformed(ActionEvent e) {
				profilePicBar.setBackground(Colors.DARK_GRAY);
				groupBar.setBackground(Colors.DARK_GRAY);
				usersBar.setBackground(Colors.DARK_GRAY);
				homepageBar.setBackground(Colors.BLUE);
				
				profilePanel.setVisible(false);
				groupsPanel.setVisible(false);
				usersPanel.setVisible(false);
				homepagePanel.setVisible(true);
			}
		});
		homepage.setBorderPainted(false);
		homepage.setBorder(null);
		homepage.setBackground(new Color(49, 63, 78));
		homepage.setBounds(22, 271, 206, 128);
		panel.add(homepage);

		JButton logout = new JButton("");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Confirm Logout",
						JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
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
			public void actionPerformed(ActionEvent e) {
				profilePicBar.setBackground(Colors.DARK_GRAY);
				groupBar.setBackground(Colors.BLUE);
				usersBar.setBackground(Colors.DARK_GRAY);
				homepageBar.setBackground(Colors.DARK_GRAY);
				
				profilePanel.setVisible(false);
				groupsPanel.setVisible(true);
				usersPanel.setVisible(false);
				homepagePanel.setVisible(false);
			}
		});
		groups.setFocusPainted(false);
		groups.setIcon(new ImageIcon(new ImageIcon("IMG/Dashboard/groups.png").getImage().getScaledInstance(64, 64,
				java.awt.Image.SCALE_SMOOTH)));
		groups.setBorderPainted(false);
		groups.setBorder(null);
		groups.setBackground(new Color(49, 63, 78));
		groups.setBounds(22, 438, 206, 128);
		panel.add(groups);

		JButton users = new JButton("");
		users.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profilePicBar.setBackground(Colors.DARK_GRAY);
				groupBar.setBackground(Colors.DARK_GRAY);
				usersBar.setBackground(Colors.BLUE);
				homepageBar.setBackground(Colors.DARK_GRAY);
				
				profilePanel.setVisible(false);
				groupsPanel.setVisible(false);
				usersPanel.setVisible(true);
				homepagePanel.setVisible(false);
			}
		});
		users.setFocusPainted(false);
		users.setIcon(new ImageIcon(new ImageIcon("IMG/Dashboard/users.png").getImage().getScaledInstance(64, 64,
				java.awt.Image.SCALE_SMOOTH)));
		users.setBorderPainted(false);
		users.setBorder(null);
		users.setBackground(new Color(49, 63, 78));
		users.setBounds(22, 601, 206, 128);
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
		
		// External Panels
		groupsPanel = new Groups();
		usersPanel = new Users();
		homepagePanel = new Homepage();
		profilePanel = new Profile();

		contentPane.add(groupsPanel);
		contentPane.add(usersPanel);
		contentPane.add(homepagePanel);
		contentPane.add(profilePanel);

	}
}
