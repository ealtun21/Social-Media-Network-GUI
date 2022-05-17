package client.frontend.postentry.creators;

import client.backend.Content;
import client.backend.User;
import client.backend.UserGroup;
import client.frontend.Colors;
import client.frontend.Refreshable;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class GroupContentCreator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField titleField;
	private JEditorPane editorPane;
	private JLabel image;

	/**
	 * Create the panel.
	 * @param homepage 
	 * 
	 * @param user
	 */
	public GroupContentCreator(Refreshable refreshable, User user, UserGroup group) {
		setType(Type.UTILITY);
		setAlwaysOnTop(true);
		setTitle("Create Content");
		getContentPane().setBackground(Colors.DARK_GRAY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 700);
		getContentPane().setLayout(null);

		editorPane = new JEditorPane();
		editorPane.setBackground(Colors.GRAY);
		editorPane.setForeground(Colors.WHITE);
		editorPane.setCaretColor(Colors.WHITE);
		editorPane.setBorder(null);
		editorPane.setBounds(12, 282, 376, 377);
		getContentPane().add(editorPane);

		image = new JLabel("");
		image.setBounds(266, 101, 128, 128);
		getContentPane().add(image);

		JButton btnChooseImage = new JButton("Choose Image");
		btnChooseImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				if (file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File selectedFile = file.getSelectedFile();
					image.setIcon(new ImageIcon(new ImageIcon(selectedFile.getAbsolutePath()).getImage()
							.getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH)));
				}
			}
		});
		btnChooseImage.setForeground(Colors.CYAN);
		btnChooseImage.setFont(new Font("Dialog", Font.BOLD, 12));
		btnChooseImage.setFocusPainted(false);
		btnChooseImage.setBackground(new Color(22, 28, 35));
		btnChooseImage.setBounds(266, 241, 122, 29);
		getContentPane().add(btnChooseImage);

		JLabel lblContentText = new JLabel("Content Text");
		lblContentText.setFont(new Font("Dialog", Font.BOLD, 17));
		lblContentText.setForeground(new Color(204, 199, 209));
		lblContentText.setBounds(12, 258, 122, 23);
		getContentPane().add(lblContentText);

		titleField = new JTextField();
		titleField.setBorder(null);
		titleField.setForeground(Colors.WHITE);
		titleField.setBackground(Colors.GRAY);
		titleField.setCaretColor(Colors.WHITE);
		titleField.setBounds(12, 183, 189, 23);
		getContentPane().add(titleField);
		titleField.setColumns(10);

		JLabel lblContentTitle = new JLabel("Content Title");
		lblContentTitle.setForeground(Colors.WHITE);
		lblContentTitle.setBounds(12, 160, 88, 23);
		getContentPane().add(lblContentTitle);

		JButton btnPublish = new JButton("Publish");
		btnPublish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (titleField.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Title cannot be empty!", "Invalid Title", JOptionPane.PLAIN_MESSAGE);
					return;
				}
				if (image.getIcon() != null) {
					if (!isTitleUsed(titleField)) {
						Content content = new Content(titleField.getText(), editorPane.getText(), user);
						content.setImage(image.getIcon());
						user.newConent(content); // Add Group content to user's conent page as well.
						group.newConent(content);
						refreshable.refresh(user);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "This title was already used", "Invalid Title", JOptionPane.PLAIN_MESSAGE);
					}
				} else {
					if (!isTitleUsed(titleField)) {
						Content content = new Content(titleField.getText(), editorPane.getText(), user);
						user.newConent(content);  // Add Group content to user's conent page as well.
						group.newConent(content);
						refreshable.refresh(user);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "This title was already used", "Invalid Title", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
		});
		btnPublish.setForeground(Colors.GREEN);
		btnPublish.setFont(new Font("Dialog", Font.BOLD, 14));
		btnPublish.setFocusPainted(false);
		btnPublish.setBackground(new Color(22, 28, 35));
		btnPublish.setBounds(12, 64, 112, 29);
		getContentPane().add(btnPublish);

		JLabel lblCreateContent = new JLabel("Create Content");
		lblCreateContent.setForeground(new Color(204, 199, 209));
		lblCreateContent.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCreateContent.setBounds(50, 15, 159, 37);
		getContentPane().add(lblCreateContent);

		JButton btnDiscard = new JButton("Discard");
		btnDiscard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnDiscard.setForeground(Colors.RED);
		btnDiscard.setFont(new Font("Dialog", Font.BOLD, 14));
		btnDiscard.setFocusPainted(false);
		btnDiscard.setBackground(new Color(22, 28, 35));
		btnDiscard.setBounds(131, 64, 112, 29);
		getContentPane().add(btnDiscard);
		setVisible(false);
	}

	/**
	 * 
	 * @param title
	 * @return returns true is title is used, false if not used. 
	 */
	protected boolean isTitleUsed(JTextField title) {
		for (User user : User.getAllUsers()) {
			if (user.getConentPersonal() == null) {
				return false;
			}
			for (Content content : user.getConentPersonal()) {
				if (title.getText().equals(content.getTitle())) {
					return true;
				}
			}
		}
		return false;
	}

}
