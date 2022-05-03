/**
 * 
 */
package client.BackEnd;

import java.time.LocalDateTime;
import java.util.TreeSet;

import javax.swing.Icon;

/**
 * @author Eray Altun
 *
 */
public class Content implements Comparable<Content>{
	private static TreeSet<Content> allContent = new TreeSet<Content>();
	
	private String title; // must be unique;.
	private Icon image;
	private String text;
	private LocalDateTime time;
	
	/**
	 * Initializes a new instance of Content.
	 * @param title
	 * @param text
	 */
	public Content(String title, String text) {
		super();
		setTitle(title);
		this.text = text;
		time = LocalDateTime.now();
		
		allContent.add(this);
	}

	@Override
	public int compareTo(Content content) {
		return content.getTime().compareTo(this.getTime());
	}
	
	// Getter - Setters
	
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 * @return returns the true if the title was not used, and false if the title was used.
	 */
	public boolean setTitle(String title) {
		for (Content content : allContent) {
			if (content.getTitle() == title) {
				return false;
			}
		}
		this.title = title;
		return true;
	}

	public Icon getImage() {
		return image;
	}

	public void setImage(Icon image) {
		this.image = image;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public static TreeSet<Content> getAllContent() {
		return allContent;
	}
	
}
