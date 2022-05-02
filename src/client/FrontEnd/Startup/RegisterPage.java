package client.FrontEnd.Startup;

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
		setTheme();

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
		btnCancel.setBounds(163, 593, 142, 29);
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
				} else if (isNicknameTaken()) {
					JOptionPane.showMessageDialog(null, "That nickname was taken", "Unavailable nickname",
							JOptionPane.PLAIN_MESSAGE);
				} else if (!Arrays.equals(passwordField.getPassword(), cnfPasswordField.getPassword())) {
					JOptionPane.showMessageDialog(null, "Passwords are not the same!", "Mismatch",
							JOptionPane.PLAIN_MESSAGE);
				} else if (passwordField.getPassword().length <= 0) {
					JOptionPane.showMessageDialog(null, "Password can not be empty", "Empty",
							JOptionPane.PLAIN_MESSAGE);
				} else {
					new User(nicknameField.getText(), passwordField.getPassword(), nameField.getText(),
							surnameField.getText(), ageField.getText(), profilePic.getIcon(), false);
					LoginPage login = new LoginPage();
					login.setVisible(true);
					frmRegister.dispose();
				}
			}

			private boolean isNicknameTaken() {
				for (User user : User.getAllUsers()) {
					if (user.getNickname().equals(nicknameField.getText())) {
						return true;
					}
				}
				return false;
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
		btnChooseFile.setForeground(new Color(107, 255, 86));
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

	/**
	 * Sets most of the external UI's colors.
	 */
	private void setTheme() {
		UIManager.put("Button.background", Colors.DARK_GRAY);
		UIManager.put("Button.darkShadow", Colors.BLACK);
		UIManager.put("Button.disabledText", Colors.LIGHT_GRAY);
		UIManager.put("Button.foreground", Colors.WHITE);
		UIManager.put("Button.highlight", Colors.YELLOW);
		UIManager.put("Button.light", Colors.DARK_GRAY);
		UIManager.put("Button.select", Colors.BLACK);
		UIManager.put("Button.shadow", Colors.WHITE);
		UIManager.put("CheckBox.background", Colors.DARK_GRAY);
		UIManager.put("CheckBox.disabledText", Colors.DARK_GRAY);
		UIManager.put("CheckBox.foreground", Colors.WHITE);
		UIManager.put("CheckBox.select", Colors.DARK_GRAY);
		UIManager.put("CheckBoxMenuItem.acceleratorForeground", Colors.WHITE);
		UIManager.put("CheckBoxMenuItem.acceleratorSelectionForeground", Colors.WHITE);
		UIManager.put("CheckBoxMenuItem.background", Colors.DARK_GRAY);
		UIManager.put("CheckBoxMenuItem.disabledBackground", Colors.DARK_GRAY);
		UIManager.put("CheckBoxMenuItem.disabledForeground", Colors.WHITE);
		UIManager.put("CheckBoxMenuItem.foreground", Colors.WHITE);
		UIManager.put("CheckBoxMenuItem.selectionBackground", Colors.DARK_GRAY);
		UIManager.put("CheckBoxMenuItem.selectionForeground", Colors.WHITE);
		UIManager.put("ColorChooser.background", Colors.DARK_GRAY);
		UIManager.put("ColorChooser.foreground", Colors.WHITE);
		UIManager.put("ColorChooser.swatchesDefaultRecentColor", Colors.DARK_GRAY);
		UIManager.put("ComboBox.background", Colors.DARK_GRAY);
		UIManager.put("ComboBox.buttonBackground", Colors.DARK_GRAY);
		UIManager.put("ComboBox.buttonDarkShadow", Colors.DARK_GRAY);
		UIManager.put("ComboBox.buttonHighlight", Colors.DARK_GRAY);
		UIManager.put("ComboBox.buttonShadow", Colors.DARK_GRAY);
		UIManager.put("ComboBox.disabledBackground", Colors.DARK_GRAY);
		UIManager.put("ComboBox.disabledForeground", Colors.WHITE);
		UIManager.put("ComboBox.foreground", Colors.WHITE);
		UIManager.put("ComboBox.selectionBackground", Colors.DARK_GRAY);
		UIManager.put("ComboBox.selectionForeground", Colors.WHITE);
		UIManager.put("Desktop.background", Colors.DARK_GRAY);
		UIManager.put("EditorPane.background", Colors.DARK_GRAY);
		UIManager.put("EditorPane.caretForeground", Colors.WHITE);
		UIManager.put("EditorPane.foreground", Colors.WHITE);
		UIManager.put("EditorPane.inactiveBackground", Colors.DARK_GRAY);
		UIManager.put("EditorPane.inactiveForeground", Colors.WHITE);
		UIManager.put("EditorPane.selectionBackground", Colors.DARK_GRAY);
		UIManager.put("EditorPane.selectionForeground", Colors.WHITE);
		UIManager.put("Focus.color", Colors.DARK_GRAY);
		UIManager.put("FormattedTextField.background", Colors.DARK_GRAY);
		UIManager.put("FormattedTextField.caretForeground", Colors.WHITE);
		UIManager.put("FormattedTextField.foreground", Colors.WHITE);
		UIManager.put("FormattedTextField.inactiveBackground", Colors.DARK_GRAY);
		UIManager.put("FormattedTextField.inactiveForeground", Colors.WHITE);
		UIManager.put("FormattedTextField.selectionBackground", Colors.DARK_GRAY);
		UIManager.put("FormattedTextField.selectionForeground", Colors.WHITE);
		UIManager.put("InternalFrame.activeTitleBackground", Colors.DARK_GRAY);
		UIManager.put("InternalFrame.activeTitleForeground", Colors.WHITE);
		UIManager.put("InternalFrame.background", Colors.DARK_GRAY);
		UIManager.put("InternalFrame.borderColor", Colors.DARK_GRAY);
		UIManager.put("InternalFrame.borderDarkShadow", Colors.DARK_GRAY);
		UIManager.put("InternalFrame.borderHighlight", Colors.DARK_GRAY);
		UIManager.put("InternalFrame.borderLight", Colors.DARK_GRAY);
		UIManager.put("InternalFrame.borderShadow", Colors.DARK_GRAY);
		UIManager.put("InternalFrame.inactiveTitleBackground", Colors.DARK_GRAY);
		UIManager.put("InternalFrame.inactiveTitleForeground", Colors.WHITE);
		UIManager.put("InternalFrame.optionDialogBackground", Colors.DARK_GRAY);
		UIManager.put("InternalFrame.paletteBackground", Colors.DARK_GRAY);
		UIManager.put("Label.background", Colors.DARK_GRAY);
		UIManager.put("Label.disabledForeground", Colors.WHITE);
		UIManager.put("Label.disabledShadow", Colors.DARK_GRAY);
		UIManager.put("Label.foreground", Colors.WHITE);
		UIManager.put("List.background", Colors.DARK_GRAY);
		UIManager.put("List.foreground", Colors.WHITE);
		UIManager.put("List.selectionBackground", Colors.DARK_GRAY);
		UIManager.put("List.selectionForeground", Colors.WHITE);
		UIManager.put("Menu.acceleratorForeground", Colors.WHITE);
		UIManager.put("Menu.acceleratorSelectionForeground", Colors.WHITE);
		UIManager.put("Menu.background", Colors.DARK_GRAY);
		UIManager.put("Menu.disabledBackground", Colors.DARK_GRAY);
		UIManager.put("Menu.disabledForeground", Colors.WHITE);
		UIManager.put("Menu.foreground", Colors.WHITE);
		UIManager.put("Menu.selectionBackground", Colors.DARK_GRAY);
		UIManager.put("Menu.selectionForeground", Colors.WHITE);
		UIManager.put("MenuBar.background", Colors.DARK_GRAY);
		UIManager.put("MenuBar.disabledBackground", Colors.DARK_GRAY);
		UIManager.put("MenuBar.disabledForeground", Colors.WHITE);
		UIManager.put("MenuBar.foreground", Colors.WHITE);
		UIManager.put("MenuBar.highlight", Colors.DARK_GRAY);
		UIManager.put("MenuBar.selectionBackground", Colors.DARK_GRAY);
		UIManager.put("MenuBar.selectionForeground", Colors.WHITE);
		UIManager.put("MenuBar.shadow", Colors.DARK_GRAY);
		UIManager.put("MenuItem.acceleratorForeground", Colors.WHITE);
		UIManager.put("MenuItem.acceleratorSelectionForeground", Colors.WHITE);
		UIManager.put("MenuItem.background", Colors.DARK_GRAY);
		UIManager.put("MenuItem.disabledBackground", Colors.DARK_GRAY);
		UIManager.put("MenuItem.disabledForeground", Colors.WHITE);
		UIManager.put("MenuItem.foreground", Colors.WHITE);
		UIManager.put("MenuItem.selectionBackground", Colors.DARK_GRAY);
		UIManager.put("MenuItem.selectionForeground", Colors.WHITE);
		UIManager.put("OptionPane.background", Colors.DARK_GRAY);
		UIManager.put("OptionPane.foreground", Colors.WHITE);
		UIManager.put("OptionPane.messageForeground", Colors.WHITE);
		UIManager.put("Panel.background", Colors.DARK_GRAY);
		UIManager.put("Panel.foreground", Colors.WHITE);
		UIManager.put("PasswordField.background", Colors.DARK_GRAY);
		UIManager.put("PasswordField.caretForeground", Colors.WHITE);
		UIManager.put("PasswordField.foreground", Colors.WHITE);
		UIManager.put("PasswordField.inactiveBackground", Colors.DARK_GRAY);
		UIManager.put("PasswordField.inactiveForeground", Colors.WHITE);
		UIManager.put("PasswordField.selectionBackground", Colors.DARK_GRAY);
		UIManager.put("PasswordField.selectionForeground", Colors.WHITE);
		UIManager.put("PopupMenu.background", Colors.DARK_GRAY);
		UIManager.put("PopupMenu.foreground", Colors.WHITE);
		UIManager.put("PopupMenu.selectionBackground", Colors.DARK_GRAY);
		UIManager.put("PopupMenu.selectionForeground", Colors.WHITE);
		UIManager.put("ProgressBar.background", Colors.DARK_GRAY);
		UIManager.put("ProgressBar.foreground", Colors.WHITE);
		UIManager.put("ProgressBar.selectionBackground", Colors.DARK_GRAY);
		UIManager.put("ProgressBar.selectionForeground", Colors.WHITE);
		UIManager.put("RadioButton.background", Colors.DARK_GRAY);
		UIManager.put("RadioButton.darkShadow", Colors.DARK_GRAY);
		UIManager.put("RadioButton.disabledText", Colors.DARK_GRAY);
		UIManager.put("RadioButton.foreground", Colors.WHITE);
		UIManager.put("RadioButton.highlight", Colors.DARK_GRAY);
		UIManager.put("RadioButton.light", Colors.DARK_GRAY);
		UIManager.put("RadioButton.select", Colors.DARK_GRAY);
		UIManager.put("RadioButton.shadow", Colors.DARK_GRAY);
		UIManager.put("RadioButtonMenuItem.acceleratorForeground", Colors.WHITE);
		UIManager.put("RadioButtonMenuItem.acceleratorSelectionForeground", Colors.WHITE);
		UIManager.put("RadioButtonMenuItem.background", Colors.DARK_GRAY);
		UIManager.put("RadioButtonMenuItem.disabledBackground", Colors.DARK_GRAY);
		UIManager.put("RadioButtonMenuItem.disabledForeground", Colors.WHITE);
		UIManager.put("RadioButtonMenuItem.foreground", Colors.WHITE);
		UIManager.put("RadioButtonMenuItem.selectionBackground", Colors.DARK_GRAY);
		UIManager.put("RadioButtonMenuItem.selectionForeground", Colors.WHITE);
		UIManager.put("ScrollBar.background", Colors.DARK_GRAY);
		UIManager.put("ScrollBar.foreground", Colors.WHITE);
		UIManager.put("ScrollBar.thumb", Colors.DARK_GRAY);
		UIManager.put("ScrollBar.thumbDarkShadow", Colors.DARK_GRAY);
		UIManager.put("ScrollBar.thumbHighlight", Colors.DARK_GRAY);
		UIManager.put("ScrollBar.thumbShadow", Colors.DARK_GRAY);
		UIManager.put("ScrollBar.track", Colors.DARK_GRAY);
		UIManager.put("ScrollBar.trackHighlight", Colors.DARK_GRAY);
		UIManager.put("ScrollPane.background", Colors.DARK_GRAY);
		UIManager.put("ScrollPane.foreground", Colors.WHITE);
		UIManager.put("Separator.foreground", Colors.WHITE);
		UIManager.put("Separator.highlight", Colors.DARK_GRAY);
		UIManager.put("Separator.shadow", Colors.DARK_GRAY);
		UIManager.put("Slider.background", Colors.DARK_GRAY);
		UIManager.put("Slider.focus", Colors.DARK_GRAY);
		UIManager.put("Slider.foreground", Colors.WHITE);
		UIManager.put("Slider.highlight", Colors.DARK_GRAY);
		UIManager.put("Slider.shadow", Colors.DARK_GRAY);
		UIManager.put("Slider.tickColor", Colors.DARK_GRAY);
		UIManager.put("Spinner.background", Colors.DARK_GRAY);
		UIManager.put("Spinner.foreground", Colors.WHITE);
		UIManager.put("SplitPane.background", Colors.DARK_GRAY);
		UIManager.put("SplitPane.darkShadow", Colors.DARK_GRAY);
		UIManager.put("SplitPane.highlight", Colors.DARK_GRAY);
		UIManager.put("SplitPane.shadow", Colors.DARK_GRAY);
		UIManager.put("SplitPaneDivider.draggingColor", Colors.DARK_GRAY);
		UIManager.put("TabbedPane.background", Colors.DARK_GRAY);
		UIManager.put("TabbedPane.darkShadow", Colors.DARK_GRAY);
		UIManager.put("TabbedPane.focus", Colors.DARK_GRAY);
		UIManager.put("TabbedPane.foreground", Colors.WHITE);
		UIManager.put("TabbedPane.highlight", Colors.DARK_GRAY);
		UIManager.put("TabbedPane.light", Colors.DARK_GRAY);
		UIManager.put("TabbedPane.shadow", Colors.DARK_GRAY);
		UIManager.put("Table.background", Colors.DARK_GRAY);
		UIManager.put("Table.focusCellBackground", Colors.DARK_GRAY);
		UIManager.put("Table.focusCellForeground", Colors.WHITE);
		UIManager.put("Table.foreground", Colors.WHITE);
		UIManager.put("Table.gridColor", Colors.DARK_GRAY);
		UIManager.put("Table.selectionBackground", Colors.DARK_GRAY);
		UIManager.put("Table.selectionForeground", Colors.WHITE);
		UIManager.put("TableHeader.background", Colors.DARK_GRAY);
		UIManager.put("TableHeader.foreground", Colors.WHITE);
		UIManager.put("TextArea.background", Colors.DARK_GRAY);
		UIManager.put("TextArea.caretForeground", Colors.WHITE);
		UIManager.put("TextArea.foreground", Colors.WHITE);
		UIManager.put("TextArea.inactiveBackground", Colors.DARK_GRAY);
		UIManager.put("TextArea.inactiveForeground", Colors.WHITE);
		UIManager.put("TextArea.selectionBackground", Colors.DARK_GRAY);
		UIManager.put("TextArea.selectionForeground", Colors.WHITE);
		UIManager.put("TextComponent.selectionBackgroundInactive", Colors.DARK_GRAY);
		UIManager.put("TextField.background", Colors.DARK_GRAY);
		UIManager.put("TextField.caretForeground", Colors.WHITE);
		UIManager.put("TextField.darkShadow", Colors.DARK_GRAY);
		UIManager.put("TextField.foreground", Colors.WHITE);
		UIManager.put("TextField.highlight", Colors.DARK_GRAY);
		UIManager.put("TextField.inactiveBackground", Colors.DARK_GRAY);
		UIManager.put("TextField.inactiveForeground", Colors.WHITE);
		UIManager.put("TextField.light", Colors.DARK_GRAY);
		UIManager.put("TextField.selectionBackground", Colors.DARK_GRAY);
		UIManager.put("TextField.selectionForeground", Colors.WHITE);
		UIManager.put("TextField.shadow", Colors.DARK_GRAY);
		UIManager.put("TextPane.background", Colors.DARK_GRAY);
		UIManager.put("TextPane.caretForeground", Colors.WHITE);
		UIManager.put("TextPane.foreground", Colors.WHITE);
		UIManager.put("TextPane.inactiveBackground", Colors.DARK_GRAY);
		UIManager.put("TextPane.inactiveForeground", Colors.WHITE);
		UIManager.put("TextPane.selectionBackground", Colors.DARK_GRAY);
		UIManager.put("TextPane.selectionForeground", Colors.WHITE);
		UIManager.put("TitledBorder.titleColor", Colors.DARK_GRAY);
		UIManager.put("ToggleButton.background", Colors.DARK_GRAY);
		UIManager.put("ToggleButton.darkShadow", Colors.DARK_GRAY);
		UIManager.put("ToggleButton.disabledText", Colors.DARK_GRAY);
		UIManager.put("ToggleButton.foreground", Colors.WHITE);
		UIManager.put("ToggleButton.highlight", Colors.DARK_GRAY);
		UIManager.put("ToggleButton.light", Colors.DARK_GRAY);
		UIManager.put("ToggleButton.shadow", Colors.DARK_GRAY);
		UIManager.put("ToolBar.background", Colors.DARK_GRAY);
		UIManager.put("ToolBar.darkShadow", Colors.DARK_GRAY);
		UIManager.put("ToolBar.dockingBackground", Colors.DARK_GRAY);
		UIManager.put("ToolBar.dockingForeground", Colors.WHITE);
		UIManager.put("ToolBar.floatingBackground", Colors.DARK_GRAY);
		UIManager.put("ToolBar.floatingForeground", Colors.WHITE);
		UIManager.put("ToolBar.foreground", Colors.WHITE);
		UIManager.put("ToolBar.highlight", Colors.DARK_GRAY);
		UIManager.put("ToolBar.light", Colors.DARK_GRAY);
		UIManager.put("ToolBar.shadow", Colors.DARK_GRAY);
		UIManager.put("ToolTip.background", Colors.DARK_GRAY);
		UIManager.put("ToolTip.foreground", Colors.WHITE);
		UIManager.put("Tree.background", Colors.DARK_GRAY);
		UIManager.put("Tree.foreground", Colors.WHITE);
		UIManager.put("Tree.hash", Colors.DARK_GRAY);
		UIManager.put("Tree.line", Colors.DARK_GRAY);
		UIManager.put("Tree.selectionBackground", Colors.DARK_GRAY);
		UIManager.put("Tree.selectionBorderColor", Colors.DARK_GRAY);
		UIManager.put("Tree.selectionForeground", Colors.WHITE);
		UIManager.put("Tree.textBackground", Colors.DARK_GRAY);
		UIManager.put("Tree.textForeground", Colors.WHITE);
		UIManager.put("Viewport.background", Colors.DARK_GRAY);
		UIManager.put("Viewport.foreground", Colors.WHITE);
		UIManager.put("activeCaption", Colors.DARK_GRAY);
		UIManager.put("activeCaptionBorder", Colors.DARK_GRAY);
		UIManager.put("activeCaptionText", Colors.DARK_GRAY);
		UIManager.put("control", Colors.DARK_GRAY);
		UIManager.put("controlDkShadow", Colors.DARK_GRAY);
		UIManager.put("controlHighlight", Colors.DARK_GRAY);
		UIManager.put("controlLtHighlight", Colors.DARK_GRAY);
		UIManager.put("controlShadow", Colors.DARK_GRAY);
		UIManager.put("controlText", Colors.DARK_GRAY);
		UIManager.put("desktop", Colors.DARK_GRAY);
		UIManager.put("inactiveCaption", Colors.DARK_GRAY);
		UIManager.put("inactiveCaptionBorder", Colors.DARK_GRAY);
		UIManager.put("inactiveCaptionText", Colors.DARK_GRAY);
		UIManager.put("info", Colors.DARK_GRAY);
		UIManager.put("infoText", Colors.DARK_GRAY);
		UIManager.put("menu", Colors.DARK_GRAY);
		UIManager.put("menuText", Colors.DARK_GRAY);
		UIManager.put("scrollbar", Colors.DARK_GRAY);
		UIManager.put("text", Colors.DARK_GRAY);
		UIManager.put("textHighlight", Colors.DARK_GRAY);
		UIManager.put("textHighlightText", Colors.DARK_GRAY);
		UIManager.put("textInactiveText", Colors.DARK_GRAY);
		UIManager.put("textText", Colors.DARK_GRAY);
		UIManager.put("window", Colors.DARK_GRAY);
		UIManager.put("windowBorder", Colors.DARK_GRAY);
		UIManager.put("windowText", Colors.DARK_GRAY);
		UIManager.getLookAndFeelDefaults().put("OptionPane.okButtonText", "<html><b style=\"color:#6BFF56;\">OK");
		UIManager.getLookAndFeelDefaults().put("OptionPane.cancelButtonText",
				"<html><b style=\"color:#F34473;\">Cancel");
	}

}
