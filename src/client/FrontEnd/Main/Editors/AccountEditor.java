package client.FrontEnd.Main.Editors;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileSystemView;
import client.BackEnd.Colors;
import client.BackEnd.User;
import client.FrontEnd.Main.Dashboard;
import client.FrontEnd.Startup.LoginPage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;

public class AccountEditor extends JFrame{

	// TODO FIX LINUX FONT RENDERING

	private static final long serialVersionUID = 1L;
	
	private JFrame frmEdit;
	private JPasswordField cnfPasswordField;

	// TODO IN WINDOWS
	private static final String FONT = "Arial";
	private JTextField emailField;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField ageField;
	private JPasswordField passwordField;
	private JLabel profilePic;
	private JPasswordField newPasswordField;
	private LoginPage loginpage;

	/**
	 *
	 * Initialize the contents of the frame.
	 */
	public AccountEditor(User user, Dashboard dashbaord, LoginPage loginpage) {
		this.loginpage = loginpage;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEdit = new JFrame();
		frmEdit.getContentPane().setFocusTraversalKeysEnabled(false);
		frmEdit.setResizable(false);
		frmEdit.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frmEdit.setTitle("Edit Account");
		frmEdit.setBackground(Colors.DARK_GRAY);
		frmEdit.getContentPane().setBackground(Colors.DARK_GRAY);
		frmEdit.setBounds(100, 100, 440, 700);
		frmEdit.getContentPane().setLayout(null);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFocusPainted(false);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEdit.dispose();
			}
		});
		btnCancel.setForeground(Colors.RED);
		btnCancel.setFont(new Font(FONT, Font.BOLD, 16));
		btnCancel.setBackground(Colors.BLACK);
		btnCancel.setBounds(163, 593, 142, 29);
		frmEdit.getContentPane().add(btnCancel);

		JButton btnEdit = new JButton("Edit");
		btnEdit.setFocusPainted(false);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit(user, dashbaord);
			}
		});
		btnEdit.setForeground(Colors.GREEN);
		btnEdit.setFont(new Font(FONT, Font.BOLD, 16));
		btnEdit.setBackground(Colors.BLACK);
		btnEdit.setBounds(163, 552, 142, 29);
		frmEdit.getContentPane().add(btnEdit);

		JLabel lblPassword = new JLabel("Confirm Old Password");
		lblPassword.setForeground(new Color(204, 199, 209));
		lblPassword.setFont(new Font(FONT, Font.PLAIN, 17));
		lblPassword.setBounds(90, 411, 188, 29);
		frmEdit.getContentPane().add(lblPassword);

		JLabel lblEditAccount = new JLabel("Edit Account");
		lblEditAccount.setForeground(Colors.bluishwhite);
		lblEditAccount.setFont(new Font(FONT, Font.BOLD, 41));
		lblEditAccount.setBounds(12, 12, 280, 64);
		frmEdit.getContentPane().add(lblEditAccount);

		cnfPasswordField = new JPasswordField();
		cnfPasswordField.setBorder(null);
		cnfPasswordField.setCaretColor(Colors.WHITE);
		cnfPasswordField.setBackground(Colors.GRAY);
		cnfPasswordField.setForeground(Colors.WHITE);
		cnfPasswordField.setFont(new Font(FONT, Font.PLAIN, 17));
		cnfPasswordField.setBounds(90, 439, 224, 29);
		frmEdit.getContentPane().add(cnfPasswordField);

		JLabel cfmPic = new JLabel("");
		cfmPic.setIcon(new ImageIcon("IMG/LoginPage/lock.png"));
		cfmPic.setSize(24, 29);
		cfmPic.setLocation(51, 439);
		frmEdit.getContentPane().add(cfmPic);

		JCheckBox ShowUnShowCnfPassword = new JCheckBox("");
		ShowUnShowCnfPassword.setIcon(new ImageIcon("IMG/LoginPage/hide.png"));
		ShowUnShowCnfPassword.setSelectedIcon(new ImageIcon("IMG/LoginPage/show.png"));
		ShowUnShowCnfPassword.setDisabledIcon(new ImageIcon("IMG/LoginPage/hide.png"));
		ShowUnShowCnfPassword.setForeground(Color.WHITE);
		ShowUnShowCnfPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cnfPasswordField.getEchoChar() == '•') {
					cnfPasswordField.setEchoChar((char) 0);
				} else {
					cnfPasswordField.setEchoChar('•');
				}
			}
		});
		ShowUnShowCnfPassword.setBackground(Colors.GRAY);
		ShowUnShowCnfPassword.setBounds(312, 439, 30, 29);
		frmEdit.getContentPane().add(ShowUnShowCnfPassword);

		emailField = new JTextField();
		emailField.setText(user.getEmail());
		emailField.setHorizontalAlignment(SwingConstants.LEFT);
		emailField.setForeground(new Color(204, 199, 209));
		emailField.setFont(new Font("Dialog", Font.PLAIN, 17));
		emailField.setColumns(10);
		emailField.setCaretColor(new Color(204, 199, 209));
		emailField.setBorder(null);
		emailField.setBackground(new Color(49, 63, 78));
		emailField.setBounds(90, 302, 252, 29);
		frmEdit.getContentPane().add(emailField);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(204, 199, 209));
		lblEmail.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblEmail.setBounds(90, 273, 142, 29);
		frmEdit.getContentPane().add(lblEmail);

		nameField = new JTextField();
		nameField.setText(user.getName());
		nameField.setHorizontalAlignment(SwingConstants.LEFT);
		nameField.setForeground(new Color(204, 199, 209));
		nameField.setFont(new Font("Dialog", Font.PLAIN, 17));
		nameField.setColumns(10);
		nameField.setCaretColor(new Color(204, 199, 209));
		nameField.setBorder(null);
		nameField.setBackground(new Color(49, 63, 78));
		nameField.setBounds(90, 232, 112, 29);
		frmEdit.getContentPane().add(nameField);

		JLabel lblRealName = new JLabel("Name");
		lblRealName.setForeground(new Color(204, 199, 209));
		lblRealName.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblRealName.setBounds(90, 203, 142, 29);
		frmEdit.getContentPane().add(lblRealName);

		JLabel lblRealSurname = new JLabel("Surname");
		lblRealSurname.setForeground(new Color(204, 199, 209));
		lblRealSurname.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblRealSurname.setBounds(204, 203, 74, 29);
		frmEdit.getContentPane().add(lblRealSurname);

		surnameField = new JTextField();
		surnameField.setText(user.getSurname());
		surnameField.setHorizontalAlignment(SwingConstants.LEFT);
		surnameField.setForeground(new Color(204, 199, 209));
		surnameField.setFont(new Font("Dialog", Font.PLAIN, 17));
		surnameField.setColumns(10);
		surnameField.setCaretColor(new Color(204, 199, 209));
		surnameField.setBorder(null);
		surnameField.setBackground(new Color(49, 63, 78));
		surnameField.setBounds(204, 232, 101, 29);
		frmEdit.getContentPane().add(surnameField);

		ageField = new JTextField();
		ageField.setText(user.getAge());
		ageField.setHorizontalAlignment(SwingConstants.LEFT);
		ageField.setForeground(new Color(204, 199, 209));
		ageField.setFont(new Font("Dialog", Font.PLAIN, 17));
		ageField.setColumns(10);
		ageField.setCaretColor(new Color(204, 199, 209));
		ageField.setBorder(null);
		ageField.setBackground(new Color(49, 63, 78));
		ageField.setBounds(307, 232, 35, 29);
		frmEdit.getContentPane().add(ageField);

		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(new Color(204, 199, 209));
		lblAge.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblAge.setBounds(312, 203, 38, 29);
		frmEdit.getContentPane().add(lblAge);

		JLabel emailPic = new JLabel("");
		emailPic.setIcon(new ImageIcon("IMG/LoginPage/envelope.png"));
		emailPic.setBounds(51, 302, 38, 29);
		frmEdit.getContentPane().add(emailPic);

		JLabel realDataPic = new JLabel("");
		realDataPic.setIcon(new ImageIcon("IMG/LoginPage/real_name.png"));
		realDataPic.setBounds(51, 232, 38, 29);
		frmEdit.getContentPane().add(realDataPic);

		JLabel lblProfilepic = new JLabel("Profile Picture");
		lblProfilepic.setForeground(new Color(204, 199, 209));
		lblProfilepic.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblProfilepic.setBounds(90, 162, 154, 29);
		frmEdit.getContentPane().add(lblProfilepic);

		profilePic = new JLabel("");
		profilePic.setIcon(user.getProfileImage());
		profilePic.setBounds(283, 12, 132, 132);
		profilePic.setSize(132, 132);
		frmEdit.getContentPane().add(profilePic);

		JButton btnChooseFile = new JButton("Choose File");
		btnChooseFile.setFocusPainted(false);
		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				if (file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File selectedFile = file.getSelectedFile();
					profilePic.setIcon(new ImageIcon(new ImageIcon(selectedFile.getAbsolutePath()).getImage()
							.getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH)));
				}
			}
		});
		btnChooseFile.setForeground(Colors.CYAN);
		btnChooseFile.setFont(new Font("Dialog", Font.BOLD, 12));
		btnChooseFile.setBackground(new Color(22, 28, 35));
		btnChooseFile.setBounds(213, 162, 112, 29);
		frmEdit.getContentPane().add(btnChooseFile);

		JLabel lblPassword_1 = new JLabel("Old Password");
		lblPassword_1.setForeground(new Color(204, 199, 209));
		lblPassword_1.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblPassword_1.setBounds(90, 339, 142, 29);
		frmEdit.getContentPane().add(lblPassword_1);

		passwordField = new JPasswordField();
		passwordField.setEditable(false);
		passwordField.setText(user.getPassword());
		passwordField.setForeground(new Color(204, 199, 209));
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 17));
		passwordField.setCaretColor(new Color(204, 199, 209));
		passwordField.setBorder(null);
		passwordField.setBackground(new Color(49, 63, 78));
		passwordField.setBounds(90, 367, 252, 29);
		frmEdit.getContentPane().add(passwordField);

		JLabel passwordPic = new JLabel("");
		passwordPic.setIcon(new ImageIcon("IMG/LoginPage/lock.png"));
		passwordPic.setSize(24, 29);
		passwordPic.setBounds(51, 367, 24, 29);
		frmEdit.getContentPane().add(passwordPic);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setForeground(new Color(204, 199, 209));
		lblNewPassword.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNewPassword.setBounds(90, 483, 188, 29);
		frmEdit.getContentPane().add(lblNewPassword);
		
		newPasswordField = new JPasswordField();
		newPasswordField.setForeground(new Color(204, 199, 209));
		newPasswordField.setFont(new Font("Dialog", Font.PLAIN, 17));
		newPasswordField.setCaretColor(new Color(204, 199, 209));
		newPasswordField.setBorder(null);
		newPasswordField.setBackground(new Color(49, 63, 78));
		newPasswordField.setBounds(90, 511, 224, 29);
		frmEdit.getContentPane().add(newPasswordField);
		
		JCheckBox newShowUnShowCnfPassword = new JCheckBox("");
		newShowUnShowCnfPassword.setIcon(new ImageIcon("IMG/LoginPage/hide.png"));
		newShowUnShowCnfPassword.setSelectedIcon(new ImageIcon("IMG/LoginPage/show.png"));
		newShowUnShowCnfPassword.setDisabledIcon(new ImageIcon("IMG/LoginPage/hide.png"));
		newShowUnShowCnfPassword.setForeground(Color.WHITE);
		newShowUnShowCnfPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (newPasswordField.getEchoChar() == '•') {
					newPasswordField.setEchoChar((char) 0);
				} else {
					newPasswordField.setEchoChar('•');
				}
			}
		});
		newShowUnShowCnfPassword.setForeground(Color.WHITE);
		newShowUnShowCnfPassword.setBackground(new Color(49, 63, 78));
		newShowUnShowCnfPassword.setBounds(312, 511, 30, 29);
		frmEdit.getContentPane().add(newShowUnShowCnfPassword);
		
		JLabel newPassPic = new JLabel("");
		newPassPic.setIcon(new ImageIcon("IMG/LoginPage/lock.png"));
		newPassPic.setBounds(51, 511, 24, 29);
		frmEdit.getContentPane().add(newPassPic);
	}

	public void setVisible(boolean b) {
		frmEdit.setVisible(b);
	}
	
	public boolean startDashboard() {
		for (User user : User.getAllUsers()) {
			if (Arrays.equals(newPasswordField.getPassword(), user.getPasswordChr())
					&& user.getNickname().equals(user.getNickname())) {
				Dashboard frame = new Dashboard(user,loginpage);
				frame.setVisible(true);
				setVisible(false);
				return true;
			}
		}
		JOptionPane.showMessageDialog(null, "Invalid password or nickname", "Could not login",
				JOptionPane.PLAIN_MESSAGE);
		return false;
	}

	/**
	 * @param user
	 * @param dashbaord
	 */
	public void edit(User user, Dashboard dashbaord) {
		if (nameField.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "You must have a name!", "No name", JOptionPane.PLAIN_MESSAGE);
		} else if (surnameField.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "You must have a surname!", "No surname",
					JOptionPane.PLAIN_MESSAGE);
		} else if (ageField.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "You must have an age!", "No age", JOptionPane.PLAIN_MESSAGE);
		} else if (!ageField.getText().matches("[0-9]+")) {
			JOptionPane.showMessageDialog(null, "Please enter a valid age!", "Invalid age",
					JOptionPane.PLAIN_MESSAGE);
		} else if (emailField.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "You must have an email!", "No email",
					JOptionPane.PLAIN_MESSAGE);
		} else if (!emailField.getText().contains("@")) {
			JOptionPane.showMessageDialog(null, "Please enter a valid email", "Invalid email",
					JOptionPane.PLAIN_MESSAGE);
		} else if (!Arrays.equals(passwordField.getPassword(), cnfPasswordField.getPassword())) {
			JOptionPane.showMessageDialog(null, "Passwords are not the same!", "Mismatch",
					JOptionPane.PLAIN_MESSAGE);
		} else if (newPasswordField.getPassword().length <= 0) {
			JOptionPane.showMessageDialog(null, "Password can not be empty", "Empty",
					JOptionPane.PLAIN_MESSAGE);
		} else {
			user.setPassword(newPasswordField.getPassword());
			user.setProfileImage(profilePic.getIcon());
			user.setEmail(emailField.getText());
			user.setAge(ageField.getText());
			user.setName(nameField.getText());
			user.setSurname(surnameField.getText());

			if (startDashboard()) {
				dashbaord.dispose();
			}
			dispose();
		}
	}
}
