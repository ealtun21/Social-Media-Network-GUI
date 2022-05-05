package client.FrontEnd.Startup;

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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;

public class RegisterPage {

	// TODO FIX LINUX FONT RENDERING

	private JFrame frmRegister;

	private JTextField nicknameField;

	// TODO IN WINDOWS
	private static final String FONT = "Arial";
	private JTextField emailField;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField ageField;
	private JPasswordField passwordField;
	private JLabel profilePic;

	/**
	 *
	 * Initialize the contents of the frame.
	 */
	public RegisterPage() {
		frmRegister = new JFrame();
		frmRegister.getContentPane().setFocusTraversalKeysEnabled(false);
		frmRegister.setResizable(false);
		frmRegister.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frmRegister.setTitle("Register");
		frmRegister.setBackground(Colors.DARK_GRAY);
		frmRegister.getContentPane().setBackground(Colors.DARK_GRAY);
		frmRegister.setBounds(100, 100, 440, 700);
		frmRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegister.getContentPane().setLayout(null);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFocusPainted(false);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegister.dispose();
			}
		});
		btnCancel.setForeground(Colors.RED);
		btnCancel.setFont(new Font(FONT, Font.BOLD, 16));
		btnCancel.setBackground(Colors.BLACK);
		btnCancel.setBounds(145, 590, 142, 29);
		frmRegister.getContentPane().add(btnCancel);

		JButton btnSignIn = new JButton("Register");
		btnSignIn.setFocusPainted(false);
		btnSignIn.addActionListener(new ActionListener() {
			// TODO Check if user is already registered
			public void actionPerformed(ActionEvent e) {
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
				} else if (nicknameField.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "You must have a nickname!", "No nickname",
							JOptionPane.PLAIN_MESSAGE);
				} else if (User.getAllUsers().stream().map(x -> x.getNickname().equals(nicknameField.getText()))
						.reduce(Boolean::logicalOr).orElse(false)) {
					JOptionPane.showMessageDialog(null, "That nickname was taken", "Unavailable nickname",
							JOptionPane.PLAIN_MESSAGE);
				} else if (passwordField.getPassword().length <= 0) {
					JOptionPane.showMessageDialog(null, "Password can not be empty", "Empty",
							JOptionPane.PLAIN_MESSAGE);
				} else {
					new User(nicknameField.getText(), passwordField.getPassword(), nameField.getText(),
							surnameField.getText(), ageField.getText(), emailField.getText(), profilePic.getIcon(), false);
					LoginPage login = new LoginPage();
					login.setVisible(true);
					frmRegister.dispose();
				}
			}
		});
		btnSignIn.setForeground(Colors.GREEN);
		btnSignIn.setFont(new Font(FONT, Font.BOLD, 16));
		btnSignIn.setBackground(Colors.BLACK);
		btnSignIn.setBounds(145, 532, 142, 29);
		frmRegister.getContentPane().add(btnSignIn);

		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setFont(new Font(FONT, Font.PLAIN, 17));
		lblNickname.setForeground(Colors.WHITE);
		lblNickname.setBounds(90, 343, 142, 29);
		frmRegister.getContentPane().add(lblNickname);

		nicknameField = new JTextField();
		nicknameField.setHorizontalAlignment(SwingConstants.LEFT);
		nicknameField.setFont(new Font(FONT, Font.PLAIN, 17));
		nicknameField.setForeground(new Color(204, 199, 209));
		nicknameField.setColumns(10);
		nicknameField.setCaretColor(new Color(204, 199, 209));
		nicknameField.setBorder(null);
		nicknameField.setBackground(Colors.GRAY);
		nicknameField.setBounds(90, 376, 252, 29);
		frmRegister.getContentPane().add(nicknameField);

		JLabel lblLogin = new JLabel("Register");
		lblLogin.setForeground(Colors.bluishwhite);
		lblLogin.setFont(new Font(FONT, Font.BOLD, 41));
		lblLogin.setBounds(12, 12, 182, 64);
		frmRegister.getContentPane().add(lblLogin);

		JLabel nicknamePic = new JLabel("");
		nicknamePic.setIcon(new ImageIcon("IMG/LoginPage/user.png"));
		nicknamePic.setBounds(51, 376, 38, 29);
		frmRegister.getContentPane().add(nicknamePic);

		emailField = new JTextField();
		emailField.setHorizontalAlignment(SwingConstants.LEFT);
		emailField.setForeground(new Color(204, 199, 209));
		emailField.setFont(new Font("Dialog", Font.PLAIN, 17));
		emailField.setColumns(10);
		emailField.setCaretColor(new Color(204, 199, 209));
		emailField.setBorder(null);
		emailField.setBackground(new Color(49, 63, 78));
		emailField.setBounds(90, 302, 252, 29);
		frmRegister.getContentPane().add(emailField);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(204, 199, 209));
		lblEmail.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblEmail.setBounds(90, 273, 142, 29);
		frmRegister.getContentPane().add(lblEmail);

		nameField = new JTextField();
		nameField.setHorizontalAlignment(SwingConstants.LEFT);
		nameField.setForeground(new Color(204, 199, 209));
		nameField.setFont(new Font("Dialog", Font.PLAIN, 17));
		nameField.setColumns(10);
		nameField.setCaretColor(new Color(204, 199, 209));
		nameField.setBorder(null);
		nameField.setBackground(new Color(49, 63, 78));
		nameField.setBounds(90, 232, 112, 29);
		frmRegister.getContentPane().add(nameField);

		JLabel lblRealName = new JLabel("Name");
		lblRealName.setForeground(new Color(204, 199, 209));
		lblRealName.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblRealName.setBounds(90, 203, 142, 29);
		frmRegister.getContentPane().add(lblRealName);

		JLabel lblRealSurname = new JLabel("Surname");
		lblRealSurname.setForeground(new Color(204, 199, 209));
		lblRealSurname.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblRealSurname.setBounds(204, 203, 74, 29);
		frmRegister.getContentPane().add(lblRealSurname);

		surnameField = new JTextField();
		surnameField.setHorizontalAlignment(SwingConstants.LEFT);
		surnameField.setForeground(new Color(204, 199, 209));
		surnameField.setFont(new Font("Dialog", Font.PLAIN, 17));
		surnameField.setColumns(10);
		surnameField.setCaretColor(new Color(204, 199, 209));
		surnameField.setBorder(null);
		surnameField.setBackground(new Color(49, 63, 78));
		surnameField.setBounds(204, 232, 101, 29);
		frmRegister.getContentPane().add(surnameField);

		ageField = new JTextField();
		ageField.setHorizontalAlignment(SwingConstants.LEFT);
		ageField.setForeground(new Color(204, 199, 209));
		ageField.setFont(new Font("Dialog", Font.PLAIN, 17));
		ageField.setColumns(10);
		ageField.setCaretColor(new Color(204, 199, 209));
		ageField.setBorder(null);
		ageField.setBackground(new Color(49, 63, 78));
		ageField.setBounds(307, 232, 35, 29);
		frmRegister.getContentPane().add(ageField);

		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(new Color(204, 199, 209));
		lblAge.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblAge.setBounds(312, 203, 38, 29);
		frmRegister.getContentPane().add(lblAge);

		JLabel emailPic = new JLabel("");
		emailPic.setIcon(new ImageIcon("IMG/LoginPage/envelope.png"));
		emailPic.setBounds(51, 302, 38, 29);
		frmRegister.getContentPane().add(emailPic);

		JLabel realDataPic = new JLabel("");
		realDataPic.setIcon(new ImageIcon("IMG/LoginPage/real_name.png"));
		realDataPic.setBounds(51, 232, 38, 29);
		frmRegister.getContentPane().add(realDataPic);

		JLabel lblProfilepic = new JLabel("Profile Picture");
		lblProfilepic.setForeground(new Color(204, 199, 209));
		lblProfilepic.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblProfilepic.setBounds(90, 162, 154, 29);
		frmRegister.getContentPane().add(lblProfilepic);

		profilePic = new JLabel("");
		profilePic.setIcon(new ImageIcon("IMG/LoginPage/profilePic.png"));
		profilePic.setBounds(203, 24, 132, 132);
		profilePic.setSize(132, 132);
		frmRegister.getContentPane().add(profilePic);

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
		frmRegister.getContentPane().add(btnChooseFile);

		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setForeground(new Color(204, 199, 209));
		lblPassword_1.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblPassword_1.setBounds(90, 411, 142, 29);
		frmRegister.getContentPane().add(lblPassword_1);

		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(204, 199, 209));
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 17));
		passwordField.setCaretColor(new Color(204, 199, 209));
		passwordField.setBorder(null);
		passwordField.setBackground(new Color(49, 63, 78));
		passwordField.setBounds(90, 439, 224, 29);
		frmRegister.getContentPane().add(passwordField);

		JLabel passwordPic = new JLabel("");
		passwordPic.setIcon(new ImageIcon("IMG/LoginPage/lock.png"));
		passwordPic.setSize(24, 29);
		passwordPic.setBounds(51, 439, 24, 29);
		frmRegister.getContentPane().add(passwordPic);

		JCheckBox ShowUnShowPassword = new JCheckBox("");
		ShowUnShowPassword.setIcon(new ImageIcon("IMG/LoginPage/hide.png"));
		ShowUnShowPassword.setSelectedIcon(new ImageIcon("IMG/LoginPage/show.png"));
		ShowUnShowPassword.setDisabledIcon(new ImageIcon("IMG/LoginPage/hide.png"));
		ShowUnShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (passwordField.getEchoChar() == '•') {
					passwordField.setEchoChar((char) 0);
				} else {
					passwordField.setEchoChar('•');
				}
			}
		});
		ShowUnShowPassword.setBackground(Colors.GRAY);
		ShowUnShowPassword.setBounds(312, 439, 30, 29);
		frmRegister.getContentPane().add(ShowUnShowPassword);
	}

	public void setVisible(boolean b) {
		frmRegister.setVisible(b);
	}

}
