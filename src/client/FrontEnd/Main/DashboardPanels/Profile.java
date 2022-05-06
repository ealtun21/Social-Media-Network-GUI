package client.FrontEnd.Main.DashboardPanels;

import client.BackEnd.Colors;
import client.BackEnd.Content;
import client.BackEnd.Refreshable;
import client.BackEnd.User;
import client.BackEnd.UserGroup;
import client.FrontEnd.Main.AccountEditor;
import client.FrontEnd.Main.ContentMaker;
import client.FrontEnd.Main.ContentViewer;
import client.FrontEnd.Main.Dashboard;
import client.FrontEnd.Main.GroupCreator;
import client.FrontEnd.Startup.LoginPage;

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
import javax.swing.table.TableModel;
import javax.swing.JTable;

public class Profile extends JPanel implements Refreshable {

	private static final long serialVersionUID = 1L;
	protected JPanel panel;
	private JTextField Search;
	private LoginPage loginpage;
	

	/**
	 * Create the panel.
	 */
	public Profile(User user, Dashboard dashboard, LoginPage loginpage) {
		this.loginpage = loginpage;

		setBackground(Colors.DARK_GRAY);
		setBounds(252, 12, 1436, 947);
		setLayout(null);
		setVisible(false);

		JButton btnCreateContent = new JButton("Create content");
		btnCreateContent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startContentMaker(user);
			}
		});
		btnCreateContent.setForeground(Colors.yellow);
		btnCreateContent.setFont(new Font("Dialog", Font.BOLD, 17));
		btnCreateContent.setFocusPainted(false);
		btnCreateContent.setBackground(new Color(22, 28, 35));
		btnCreateContent.setBounds(27, 28, 180, 45);
		add(btnCreateContent);

		JLabel lblYourPosts = new JLabel("Your posts");
		lblYourPosts.setFont(new Font("Dialog", Font.BOLD, 18));
		lblYourPosts.setForeground(Colors.WHITE);
		lblYourPosts.setBounds(26, 105, 113, 26);
		add(lblYourPosts);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 139, 547, 796);
		add(scrollPane);
		panel = new JPanel();
		panel.setSize(397, 795);
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JButton btnCreateGroup = new JButton("Create Group");
		btnCreateGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGroupCreatorMaker(user);
			}
		});
		btnCreateGroup.setForeground(Colors.magenta);
		btnCreateGroup.setFont(new Font("Dialog", Font.BOLD, 17));
		btnCreateGroup.setFocusPainted(false);
		btnCreateGroup.setBackground(new Color(22, 28, 35));
		btnCreateGroup.setBounds(1233, 96, 180, 45);
		if (user.isPremium()) {
			add(btnCreateGroup);
		}
		panel.setVisible(true);

		Search = new JTextField();
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh(user);
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

		JButton btnCreateContent_1 = new JButton("Delete Account");
		btnCreateContent_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this account?",
						"Confirm Deleting Account", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					user.dispose();
					dashboard.logout(false);
				}
			}
		});
		btnCreateContent_1.setForeground(Colors.RED.darker());
		btnCreateContent_1.setFont(new Font("Dialog", Font.BOLD, 17));
		btnCreateContent_1.setFocusPainted(false);
		btnCreateContent_1.setBackground(new Color(22, 28, 35));
		btnCreateContent_1.setBounds(1244, 890, 180, 45);
		add(btnCreateContent_1);

		JButton btnEditAccount = new JButton("Edit Account");
		btnEditAccount.addActionListener(new ActionListener() {
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
		lblAccountType.setBounds(1119, 56, 144, 26);
		add(lblAccountType);

		JLabel lblisPremium = new JLabel(user.isPremium() ? "Premium" : "Standard");
		lblisPremium.setForeground(new Color(204, 199, 209));
		lblisPremium.setFont(new Font("Dialog", Font.BOLD, 18));
		lblisPremium.setBounds(1255, 56, 144, 26);
		add(lblisPremium);


	}

	protected void startGroupCreatorMaker(User user) {
		GroupCreator frame = new GroupCreator(this, user);
		frame.setVisible(true);
	}

	/**
	 * Refreshes the panel inside the home page
	 * 
	 * @param user
	 */
	public void refresh(User user) {
		panel.removeAll();
		for (Content content : user.getConentPersonal()) {
			panel.add(new ContentViewer(this, user, content));
		}
		panel.revalidate();
		panel.repaint();
	}

	/**
	 * Creates new content then, refreshes the panel inside the home page
	 * 
	 * @param user
	 */
	public void startContentMaker(User user) {
		ContentMaker frame = new ContentMaker(this, user);
		frame.setVisible(true);
	}

}
