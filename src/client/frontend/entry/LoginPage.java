/**
 * The JFrame that opens in order to login or open the RegisterPage, if the user doesn't have an account.
 */
package client.frontend.entry;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import client.backend.User;
import client.frontend.Colors;
import client.frontend.Dashboard;

import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class LoginPage {

	private JFrame frmLogin;
	private JTextField nicknameField;
	private JPasswordField passwordField;

	private static final String FONT = "Arial";

	/**
	 * Create the application.
	 */
	public LoginPage() {
		// Sets theme for all windows opened by login
		setTheme();

		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frmLogin.setTitle("Login");
		frmLogin.setBackground(Colors.DARK_GRAY);
		frmLogin.getContentPane().setBackground(Colors.DARK_GRAY);
		frmLogin.setBounds(100, 100, 340, 500);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFocusPainted(false);
		btnCancel.addActionListener(new ActionListener() {
			/**
			 * When button is clicked, closes the application.
			 * 
			 */
			public void actionPerformed(ActionEvent e) {
				frmLogin.dispose();
			}
		});
		btnCancel.setForeground(Colors.RED);
		btnCancel.setFont(new Font(FONT, Font.BOLD, 16));
		btnCancel.setBackground(Colors.BLACK);
		btnCancel.setBounds(115, 346, 142, 29);
		frmLogin.getContentPane().add(btnCancel);

		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.setFocusPainted(false);
		btnSignIn.addActionListener(new ActionListener() {
			/**
			 * When button is clicked, starts the main JFrame, and closes this window.
			 * 
			 */
			public void actionPerformed(ActionEvent e) {
				startDashboard();
			}
		});
		btnSignIn.setForeground(Colors.GREEN);
		btnSignIn.setFont(new Font(FONT, Font.BOLD, 16));
		btnSignIn.setBackground(Colors.BLACK);
		btnSignIn.setBounds(115, 305, 142, 29);
		frmLogin.getContentPane().add(btnSignIn);

		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setFont(new Font(FONT, Font.PLAIN, 17));
		lblNickname.setForeground(Colors.WHITE);
		lblNickname.setBounds(59, 137, 142, 29);
		frmLogin.getContentPane().add(lblNickname);

		JButton btnRegister = new JButton("Sign up");
		btnRegister.setFocusPainted(false);
		btnRegister.addActionListener(new ActionListener() {
			/**
			 * When button is clicked, creates new RegisterPage, starts the register page.
			 */
			public void actionPerformed(ActionEvent e) {
				RegisterPage register = new RegisterPage();
				register.setVisible(true);
				frmLogin.dispose();
			}
		});
		btnRegister.setForeground(Colors.BLUE);
		btnRegister.setFont(new Font(FONT, Font.BOLD, 16));
		btnRegister.setBackground(Colors.BLACK);
		btnRegister.setBounds(169, 424, 142, 29);
		frmLogin.getContentPane().add(btnRegister);

		nicknameField = new JTextField();
		nicknameField.setHorizontalAlignment(SwingConstants.LEFT);
		nicknameField.setFont(new Font(FONT, Font.PLAIN, 17));
		nicknameField.setForeground(new Color(204, 199, 209));
		nicknameField.setColumns(10);
		nicknameField.setCaretColor(new Color(204, 199, 209));
		nicknameField.setBorder(null);
		nicknameField.setBackground(Colors.GRAY);
		nicknameField.setBounds(59, 176, 252, 29);
		frmLogin.getContentPane().add(nicknameField);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(204, 199, 209));
		lblPassword.setFont(new Font(FONT, Font.PLAIN, 17));
		lblPassword.setBounds(59, 215, 142, 29);
		frmLogin.getContentPane().add(lblPassword);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Colors.bluishwhite);
		lblLogin.setFont(new Font(FONT, Font.BOLD, 41));
		lblLogin.setBounds(10, 33, 147, 94);
		frmLogin.getContentPane().add(lblLogin);

		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setCaretColor(Colors.WHITE);
		passwordField.setBackground(Colors.GRAY);
		passwordField.setForeground(Colors.WHITE);
		passwordField.setFont(new Font(FONT, Font.PLAIN, 17));
		passwordField.setBounds(59, 254, 223, 29);
		frmLogin.getContentPane().add(passwordField);

		JLabel facePic = new JLabel("");
		facePic.setIcon(new ImageIcon(new ImageIcon("IMG/LoginPage/network.png").getImage().getScaledInstance(128, 128,
				java.awt.Image.SCALE_SMOOTH)));
		facePic.setBounds(169, 10, 142, 156);
		frmLogin.getContentPane().add(facePic);

		JLabel nicknamePic = new JLabel("");
		nicknamePic.setIcon(new ImageIcon("IMG/LoginPage/user.png"));
		nicknamePic.setBounds(26, 176, 24, 29);
		frmLogin.getContentPane().add(nicknamePic);

		JLabel userPic = new JLabel("");
		userPic.setIcon(new ImageIcon("IMG/LoginPage/lock.png"));
		userPic.setSize(24, 24);
		userPic.setLocation(26, 254);
		frmLogin.getContentPane().add(userPic);

		JCheckBox showUnshow = new JCheckBox("");
		showUnshow.setIcon(new ImageIcon("IMG/LoginPage/hide.png"));
		showUnshow.setSelectedIcon(new ImageIcon("IMG/LoginPage/show.png"));
		showUnshow.setDisabledIcon(new ImageIcon("IMG/LoginPage/hide.png"));
		showUnshow.setForeground(Color.WHITE);
		showUnshow.addActionListener(new ActionListener() {
			/**
			 * When the hide/show button is pressed, changes echo char if password field in
			 * order to enable actually seeing the password.
			 */
			public void actionPerformed(ActionEvent e) {
				if (passwordField.getEchoChar() == '•') {
					passwordField.setEchoChar((char) 0); // password = JPasswordField
				} else {
					passwordField.setEchoChar('•');
				}
			}
		});
		showUnshow.setBackground(Colors.GRAY);
		showUnshow.setBounds(281, 254, 30, 29);
		frmLogin.getContentPane().add(showUnshow);
	}

	/**
	 * Sets the window visible state.
	 * 
	 * @param b true or false depending on whether you want the window to be
	 *          visible.
	 */
	public void setVisible(boolean b) {
		frmLogin.setVisible(b);
	}

	/**
	 * Starts the programs main JFrame. If the password doesn't match the given user
	 * opens JOptionPane.
	 */
	public void startDashboard() {
		for (User user : User.getAllUsers()) {
			if (Arrays.equals(passwordField.getPassword(), user.getPasswordChr())
					&& user.getNickname().equals(nicknameField.getText())) {
				Dashboard frame = new Dashboard(user, this); // Dashboard takes "this" in order to set the visible state
																// of this window back to true, when logging out.
																// user is given in order to specify the user that is
																// logged in.
				frame.setVisible(true);
				setVisible(false);
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "Invalid password or nickname", "Could not login",
				JOptionPane.PLAIN_MESSAGE);
	}

	/**
	 * Sets most of the external UI's colors.
	 * 
	 * list of all UImanager that have colors is from
	 * https://alvinalexander.com/java/java-uimanager-color-keys-list/.
	 */
	private void setTheme() {
		UIManager.put("Button.background", Colors.DARK_GRAY);
		UIManager.put("Button.darkShadow", Colors.BLACK);
		UIManager.put("Button.disabledText", Colors.LIGHT_GRAY);
		UIManager.put("Button.foreground", Colors.WHITE);
		UIManager.put("Button.highlight", Colors.YELLOW);
		UIManager.put("Button.light", Colors.DARK_GRAY);
		UIManager.put("Button.select", null);
		UIManager.put("Button.shadow", Colors.WHITE);
		UIManager.put("CheckBox.background", Colors.DARK_GRAY);
		UIManager.put("CheckBox.disabledText", Colors.DARK_GRAY);
		UIManager.put("CheckBox.foreground", Colors.WHITE);
		UIManager.put("CheckBox.select", null);
		UIManager.put("CheckBoxMenuItem.acceleratorForeground", Colors.WHITE);
		UIManager.put("CheckBoxMenuItem.acceleratorSelectionForeground", null);
		UIManager.put("CheckBoxMenuItem.background", Colors.DARK_GRAY);
		UIManager.put("CheckBoxMenuItem.disabledBackground", Colors.DARK_GRAY);
		UIManager.put("CheckBoxMenuItem.disabledForeground", Colors.WHITE);
		UIManager.put("CheckBoxMenuItem.foreground", Colors.WHITE);
		UIManager.put("CheckBoxMenuItem.selectionBackground", null);
		UIManager.put("CheckBoxMenuItem.selectionForeground", null);
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
		UIManager.put("ComboBox.selectionBackground", null);
		UIManager.put("ComboBox.selectionForeground", null);
		UIManager.put("Desktop.background", Colors.DARK_GRAY);
		UIManager.put("EditorPane.background", Colors.DARK_GRAY);
		UIManager.put("EditorPane.caretForeground", Colors.WHITE);
		UIManager.put("EditorPane.foreground", Colors.WHITE);
		UIManager.put("EditorPane.inactiveBackground", Colors.DARK_GRAY);
		UIManager.put("EditorPane.inactiveForeground", Colors.WHITE);
		UIManager.put("EditorPane.selectionBackground", null);
		UIManager.put("EditorPane.selectionForeground", null);
		UIManager.put("Focus.color", Colors.DARK_GRAY);
		UIManager.put("FormattedTextField.background", Colors.DARK_GRAY);
		UIManager.put("FormattedTextField.caretForeground", Colors.WHITE);
		UIManager.put("FormattedTextField.foreground", Colors.WHITE);
		UIManager.put("FormattedTextField.inactiveBackground", Colors.DARK_GRAY);
		UIManager.put("FormattedTextField.inactiveForeground", Colors.WHITE);
		UIManager.put("FormattedTextField.selectionBackground", null);
		UIManager.put("FormattedTextField.selectionForeground", null);
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
		UIManager.put("List.selectionBackground", null);
		UIManager.put("List.selectionForeground", null);
		UIManager.put("Menu.acceleratorForeground", Colors.WHITE);
		UIManager.put("Menu.acceleratorSelectionForeground", null);
		UIManager.put("Menu.background", Colors.DARK_GRAY);
		UIManager.put("Menu.disabledBackground", Colors.DARK_GRAY);
		UIManager.put("Menu.disabledForeground", Colors.WHITE);
		UIManager.put("Menu.foreground", Colors.WHITE);
		UIManager.put("Menu.selectionBackground", null);
		UIManager.put("Menu.selectionForeground", null);
		UIManager.put("MenuBar.background", Colors.DARK_GRAY);
		UIManager.put("MenuBar.disabledBackground", Colors.DARK_GRAY);
		UIManager.put("MenuBar.disabledForeground", Colors.WHITE);
		UIManager.put("MenuBar.foreground", Colors.WHITE);
		UIManager.put("MenuBar.highlight", Colors.DARK_GRAY);
		UIManager.put("MenuBar.selectionBackground", null);
		UIManager.put("MenuBar.selectionForeground", null);
		UIManager.put("MenuBar.shadow", Colors.DARK_GRAY);
		UIManager.put("MenuItem.acceleratorForeground", Colors.WHITE);
		UIManager.put("MenuItem.acceleratorSelectionForeground", null);
		UIManager.put("MenuItem.background", Colors.DARK_GRAY);
		UIManager.put("MenuItem.disabledBackground", Colors.DARK_GRAY);
		UIManager.put("MenuItem.disabledForeground", Colors.WHITE);
		UIManager.put("MenuItem.foreground", Colors.WHITE);
		UIManager.put("MenuItem.selectionBackground", null);
		UIManager.put("MenuItem.selectionForeground", null);
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
		UIManager.put("PasswordField.selectionBackground", null);
		UIManager.put("PasswordField.selectionForeground", null);
		UIManager.put("PopupMenu.background", Colors.DARK_GRAY);
		UIManager.put("PopupMenu.foreground", Colors.WHITE);
		UIManager.put("PopupMenu.selectionBackground", null);
		UIManager.put("PopupMenu.selectionForeground", null);
		UIManager.put("ProgressBar.background", Colors.DARK_GRAY);
		UIManager.put("ProgressBar.foreground", Colors.WHITE);
		UIManager.put("ProgressBar.selectionBackground", null);
		UIManager.put("ProgressBar.selectionForeground", null);
		UIManager.put("RadioButton.background", Colors.DARK_GRAY);
		UIManager.put("RadioButton.darkShadow", Colors.DARK_GRAY);
		UIManager.put("RadioButton.disabledText", Colors.DARK_GRAY);
		UIManager.put("RadioButton.foreground", Colors.WHITE);
		UIManager.put("RadioButton.highlight", Colors.DARK_GRAY);
		UIManager.put("RadioButton.light", Colors.DARK_GRAY);
		UIManager.put("RadioButton.select", null);
		UIManager.put("RadioButton.shadow", Colors.DARK_GRAY);
		UIManager.put("RadioButtonMenuItem.acceleratorForeground", Colors.WHITE);
		UIManager.put("RadioButtonMenuItem.acceleratorSelectionForeground", null);
		UIManager.put("RadioButtonMenuItem.background", Colors.DARK_GRAY);
		UIManager.put("RadioButtonMenuItem.disabledBackground", Colors.DARK_GRAY);
		UIManager.put("RadioButtonMenuItem.disabledForeground", Colors.WHITE);
		UIManager.put("RadioButtonMenuItem.foreground", Colors.WHITE);
		UIManager.put("RadioButtonMenuItem.selectionBackground", null);
		UIManager.put("RadioButtonMenuItem.selectionForeground", null);
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
		UIManager.put("Table.selectionBackground", null);
		UIManager.put("Table.selectionForeground", null);
		UIManager.put("TableHeader.background", Colors.DARK_GRAY);
		UIManager.put("TableHeader.foreground", Colors.WHITE);
		UIManager.put("TextArea.background", Colors.DARK_GRAY);
		UIManager.put("TextArea.caretForeground", Colors.WHITE);
		UIManager.put("TextArea.foreground", Colors.WHITE);
		UIManager.put("TextArea.inactiveBackground", Colors.DARK_GRAY);
		UIManager.put("TextArea.inactiveForeground", Colors.WHITE);
		UIManager.put("TextArea.selectionBackground", null);
		UIManager.put("TextArea.selectionForeground", null);
		UIManager.put("TextComponent.selectionBackgroundInactive", null);
		UIManager.put("TextField.background", Colors.DARK_GRAY);
		UIManager.put("TextField.caretForeground", Colors.WHITE);
		UIManager.put("TextField.darkShadow", Colors.DARK_GRAY);
		UIManager.put("TextField.foreground", Colors.WHITE);
		UIManager.put("TextField.highlight", Colors.DARK_GRAY);
		UIManager.put("TextField.inactiveBackground", Colors.DARK_GRAY);
		UIManager.put("TextField.inactiveForeground", Colors.WHITE);
		UIManager.put("TextField.light", Colors.DARK_GRAY);
		UIManager.put("TextField.selectionBackground", null);
		UIManager.put("TextField.selectionForeground", null);
		UIManager.put("TextField.shadow", Colors.DARK_GRAY);
		UIManager.put("TextPane.background", Colors.DARK_GRAY);
		UIManager.put("TextPane.caretForeground", Colors.WHITE);
		UIManager.put("TextPane.foreground", Colors.WHITE);
		UIManager.put("TextPane.inactiveBackground", Colors.DARK_GRAY);
		UIManager.put("TextPane.inactiveForeground", Colors.WHITE);
		UIManager.put("TextPane.selectionBackground", null);
		UIManager.put("TextPane.selectionForeground", null);
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
		UIManager.put("Tree.selectionBackground", null);
		UIManager.put("Tree.selectionBorderColor", null);
		UIManager.put("Tree.selectionForeground", null);
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
