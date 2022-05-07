package client.FrontEnd.Main.Viewers;

import javax.swing.JPanel;
import client.BackEnd.Colors;
import client.BackEnd.Content;
import client.BackEnd.Refreshable;
import client.BackEnd.User;
import client.FrontEnd.Main.Editors.ContentEditor;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.time.format.DateTimeFormatter;
import javax.swing.JTextPane;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ContentViewer extends JPanel {

	private static final long serialVersionUID = 1L;
	
	
	private String title;
	/**
	 * Create the panel.
	 */
	public ContentViewer(Refreshable refreshable, User user, Content content) {
		title = content.getTitle();
		
		setPreferredSize(new Dimension(400, 200));
		setBorder(null);
		setVisible(true);
		setBackground(Colors.DARK_GRAY);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JLabel contentPic = new JLabel("");
		contentPic.setVerticalTextPosition(SwingConstants.TOP);
		contentPic.setVerticalAlignment(SwingConstants.TOP);
		contentPic.setIcon(content.getImage());
		add(contentPic);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		add(scrollPane);

		JTextPane textPane = new JTextPane();
		textPane.setPreferredSize(new Dimension(39, 23));
		textPane.setFont(new Font("Dialog", Font.PLAIN, 14));
		textPane.setCaretColor(Colors.WHITE);
		textPane.setForeground(Colors.WHITE);
		textPane.setBackground(Colors.GRAY);
		textPane.setText(content.getText());
		scrollPane.setViewportView(textPane);

		JLabel title = new JLabel(content.getTitle() + "     "
				+ content.getTime().format(DateTimeFormatter.ofPattern("dd-MM yyyy HH:mm")));
		scrollPane.setColumnHeaderView(title);
		title.setForeground(Colors.WHITE);
		title.setFont(new Font("Dialog", Font.BOLD, 17));

		JButton btnEdit = new JButton("<html>E<p>D</p><p>I</p><p>T</p></html>\n");
		btnEdit.setVerticalTextPosition(SwingConstants.TOP);
		btnEdit.setVerticalAlignment(SwingConstants.TOP);
		btnEdit.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnEdit.setHorizontalAlignment(SwingConstants.RIGHT);
		btnEdit.setPreferredSize(new Dimension(27, 37));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContentEditor frame = new ContentEditor(refreshable, user, content);
				frame.setVisible(true);
			}
		});
		btnEdit.setForeground(new Color(235, 161, 76));
		btnEdit.setFont(new Font("Dialog", Font.BOLD, 15));
		btnEdit.setFocusPainted(false);
		btnEdit.setBackground(new Color(22, 28, 35));
		
		if (content.isCreator(user)) {
			scrollPane.setRowHeaderView(btnEdit);
		}

	}
	
	public String getTitle() {
		return title;
	}
	
}
