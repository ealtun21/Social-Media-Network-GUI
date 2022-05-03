package client.FrontEnd.Main;

import javax.swing.JPanel;

import client.BackEnd.Colors;
import client.BackEnd.Content;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;

public class ContentViewer extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ContentViewer(Content content) {
		setBorder(null);
		setBackground(Colors.DARK_GRAY);
		setLayout(null);
		setSize(500,400);
		
		JLabel date = new JLabel(content.getTime().toString());
		date.setForeground(Colors.WHITE);
		date.setLocation(12, 121);
		date.setSize(182,19);
		add(date);
		
		JLabel contentPic = new JLabel("");
		contentPic.setIcon(content.getImage());
		contentPic.setBounds(360, 12, 128, 128);
		add(contentPic);
		
		JLabel title = new JLabel(content.getTitle());
		title.setForeground(Colors.WHITE);
		title.setFont(new Font("Dialog", Font.BOLD, 17));
		title.setBounds(12, 12, 336, 37);
		add(title);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(12, 152, 476, 236);
		add(scrollPane);
		
		JLabel contentText = new JLabel("");
		contentText.setOpaque(true);
		contentText.setBackground(Colors.GRAY);
		contentText.setForeground(Colors.WHITE);
		scrollPane.setViewportView(contentText);
	}
}
