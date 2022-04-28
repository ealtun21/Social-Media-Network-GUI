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

public class LoginPage {

	private JFrame frmLogin;
	private JTextField textField_1;
	private JPasswordField passwordField;

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
		btnCancel.setFont(new Font("Verdana", Font.BOLD, 16));
		btnCancel.setBackground(Colors.BLACK);
		btnCancel.setBounds(115, 332, 142, 29);
		frmLogin.getContentPane().add(btnCancel);
		
		JButton btnLogin = new JButton("Sign in");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setForeground(Colors.WHITE);
		btnLogin.setFont(new Font("Verdana", Font.BOLD, 16));
		btnLogin.setBackground(Colors.BLACK);
		btnLogin.setBounds(115, 293, 142, 29);
		frmLogin.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("Nickname");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setForeground(Colors.WHITE);
		lblNewLabel.setBounds(59, 137, 142, 29);
		frmLogin.getContentPane().add(lblNewLabel);
		
		JButton btnRegister = new JButton("Sign up");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegister.setForeground(Colors.WHITE);
		btnRegister.setFont(new Font("Verdana", Font.BOLD, 16));
		btnRegister.setBackground(Colors.BLACK);
		btnRegister.setBounds(169, 424, 142, 29);
		frmLogin.getContentPane().add(btnRegister);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setForeground(new Color(204, 199, 209));
		textField_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		textField_1.setColumns(10);
		textField_1.setCaretColor(new Color(204, 199, 209));
		textField_1.setBorder(null);
		textField_1.setBackground(Colors.GRAY);
		textField_1.setBounds(59, 176, 252, 29);
		frmLogin.getContentPane().add(textField_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(204, 199, 209));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(59, 215, 142, 29);
		frmLogin.getContentPane().add(lblPassword);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setForeground(Colors.bluishwhite);
		lblNewLabel_1.setFont(new Font("Maiandra GD", Font.BOLD, 41));
		lblNewLabel_1.setBounds(10, 33, 119, 94);
		frmLogin.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setCaretColor(Colors.WHITE);
		passwordField.setBackground(Colors.GRAY);
		passwordField.setForeground(Colors.WHITE);
		passwordField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		passwordField.setBounds(59, 254, 252, 29);
		frmLogin.getContentPane().add(passwordField);
		
		JLabel pic1 = new JLabel("");
		ImageIcon imageFace = new ImageIcon("face.png");
		pic1.setIcon(imageFace);
		pic1.setBounds(169, 10, 142, 156);
		frmLogin.getContentPane().add(pic1);
	}

	protected Color getFrmLoginContentPaneBackground() {
		return frmLogin.getContentPane().getBackground();
	}
	protected void setFrmLoginContentPaneBackground(Color background) {
		frmLogin.getContentPane().setBackground(background);
	}
}
