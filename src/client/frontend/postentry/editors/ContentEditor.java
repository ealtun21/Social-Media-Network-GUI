/**
 * Starts a window that is used to edit contents.
 */
package client.frontend.postentry.editors;

import client.backend.Content;
import client.backend.User;
import client.frontend.Colors;
import client.frontend.Refreshable;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ContentEditor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JEditorPane editorPane;
	private JLabel image;

	/**
	 * Create the panel.
	 * 
	 * @param refreshable Any class that implements Refreshable is given, Classes that
	 *                    implements Refreshable are refreshable meaning that they
	 *                    will update their panels with the new content once the
	 *                    refresh method is called.
	 * @param user        The logged in user
	 * 
	 * @param content     The content that is being modified.
	 */
	public ContentEditor(Refreshable refreshable, User user, Content content) {
		setType(Type.UTILITY);
		setAlwaysOnTop(true);
		setTitle("Create Content");
		getContentPane().setBackground(Colors.DARK_GRAY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 700);
		getContentPane().setLayout(null);

		editorPane = new JEditorPane();
		editorPane.setText(content.getText());
		editorPane.setBackground(Colors.GRAY);
		editorPane.setForeground(Colors.WHITE);
		editorPane.setCaretColor(Colors.WHITE);
		editorPane.setBorder(null);
		editorPane.setBounds(12, 282, 376, 377);
		getContentPane().add(editorPane);

		image = new JLabel("");
		if (content.getImage() != null) {
			image.setIcon(content.getImage());
		}
		image.setBounds(266, 101, 128, 128);
		getContentPane().add(image);

		JButton btnChooseImage = new JButton("Choose Image");
		btnChooseImage.addActionListener(new ActionListener() {
			/**
			 * Choose file method, opens JFileChooser in the home folder, picks file. If the
			 * file is correctly picked, checks if the file is an image, then if it is sets
			 * it as the contents picture with 128x128 smooth scaling. If it's not an image
			 * uses JOptionPane to give the corresponding error message. If an unexpected
			 * error occurs printStackTrace.
			 * 
			 * This does not set the users image directly, instead it sets the "image"
			 * (variable) later, if the user wishes to save changes, then it is applied to
			 * the user.
			 */
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				if (file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File selectedFile = file.getSelectedFile();
					try {
						if (ImageIO.read(file.getSelectedFile()) != null) {
							image.setIcon(new ImageIcon(new ImageIcon(selectedFile.getAbsolutePath()).getImage()
									.getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH)));
						} else {
							JOptionPane.showMessageDialog(null, "Please select an image!", "Invalid Image",
									JOptionPane.PLAIN_MESSAGE);
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnChooseImage.setForeground(Colors.CYAN);
		btnChooseImage.setFont(new Font("Dialog", Font.BOLD, 12));
		btnChooseImage.setFocusPainted(false);
		btnChooseImage.setBackground(new Color(22, 28, 35));
		btnChooseImage.setBounds(254, 241, 134, 29);
		getContentPane().add(btnChooseImage);

		JLabel lblContentText = new JLabel("Content Text");
		lblContentText.setFont(new Font("Dialog", Font.BOLD, 17));
		lblContentText.setForeground(new Color(204, 199, 209));
		lblContentText.setBounds(12, 258, 122, 23);
		getContentPane().add(lblContentText);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			/*
			 * Saves the Content
			 * 
			 * Validation is not required as an empty content is allowed and the title can
			 * not modified.
			 * 
			 */
			public void actionPerformed(ActionEvent e) {
				content.setText(editorPane.getText());
				content.setImage(image.getIcon());
				refreshable.refresh();
				dispose();
			}
		});
		btnSave.setForeground(Colors.GREEN);
		btnSave.setFont(new Font("Dialog", Font.BOLD, 14));
		btnSave.setFocusPainted(false);
		btnSave.setBackground(new Color(22, 28, 35));
		btnSave.setBounds(12, 94, 112, 29);
		getContentPane().add(btnSave);

		JLabel lblCreateContent = new JLabel("Edit Content");
		lblCreateContent.setForeground(new Color(204, 199, 209));
		lblCreateContent.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCreateContent.setBounds(42, 15, 159, 37);
		getContentPane().add(lblCreateContent);

		JButton btnRemoveImage = new JButton("Del Image");
		btnRemoveImage.addActionListener(new ActionListener() {
			/**
			 * Removes the image from the image, NOTE does not remove from the content until
			 * saved.
			 */
			public void actionPerformed(ActionEvent e) {
				image.setIcon(null);
			}
		});
		btnRemoveImage.setForeground(Colors.PINK);
		btnRemoveImage.setFont(new Font("Dialog", Font.BOLD, 12));
		btnRemoveImage.setFocusPainted(false);
		btnRemoveImage.setBackground(new Color(22, 28, 35));
		btnRemoveImage.setBounds(143, 241, 99, 29);
		getContentPane().add(btnRemoveImage);

		JButton btnDiscard = new JButton("Discard");
		btnDiscard.addActionListener(new ActionListener() {
			/*
			 * Discard the content, does not save.
			 */
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnDiscard.setForeground(new Color(243, 68, 115));
		btnDiscard.setFont(new Font("Dialog", Font.BOLD, 14));
		btnDiscard.setFocusPainted(false);
		btnDiscard.setBackground(new Color(22, 28, 35));
		btnDiscard.setBounds(136, 94, 112, 29);
		getContentPane().add(btnDiscard);

		JButton btnDelete = new JButton("Delete Content");
		btnDelete.addActionListener(new ActionListener() {
			/*
			 * Deletes the content, refreshes, closes the editor.
			 */
			public void actionPerformed(ActionEvent e) {
				Content.dispose(content);
				refreshable.refresh();
				dispose();
			}
		});
		btnDelete.setForeground(Colors.RED.darker());
		btnDelete.setFont(new Font("Dialog", Font.BOLD, 14));
		btnDelete.setFocusPainted(false);
		btnDelete.setBackground(new Color(22, 28, 35));
		btnDelete.setBounds(12, 135, 239, 29);
		getContentPane().add(btnDelete);
		setVisible(false);
	}

	/**
	 * Checks if the title is already used. NOTE: Titles are unique.
	 * 
	 * 
	 * @param title The title that will be checked
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
