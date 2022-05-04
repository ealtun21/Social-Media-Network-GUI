package client.FrontEnd.Main;

import javax.swing.JPanel;
import client.BackEnd.Colors;
import client.BackEnd.Content;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.time.format.DateTimeFormatter;
import javax.swing.JTextPane;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class ContentViewer extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the panel.
	 */
	public ContentViewer(Content content) {
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
		textPane.setFont(new Font("Dialog", Font.PLAIN, 14));
		textPane.setCaretColor(Colors.WHITE);
		textPane.setForeground(Colors.WHITE);
		textPane.setBackground(Colors.GRAY);
		textPane.setText(content.getText());
		scrollPane.setViewportView(textPane);
		
		JLabel title = new JLabel(content.getTitle()+"     "+content.getTime().format(DateTimeFormatter.ofPattern("dd-MM yyyy HH:mm")));
		scrollPane.setColumnHeaderView(title);
		title.setForeground(Colors.WHITE);
		title.setFont(new Font("Dialog", Font.BOLD, 17));
		
	}
}
