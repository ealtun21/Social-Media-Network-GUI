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
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.Dimension;

public class RegisterPage {

	private JFrame frmRegister;
	private JTextField nicknameField;
	private JPasswordField passwordField;

	// TODO IN WINDOWS
	// TODO FIX LINUX FONT RENDERING
	// TODO Profile Picture, Password comfirm
	
	private static final String FONT = "";
	private JTextField emailField;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField ageField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage window = new RegisterPage();
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					window.frmRegister.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegister = new JFrame();
		frmRegister.getContentPane().setFocusTraversalKeysEnabled(false);
		frmRegister.setResizable(false);
		frmRegister.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frmRegister.setTitle("Register");
		frmRegister.setBackground(Colors.DARK_GRAY);
		frmRegister.getContentPane().setBackground(Colors.DARK_GRAY);
		frmRegister.setBounds(100, 100, 340, 500);
		frmRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegister.getContentPane().setLayout(null);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Colors.RED);
		btnCancel.setFont(new Font(FONT, Font.BOLD, 16));
		btnCancel.setBackground(Colors.BLACK);
		btnCancel.setBounds(115, 430, 142, 29);
		frmRegister.getContentPane().add(btnCancel);
		
		JButton btnSignIn = new JButton("Register");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignIn.setForeground(Colors.GREEN);
		btnSignIn.setFont(new Font(FONT, Font.BOLD, 16));
		btnSignIn.setBackground(Colors.BLACK);
		btnSignIn.setBounds(115, 389, 142, 29);
		frmRegister.getContentPane().add(btnSignIn);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setFont(new Font(FONT, Font.PLAIN, 17));
		lblNickname.setForeground(Colors.WHITE);
		lblNickname.setBounds(42, 226, 142, 29);
		frmRegister.getContentPane().add(lblNickname);
		
		nicknameField = new JTextField();
		nicknameField.setHorizontalAlignment(SwingConstants.LEFT);
		nicknameField.setFont(new Font(FONT, Font.PLAIN, 17));
		nicknameField.setForeground(new Color(204, 199, 209));
		nicknameField.setColumns(10);
		nicknameField.setCaretColor(new Color(204, 199, 209));
		nicknameField.setBorder(null);
		nicknameField.setBackground(Colors.GRAY);
		nicknameField.setBounds(42, 259, 252, 29);
		frmRegister.getContentPane().add(nicknameField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(204, 199, 209));
		lblPassword.setFont(new Font(FONT, Font.PLAIN, 17));
		lblPassword.setBounds(42, 301, 142, 29);
		frmRegister.getContentPane().add(lblPassword);
		
		JLabel lblLogin = new JLabel("Register");
		lblLogin.setForeground(Colors.bluishwhite);
		lblLogin.setFont(new Font(FONT, Font.BOLD, 41));
		lblLogin.setBounds(12, 0, 182, 64);
		frmRegister.getContentPane().add(lblLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setCaretColor(Colors.WHITE);
		passwordField.setBackground(Colors.GRAY);
		passwordField.setForeground(Colors.WHITE);
		passwordField.setFont(new Font(FONT, Font.PLAIN, 17));
		passwordField.setBounds(42, 329, 224, 29);
		frmRegister.getContentPane().add(passwordField);
		
		JLabel nicknamePic = new JLabel("");
		nicknamePic.setIcon(new ImageIcon("IMG/LoginPage/user.png"));
		nicknamePic.setBounds(12, 259, 38, 29);
		frmRegister.getContentPane().add(nicknamePic);
		
		JLabel userPic = new JLabel("");
		userPic.setIcon(new ImageIcon("IMG/LoginPage/lock.png"));
		userPic.setSize(24, 29);
		userPic.setLocation(12, 329);
		frmRegister.getContentPane().add(userPic);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setIcon(new ImageIcon("IMG/LoginPage/hide.png"));
		chckbxNewCheckBox.setSelectedIcon(new ImageIcon("IMG/LoginPage/show.png"));
		chckbxNewCheckBox.setDisabledIcon(new ImageIcon("IMG/LoginPage/hide.png"));
		chckbxNewCheckBox.setForeground(Color.WHITE);
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
		chckbxNewCheckBox.setBounds(264, 329, 30, 29);
		frmRegister.getContentPane().add(chckbxNewCheckBox);

		
		emailField = new JTextField();
		emailField.setHorizontalAlignment(SwingConstants.LEFT);
		emailField.setForeground(new Color(204, 199, 209));
		emailField.setFont(new Font("Dialog", Font.PLAIN, 17));
		emailField.setColumns(10);
		emailField.setCaretColor(new Color(204, 199, 209));
		emailField.setBorder(null);
		emailField.setBackground(new Color(49, 63, 78));
		emailField.setBounds(42, 185, 252, 29);
		frmRegister.getContentPane().add(emailField);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(204, 199, 209));
		lblEmail.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblEmail.setBounds(42, 156, 142, 29);
		frmRegister.getContentPane().add(lblEmail);
		
		nameField = new JTextField();
		nameField.setHorizontalAlignment(SwingConstants.LEFT);
		nameField.setForeground(new Color(204, 199, 209));
		nameField.setFont(new Font("Dialog", Font.PLAIN, 17));
		nameField.setColumns(10);
		nameField.setCaretColor(new Color(204, 199, 209));
		nameField.setBorder(null);
		nameField.setBackground(new Color(49, 63, 78));
		nameField.setBounds(42, 115, 112, 29);
		frmRegister.getContentPane().add(nameField);
		
		JLabel lblRealName = new JLabel("Name");
		lblRealName.setForeground(new Color(204, 199, 209));
		lblRealName.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblRealName.setBounds(42, 86, 142, 29);
		frmRegister.getContentPane().add(lblRealName);
		
		JLabel lblRealSurname = new JLabel("Surname");
		lblRealSurname.setForeground(new Color(204, 199, 209));
		lblRealSurname.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblRealSurname.setBounds(156, 86, 74, 29);
		frmRegister.getContentPane().add(lblRealSurname);
		
		surnameField = new JTextField();
		surnameField.setHorizontalAlignment(SwingConstants.LEFT);
		surnameField.setForeground(new Color(204, 199, 209));
		surnameField.setFont(new Font("Dialog", Font.PLAIN, 17));
		surnameField.setColumns(10);
		surnameField.setCaretColor(new Color(204, 199, 209));
		surnameField.setBorder(null);
		surnameField.setBackground(new Color(49, 63, 78));
		surnameField.setBounds(156, 115, 101, 29);
		frmRegister.getContentPane().add(surnameField);
		
		ageField = new JTextField();
		ageField.setHorizontalAlignment(SwingConstants.LEFT);
		ageField.setForeground(new Color(204, 199, 209));
		ageField.setFont(new Font("Dialog", Font.PLAIN, 17));
		ageField.setColumns(10);
		ageField.setCaretColor(new Color(204, 199, 209));
		ageField.setBorder(null);
		ageField.setBackground(new Color(49, 63, 78));
		ageField.setBounds(259, 115, 35, 29);
		frmRegister.getContentPane().add(ageField);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(new Color(204, 199, 209));
		lblAge.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblAge.setBounds(260, 86, 74, 29);
		frmRegister.getContentPane().add(lblAge);
		
		JLabel emailPic = new JLabel("");
		emailPic.setIcon(new ImageIcon("IMG/LoginPage/envelope.png"));
		emailPic.setBounds(12, 185, 38, 29);
		frmRegister.getContentPane().add(emailPic);
		
		JLabel realDataPic = new JLabel("");
		realDataPic.setIcon(new ImageIcon("IMG/LoginPage/real_name.png"));
		realDataPic.setBounds(12, 115, 38, 29);
		frmRegister.getContentPane().add(realDataPic);
	}
}
