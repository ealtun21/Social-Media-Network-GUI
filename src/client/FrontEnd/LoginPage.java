package client.FrontEnd;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import client.BackEnd.Colors;
import client.BackEnd.User;
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

	// TODO IN WINDOWS
	// TODO FIX LINUX FONT RENDERING

	private static final String FONT = "Arial";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
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
		btnCancel.addActionListener(new ActionListener() {
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
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (User user : User.getAllUsers()) {
					if (Arrays.equals(passwordField.getPassword(), user.getPassword())
							&& user.getNickname().equals(nicknameField.getText())) {
						JOptionPane.showMessageDialog(null, "Logged in!", "Logged In", JOptionPane.PLAIN_MESSAGE);
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "Invalid password or nickname", "Could not login",
						JOptionPane.PLAIN_MESSAGE);

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
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					RegisterPage register = new RegisterPage();
					register.setVisible(true);
					frmLogin.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
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
		facePic.setIcon(new ImageIcon("IMG/LoginPage/face.png"));
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

		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setIcon(new ImageIcon("IMG/LoginPage/hide.png"));
		chckbxNewCheckBox.setSelectedIcon(new ImageIcon("IMG/LoginPage/show.png"));
		chckbxNewCheckBox.setDisabledIcon(new ImageIcon("IMG/LoginPage/hide.png"));
		chckbxNewCheckBox.setForeground(Color.WHITE);
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (passwordField.getEchoChar() == '•') {
					passwordField.setEchoChar((char) 0); // password = JPasswordField
				} else {
					passwordField.setEchoChar('•');
				}
			}
		});
		chckbxNewCheckBox.setBackground(Colors.GRAY);
		chckbxNewCheckBox.setBounds(281, 254, 30, 29);
		frmLogin.getContentPane().add(chckbxNewCheckBox);
	}

	public void setVisible(boolean b) {
		frmLogin.setVisible(b);
	}
}
