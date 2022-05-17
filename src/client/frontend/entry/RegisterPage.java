package client.frontend.entry;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileSystemView;

import client.backend.User;
import client.frontend.Colors;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
	private JCheckBox isPremium;
	private LoginPage login;
	private JTextField hobbiesField;
	private JTextField countryField;

	/**
	 *
	 * Initialize the contents of the frame.
	 */
	public RegisterPage() {
		login = new LoginPage();

		frmRegister = new JFrame();
		frmRegister.getContentPane().setFocusTraversalKeysEnabled(false);
		frmRegister.setResizable(false);
		frmRegister.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frmRegister.setTitle("Register");
		frmRegister.setBackground(Colors.DARK_GRAY);
		frmRegister.getContentPane().setBackground(Colors.DARK_GRAY);
		frmRegister.setBounds(100, 100, 368, 741);
		frmRegister.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRegister.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				login.setVisible(true);
			}
		});
		frmRegister.getContentPane().setLayout(null);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFocusPainted(false);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setVisible(true);
				frmRegister.dispose();
			}
		});
		btnCancel.setForeground(Colors.RED);
		btnCancel.setFont(new Font(FONT, Font.BOLD, 16));
		btnCancel.setBackground(Colors.BLACK);
		btnCancel.setBounds(120, 671, 142, 29);
		frmRegister.getContentPane().add(btnCancel);

		JButton btnSignIn = new JButton("Register");
		btnSignIn.setFocusPainted(false);
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
				} else if (User.getAllUsers().stream().map(x -> x.getNickname().equals(nicknameField.getText()))
						.reduce(Boolean::logicalOr).orElse(false)) {
					JOptionPane.showMessageDialog(null, "That nickname was taken", "Unavailable nickname",
							JOptionPane.PLAIN_MESSAGE);
				} else if (passwordField.getPassword().length <= 0) {
					JOptionPane.showMessageDialog(null, "Password can not be empty", "Empty",
							JOptionPane.PLAIN_MESSAGE);
				} else if (countryField.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Country can not be empty", "Empty",
							JOptionPane.PLAIN_MESSAGE);
				} else if (hobbiesField.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Hobbies can not be empty", "Empty",
							JOptionPane.PLAIN_MESSAGE);
				} else {
					new User(nicknameField.getText(), passwordField.getPassword(), nameField.getText(),
							surnameField.getText(), ageField.getText(), emailField.getText(), profilePic.getIcon(),
							isPremium.isSelected(), countryField.getText(), new ArrayList<String>(Arrays.asList(hobbiesField.getText().replaceAll("\\s+", "").split(","))));
					login.setVisible(true);
					frmRegister.dispose();
				}
			}
		});
		btnSignIn.setForeground(Colors.GREEN);
		btnSignIn.setFont(new Font(FONT, Font.BOLD, 16));
		btnSignIn.setBackground(Colors.BLACK);
		btnSignIn.setBounds(120, 613, 142, 29);
		frmRegister.getContentPane().add(btnSignIn);

		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setFont(new Font(FONT, Font.PLAIN, 17));
		lblNickname.setForeground(Colors.WHITE);
		lblNickname.setBounds(65, 421, 252, 29);
		frmRegister.getContentPane().add(lblNickname);

		nicknameField = new JTextField();
		nicknameField.setHorizontalAlignment(SwingConstants.LEFT);
		nicknameField.setFont(new Font(FONT, Font.PLAIN, 17));
		nicknameField.setForeground(new Color(204, 199, 209));
		nicknameField.setColumns(10);
		nicknameField.setCaretColor(new Color(204, 199, 209));
		nicknameField.setBorder(null);
		nicknameField.setBackground(Colors.GRAY);
		nicknameField.setBounds(65, 451, 252, 29);
		frmRegister.getContentPane().add(nicknameField);

		JLabel lblLogin = new JLabel("Register");
		lblLogin.setForeground(Colors.bluishwhite);
		lblLogin.setFont(new Font(FONT, Font.BOLD, 41));
		lblLogin.setBounds(12, 12, 182, 64);
		frmRegister.getContentPane().add(lblLogin);

		JLabel nicknamePic = new JLabel("");
		nicknamePic.setIcon(new ImageIcon("IMG/LoginPage/user.png"));
		nicknamePic.setBounds(26, 451, 38, 29);
		frmRegister.getContentPane().add(nicknamePic);

		emailField = new JTextField();
		emailField.setHorizontalAlignment(SwingConstants.LEFT);
		emailField.setForeground(new Color(204, 199, 209));
		emailField.setFont(new Font("Dialog", Font.PLAIN, 17));
		emailField.setColumns(10);
		emailField.setCaretColor(new Color(204, 199, 209));
		emailField.setBorder(null);
		emailField.setBackground(new Color(49, 63, 78));
		emailField.setBounds(65, 390, 252, 29);
		frmRegister.getContentPane().add(emailField);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(204, 199, 209));
		lblEmail.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblEmail.setBounds(65, 361, 252, 29);
		frmRegister.getContentPane().add(lblEmail);

		nameField = new JTextField();
		nameField.setHorizontalAlignment(SwingConstants.LEFT);
		nameField.setForeground(new Color(204, 199, 209));
		nameField.setFont(new Font("Dialog", Font.PLAIN, 17));
		nameField.setColumns(10);
		nameField.setCaretColor(new Color(204, 199, 209));
		nameField.setBorder(null);
		nameField.setBackground(new Color(49, 63, 78));
		nameField.setBounds(65, 331, 112, 29);
		frmRegister.getContentPane().add(nameField);

		JLabel lblRealName = new JLabel("Name");
		lblRealName.setForeground(new Color(204, 199, 209));
		lblRealName.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblRealName.setBounds(65, 302, 142, 29);
		frmRegister.getContentPane().add(lblRealName);

		JLabel lblRealSurname = new JLabel("Surname");
		lblRealSurname.setForeground(new Color(204, 199, 209));
		lblRealSurname.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblRealSurname.setBounds(179, 302, 74, 29);
		frmRegister.getContentPane().add(lblRealSurname);

		surnameField = new JTextField();
		surnameField.setHorizontalAlignment(SwingConstants.LEFT);
		surnameField.setForeground(new Color(204, 199, 209));
		surnameField.setFont(new Font("Dialog", Font.PLAIN, 17));
		surnameField.setColumns(10);
		surnameField.setCaretColor(new Color(204, 199, 209));
		surnameField.setBorder(null);
		surnameField.setBackground(new Color(49, 63, 78));
		surnameField.setBounds(179, 331, 101, 29);
		frmRegister.getContentPane().add(surnameField);

		ageField = new JTextField();
		ageField.setHorizontalAlignment(SwingConstants.LEFT);
		ageField.setForeground(new Color(204, 199, 209));
		ageField.setFont(new Font("Dialog", Font.PLAIN, 17));
		ageField.setColumns(10);
		ageField.setCaretColor(new Color(204, 199, 209));
		ageField.setBorder(null);
		ageField.setBackground(new Color(49, 63, 78));
		ageField.setBounds(282, 331, 35, 29);
		frmRegister.getContentPane().add(ageField);

		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(new Color(204, 199, 209));
		lblAge.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblAge.setBounds(287, 302, 38, 29);
		frmRegister.getContentPane().add(lblAge);

		JLabel emailPic = new JLabel("");
		emailPic.setIcon(new ImageIcon("IMG/LoginPage/envelope.png"));
		emailPic.setBounds(26, 390, 38, 29);
		frmRegister.getContentPane().add(emailPic);

		JLabel realDataPic = new JLabel("");
		realDataPic.setIcon(new ImageIcon("IMG/LoginPage/real_name.png"));
		realDataPic.setBounds(26, 331, 38, 29);
		frmRegister.getContentPane().add(realDataPic);

		JLabel lblCountry = new JLabel("Country");
		lblCountry.setForeground(new Color(204, 199, 209));
		lblCountry.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblCountry.setBounds(65, 188, 129, 29);
		frmRegister.getContentPane().add(lblCountry);

		profilePic = new JLabel("");
		profilePic.setIcon(new ImageIcon("IMG/LoginPage/profilePic.png"));
		profilePic.setBounds(213, 24, 132, 132);
		profilePic.setSize(132, 132);
		frmRegister.getContentPane().add(profilePic);

		JLabel hobbiePic = new JLabel("");
		hobbiePic.setIcon(new ImageIcon(new ImageIcon("IMG/LoginPage/hobbies.png").getImage().getScaledInstance(24, 24,  java.awt.Image.SCALE_SMOOTH)));
		hobbiePic.setBounds(26, 274, 38, 29);
		frmRegister.getContentPane().add(hobbiePic);
		
		JLabel countyPic = new JLabel("");
		countyPic.setIcon(new ImageIcon(new ImageIcon("IMG/LoginPage/world.png").getImage().getScaledInstance(24, 24,  java.awt.Image.SCALE_SMOOTH)));
		countyPic.setBounds(26, 217, 38, 29);
		frmRegister.getContentPane().add(countyPic);
		
		JButton btnChooseFile = new JButton("Choose File");
		btnChooseFile.setFocusPainted(false);
		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				if (file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File selectedFile = file.getSelectedFile();
					try {
						if (ImageIO.read(file.getSelectedFile()) != null) {
							profilePic.setIcon(new ImageIcon(new ImageIcon(selectedFile.getAbsolutePath()).getImage()
									.getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH)));
						} else {
							JOptionPane.showMessageDialog(null, "Please select an image!", "Invalid Image", JOptionPane.PLAIN_MESSAGE);
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnChooseFile.setForeground(Colors.CYAN);
		btnChooseFile.setFont(new Font("Dialog", Font.BOLD, 12));
		btnChooseFile.setBackground(new Color(22, 28, 35));
		btnChooseFile.setBounds(205, 168, 112, 29);
		frmRegister.getContentPane().add(btnChooseFile);

		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setForeground(new Color(204, 199, 209));
		lblPassword_1.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblPassword_1.setBounds(65, 482, 252, 29);
		frmRegister.getContentPane().add(lblPassword_1);

		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(204, 199, 209));
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 17));
		passwordField.setCaretColor(new Color(204, 199, 209));
		passwordField.setBorder(null);
		passwordField.setBackground(new Color(49, 63, 78));
		passwordField.setBounds(65, 513, 224, 29);
		frmRegister.getContentPane().add(passwordField);

		JLabel passwordPic = new JLabel("");
		passwordPic.setIcon(new ImageIcon("IMG/LoginPage/lock.png"));
		passwordPic.setSize(24, 29);
		passwordPic.setBounds(26, 513, 24, 29);
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
		ShowUnShowPassword.setBounds(287, 513, 30, 29);
		frmRegister.getContentPane().add(ShowUnShowPassword);

		isPremium = new JCheckBox("Premium");
		isPremium.setBounds(65, 550, 90, 25);
		frmRegister.getContentPane().add(isPremium);
		
		hobbiesField = new JTextField();
		hobbiesField.setHorizontalAlignment(SwingConstants.LEFT);
		hobbiesField.setForeground(new Color(204, 199, 209));
		hobbiesField.setFont(new Font("Dialog", Font.PLAIN, 17));
		hobbiesField.setColumns(10);
		hobbiesField.setCaretColor(new Color(204, 199, 209));
		hobbiesField.setBorder(null);
		hobbiesField.setBackground(new Color(49, 63, 78));
		hobbiesField.setBounds(65, 274, 252, 29);
		frmRegister.getContentPane().add(hobbiesField);
		
		countryField = new JTextField();
		countryField.setHorizontalAlignment(SwingConstants.LEFT);
		countryField.setForeground(new Color(204, 199, 209));
		countryField.setFont(new Font("Dialog", Font.PLAIN, 17));
		countryField.setColumns(10);
		countryField.setCaretColor(new Color(204, 199, 209));
		countryField.setBorder(null);
		countryField.setBackground(new Color(49, 63, 78));
		countryField.setBounds(66, 217, 252, 29);
		frmRegister.getContentPane().add(countryField);
		
		JLabel lblHobbies = new JLabel("Hobbies");
		lblHobbies.setForeground(new Color(204, 199, 209));
		lblHobbies.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblHobbies.setBounds(65, 248, 252, 29);
		frmRegister.getContentPane().add(lblHobbies);
	}

	public void setVisible(boolean b) {
		frmRegister.setVisible(b);
	}
}
