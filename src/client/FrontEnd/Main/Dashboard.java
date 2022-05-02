package client.FrontEnd.Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.BackEnd.Colors;
import client.BackEnd.User;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public Dashboard(User user) {
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
			}
		});
		profilePic.setBackground(Colors.GRAY);
		profilePic.setBorder(null);
		profilePic.setBorderPainted(false);
		profilePic.setBounds(12, 33, 216, 128);
		panel.add(profilePic);
		
		JButton homepage = new JButton("");
		homepage.setFocusPainted(false);
		homepage.setIcon(new ImageIcon(new ImageIcon("IMG/Dashboard/home.png").getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)));
		homepage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		homepage.setBorderPainted(false);
		homepage.setBorder(null);
		homepage.setBackground(new Color(49, 63, 78));
		homepage.setBounds(12, 275, 216, 128);
		panel.add(homepage);
		
		JButton logout = new JButton("");
		logout.setFocusPainted(false);
		logout.setIcon(new ImageIcon(new ImageIcon("IMG/Dashboard/logout.png").getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		logout.setBorderPainted(false);
		logout.setBorder(null);
		logout.setBackground(new Color(49, 63, 78));
		logout.setBounds(12, 894, 216, 64);
		panel.add(logout);
		
		JButton groups = new JButton("");
		groups.setFocusPainted(false);
		groups.setIcon(new ImageIcon(new ImageIcon("IMG/Dashboard/groups.png").getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)));
		groups.setBorderPainted(false);
		groups.setBorder(null);
		groups.setBackground(new Color(49, 63, 78));
		groups.setBounds(12, 438, 216, 128);
		panel.add(groups);
		
		JButton users = new JButton("");
		users.setFocusPainted(false);
		users.setIcon(new ImageIcon(new ImageIcon("IMG/Dashboard/users.png").getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)));
		users.setBorderPainted(false);
		users.setBorder(null);
		users.setBackground(new Color(49, 63, 78));
		users.setBounds(12, 601, 216, 128);
		panel.add(users);
	}
}
