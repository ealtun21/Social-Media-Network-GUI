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
		profilePic.setIcon(user.getProfileImage());
		profilePic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		profilePic.setBackground(Colors.GRAY);
		profilePic.setBorder(null);
		profilePic.setBorderPainted(false);
		profilePic.setBounds(63, 33, 128, 128);
		panel.add(profilePic);
		
		JButton homepage = new JButton("");
		homepage.setIcon(new ImageIcon(new ImageIcon("IMG/Dashboard/home.png").getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)));
		homepage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		homepage.setBorderPainted(false);
		homepage.setBorder(null);
		homepage.setBackground(new Color(49, 63, 78));
		homepage.setBounds(63, 275, 128, 128);
		panel.add(homepage);
		
		JButton logout = new JButton("");
		logout.setIcon(new ImageIcon(new ImageIcon("IMG/Dashboard/logout.png").getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		logout.setBorderPainted(false);
		logout.setBorder(null);
		logout.setBackground(new Color(49, 63, 78));
		logout.setBounds(95, 894, 64, 64);
		panel.add(logout);
		
		JButton groups = new JButton("");
		groups.setIcon(new ImageIcon(new ImageIcon("IMG/Dashboard/groups.png").getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)));
		groups.setBorderPainted(false);
		groups.setBorder(null);
		groups.setBackground(new Color(49, 63, 78));
		groups.setBounds(63, 438, 128, 128);
		panel.add(groups);
		
		JButton users = new JButton("");
		users.setIcon(new ImageIcon(new ImageIcon("IMG/Dashboard/users.png").getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)));
		users.setBorderPainted(false);
		users.setBorder(null);
		users.setBackground(new Color(49, 63, 78));
		users.setBounds(63, 601, 128, 128);
		panel.add(users);
	}
}
