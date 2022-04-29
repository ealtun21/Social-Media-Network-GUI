package client;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
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
	private static final String FONT = "Source Code Pro";
	
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		btnCancel.setForeground(Colors.WHITE);
		btnCancel.setFont(new Font(FONT, Font.BOLD, 16));
		btnCancel.setBackground(Colors.BLACK);
		btnCancel.setBounds(115, 346, 142, 29);
		frmLogin.getContentPane().add(btnCancel);
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignIn.setForeground(Colors.WHITE);
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
			}
		});
		btnRegister.setForeground(Colors.WHITE);
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
		facePic.setIcon(new ImageIcon("face.png"));
		facePic.setBounds(169, 10, 142, 156);
		frmLogin.getContentPane().add(facePic);
		
		JLabel nicknamePic = new JLabel("");
		nicknamePic.setIcon(new ImageIcon("user.png"));
		nicknamePic.setBounds(26, 176, 24, 29);
		frmLogin.getContentPane().add(nicknamePic);
		
		JLabel userPic = new JLabel("");
		userPic.setIcon(new ImageIcon("lock.png"));
		userPic.setSize(24, 24);
		userPic.setLocation(26, 254);
		frmLogin.getContentPane().add(userPic);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (passwordField.getEchoChar() == '•') {
					   passwordField.setEchoChar((char)0); //password = JPasswordField
				   } else {
					   passwordField.setEchoChar('•');
				   }
				}
		});
		chckbxNewCheckBox.setBackground(Colors.GRAY);
		chckbxNewCheckBox.setBounds(281, 254, 30, 29);
		frmLogin.getContentPane().add(chckbxNewCheckBox);
	}
}
