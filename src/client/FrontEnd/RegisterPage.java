package client.FrontEnd;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;

import client.BackEnd.Colors;
import client.BackEnd.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;

public class RegisterPage {

	// TODO FIX LINUX FONT RENDERING

	private JFrame frmRegister;

	private JTextField nicknameField;
	private JPasswordField cnfPasswordField;

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
		UIManager.put("OptionPane.messageFont", new Font(FONT, Font.PLAIN, 16));
		UIManager.put("OptionPane.buttonFont", new Font(FONT, Font.PLAIN, 13));
		UIManager.put("OptionPane.background", Colors.DARK_GRAY);
		UIManager.put("OptionPane.messageForeground", Colors.WHITE);
		UIManager.getLookAndFeelDefaults().put("Panel.background", Colors.DARK_GRAY);
		UIManager.getLookAndFeelDefaults().put("TextField.background", Colors.GRAY);
		UIManager.getLookAndFeelDefaults().put("TextField.border", null);
		UIManager.getLookAndFeelDefaults().put("TextField.foreground", Colors.WHITE);
		UIManager.getLookAndFeelDefaults().put("TextField.caretForeground", Colors.WHITE);
		UIManager.getLookAndFeelDefaults().put("Button.background", Colors.BLACK);
		UIManager.getLookAndFeelDefaults().put("Button.foreground", Colors.WHITE);
		UIManager.getLookAndFeelDefaults().put("Button.focus", Colors.BLACK);
		UIManager.getLookAndFeelDefaults().put("OptionPane.okButtonText", "<html><b style=\"color:#6BFF56;\">OK");
		UIManager.getLookAndFeelDefaults().put("OptionPane.cancelButtonText",
				"<html><b style=\"color:#F34473;\">Cancel");

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
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegister.dispose();
			}
		});
		btnCancel.setForeground(Colors.RED);
		btnCancel.setFont(new Font(FONT, Font.BOLD, 16));
		btnCancel.setBackground(Colors.BLACK);
		btnCancel.setBounds(163, 593, 142, 29);
		frmRegister.getContentPane().add(btnCancel);

		JButton btnSignIn = new JButton("Register");
		btnSignIn.addActionListener(new ActionListener() {
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
				} else if (!Arrays.equals(passwordField.getPassword(), cnfPasswordField.getPassword())) {
					JOptionPane.showMessageDialog(null, "Passwords are not the same!", "Mismatch",
							JOptionPane.PLAIN_MESSAGE);
				} else if (passwordField.getPassword().length <= 0) {
					JOptionPane.showMessageDialog(null, "Password can not be empty", "Empty",
							JOptionPane.PLAIN_MESSAGE);
				} else {
					new User(nicknameField.getText(), passwordField.getPassword(), nameField.getText(),
							surnameField.getText(), ageField.getText(), profilePic.getIcon());
					LoginPage login = new LoginPage();
					login.setVisible(true);
					frmRegister.dispose();
				}
			}
		});
		btnSignIn.setForeground(Colors.GREEN);
		btnSignIn.setFont(new Font(FONT, Font.BOLD, 16));
		btnSignIn.setBackground(Colors.BLACK);
		btnSignIn.setBounds(163, 552, 142, 29);
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

		JLabel lblPassword = new JLabel("Confirm Password");
		lblPassword.setForeground(new Color(204, 199, 209));
		lblPassword.setFont(new Font(FONT, Font.PLAIN, 17));
		lblPassword.setBounds(90, 483, 188, 29);
		frmRegister.getContentPane().add(lblPassword);

		JLabel lblLogin = new JLabel("Register");
		lblLogin.setForeground(Colors.bluishwhite);
		lblLogin.setFont(new Font(FONT, Font.BOLD, 41));
		lblLogin.setBounds(12, 12, 182, 64);
		frmRegister.getContentPane().add(lblLogin);

		cnfPasswordField = new JPasswordField();
		cnfPasswordField.setBorder(null);
		cnfPasswordField.setCaretColor(Colors.WHITE);
		cnfPasswordField.setBackground(Colors.GRAY);
		cnfPasswordField.setForeground(Colors.WHITE);
		cnfPasswordField.setFont(new Font(FONT, Font.PLAIN, 17));
		cnfPasswordField.setBounds(90, 511, 224, 29);
		frmRegister.getContentPane().add(cnfPasswordField);

		JLabel nicknamePic = new JLabel("");
		nicknamePic.setIcon(new ImageIcon("IMG/LoginPage/user.png"));
		nicknamePic.setBounds(51, 376, 38, 29);
		frmRegister.getContentPane().add(nicknamePic);

		JLabel cfmPic = new JLabel("");
		cfmPic.setIcon(new ImageIcon("IMG/LoginPage/lock.png"));
		cfmPic.setSize(24, 29);
		cfmPic.setLocation(51, 511);
		frmRegister.getContentPane().add(cfmPic);

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
		ShowUnShowCnfPassword.setBounds(312, 511, 30, 29);
		frmRegister.getContentPane().add(ShowUnShowCnfPassword);

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
		lblProfilepic.setBounds(89, 104, 154, 29);
		frmRegister.getContentPane().add(lblProfilepic);

		profilePic = new JLabel("");
		profilePic.setIcon(new ImageIcon("IMG/LoginPage/profilePic.png"));
		profilePic.setBounds(203, 24, 132, 132);
		profilePic.setSize(132, 132);
		frmRegister.getContentPane().add(profilePic);

		JButton btnChooseFile = new JButton("Choose File");
		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				if (file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File selectedFile = file.getSelectedFile();
					profilePic.setIcon(new ImageIcon(selectedFile.getAbsolutePath()));
				}
			}
		});
		btnChooseFile.setForeground(new Color(107, 255, 86));
		btnChooseFile.setFont(new Font("Dialog", Font.BOLD, 12));
		btnChooseFile.setBackground(new Color(22, 28, 35));
		btnChooseFile.setBounds(213, 162, 112, 29);
		frmRegister.getContentPane().add(btnChooseFile);

		JLabel lblx = new JLabel("132 x 132");
		lblx.setForeground(new Color(204, 199, 209));
		lblx.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblx.setBounds(139, 127, 154, 29);
		frmRegister.getContentPane().add(lblx);

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
